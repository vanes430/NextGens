package com.muhammaddaffa.nextgens.utils;

import com.muhammaddaffa.nextgens.NextGens;
import com.tcoded.folialib.FoliaLib;
import com.tcoded.folialib.wrapper.task.WrappedTask;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.concurrent.TimeUnit;

public class FoliaHelper {

    private static FoliaLib foliaLib;

    public static void setup(NextGens nextGens) {
        foliaLib = new FoliaLib(nextGens);
    }

    public static void runAtLocation(Location location, Runnable runnable) {
        foliaLib.getScheduler().runAtLocation(location, task -> runnable.run());
    }

    public static void runAtLocationLater(Location location, Runnable runnable, long delay) {
        foliaLib.getScheduler().runAtLocationLater(location, runnable, delay);
    }

    public static void runAtEntity(Entity entity, Runnable runnable) {
        foliaLib.getScheduler().runAtEntity(entity, task -> runnable.run());
    }

    public static void runLater(Runnable runnable, long delay) {
        foliaLib.getScheduler().runLater(runnable, delay);
    }

    public static void runAsync(Runnable runnable) {
        foliaLib.getScheduler().runAsync(task -> runnable.run());
    }

    public static void runAsyncLater(Runnable runnable, long delay) {
        foliaLib.getScheduler().runLaterAsync(task -> runnable.run(), delay);
    }

    public static WrappedTask runAsyncTimer(Runnable runnable, long delay, long period) {
        return foliaLib.getScheduler().runTimerAsync(runnable, delay, period);
    }

    public static void runSync(Runnable runnable) {
        foliaLib.getScheduler().runNextTick(task -> runnable.run());
    }

    public static WrappedTask runSyncTimer(Runnable runnable, long delay, long period) {
        return foliaLib.getScheduler().runTimer(runnable, delay, period);
    }

    public static void cancel(Object task) {
        if (task instanceof WrappedTask) {
            ((WrappedTask) task).cancel();
        }
    }
}
