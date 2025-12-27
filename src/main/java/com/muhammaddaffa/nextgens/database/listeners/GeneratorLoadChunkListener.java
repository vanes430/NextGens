package com.muhammaddaffa.nextgens.database.listeners;

import com.muhammaddaffa.nextgens.NextGens;
import com.muhammaddaffa.nextgens.database.ChunkCoord;
import com.muhammaddaffa.nextgens.generators.managers.GeneratorManager;
import com.muhammaddaffa.nextgens.utils.FoliaHelper;
import org.bukkit.Chunk;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.world.ChunkLoadEvent;

import java.util.List;

public record GeneratorLoadChunkListener(
        GeneratorManager generatorManager
) implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    private void onChunkLoad(ChunkLoadEvent event) {
        Chunk chunk = event.getChunk();
        handleChunkLoad(chunk.getWorld().getName(), chunk.getX(), chunk.getZ());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    private void onMove(PlayerMoveEvent event) {
        int fromX = event.getFrom().getBlockX() >> 4;
        int fromZ = event.getFrom().getBlockZ() >> 4;
        int toX = event.getTo().getBlockX() >> 4;
        int toZ = event.getTo().getBlockZ() >> 4;

        if (fromX == toX && fromZ == toZ && event.getFrom().getWorld().equals(event.getTo().getWorld())) return;
        
        handleChunkLoad(event.getTo().getWorld().getName(), toX, toZ);
    }

    private void handleChunkLoad(String worldName, int x, int z) {
        ChunkCoord key = new ChunkCoord(worldName, x, z);
        // If the chunk is already loaded, skip this
        if (!NextGens.LOADED_CHUNKS.add(key)) return;

        List<String> list = this.generatorManager.getGeneratorsByChunk().get(key);
        if (list == null || list.isEmpty()) return;

        // Proceed to load the active generators
        FoliaHelper.runAsync(() -> this.generatorManager.loadActiveGenerator(key, list));
    }

}