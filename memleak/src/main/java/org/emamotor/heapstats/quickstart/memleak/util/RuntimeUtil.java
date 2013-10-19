package org.emamotor.heapstats.quickstart.memleak.util;

public class RuntimeUtil {

    private static final Runtime RUNTIME = Runtime.getRuntime();
    private RuntimeUtil() {}

    public static long getUsedHeapMemory() {
        return RUNTIME.totalMemory() - RUNTIME.freeMemory();
    }

    public static long getFreeHeapMemory() {
        return RUNTIME.freeMemory();
    }

    public static long getTotalMemory() {
        return RUNTIME.totalMemory();
    }

    public static long getMaxMemory() {
        return RUNTIME.maxMemory();
    }

}
