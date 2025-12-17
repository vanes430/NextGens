package com.muhammaddaffa.nextgens.utils.fastinv;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FastInvManager {

    private static final Set<FastInv> inventories = ConcurrentHashMap.newKeySet();
    private static final AtomicBoolean registered = new AtomicBoolean(false);

    private FastInvManager() {
        throw new UnsupportedOperationException();
    }

    public static void register(Plugin plugin) {
        if (registered.getAndSet(true)) {
            return;
        }
        Bukkit.getPluginManager().registerEvents(new InventoryListener(plugin), plugin);
    }

    static void add(FastInv inv) {
        inventories.add(inv);
    }

    static void remove(FastInv inv) {
        inventories.remove(inv);
    }

    public static void closeAll() {
        for (FastInv inv : inventories) {
            inv.getInventory().getViewers().forEach(viewer -> {
                if (viewer instanceof Player) {
                    viewer.closeInventory();
                }
            });
        }
        inventories.clear();
    }

    public static final class InventoryListener implements Listener {

        private final Plugin plugin;

        public InventoryListener(Plugin plugin) {
            this.plugin = plugin;
        }

        @EventHandler
        public void onInventoryClick(InventoryClickEvent e) {
            if (e.getInventory().getHolder() instanceof FastInv) {
                FastInv inv = (FastInv) e.getInventory().getHolder();
                e.setCancelled(true);
                inv.onClick(e);
            }
        }

        @EventHandler
        public void onInventoryOpen(InventoryOpenEvent e) {
            if (e.getInventory().getHolder() instanceof FastInv) {
                FastInv inv = (FastInv) e.getInventory().getHolder();
                inv.onOpen(e);
            }
        }

        @EventHandler
        public void onInventoryClose(InventoryCloseEvent e) {
            if (e.getInventory().getHolder() instanceof FastInv) {
                FastInv inv = (FastInv) e.getInventory().getHolder();
                inv.onClose(e);
                FastInvManager.remove(inv);
            }
        }

        @EventHandler
        public void onPluginDisable(PluginDisableEvent e) {
            if (e.getPlugin() == plugin) {
                closeAll();
                registered.set(false);
            }
        }
    }
}
