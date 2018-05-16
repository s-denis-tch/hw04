package com.sokolov.hw04;

import javax.management.ListenerNotFoundException;
import javax.management.NotificationEmitter;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;

public class Sled {
	private static Info gcInformer = new Info();

    public static void startSled() {
        for(GarbageCollectorMXBean mBean: ManagementFactory.getGarbageCollectorMXBeans()) {
            ((NotificationEmitter) mBean).addNotificationListener(gcInformer, null, null);
        }
    }

    public static void stopSled() {
        for(GarbageCollectorMXBean mBean: ManagementFactory.getGarbageCollectorMXBeans()) {
            try {
                ((NotificationEmitter) mBean).removeNotificationListener(gcInformer);
            } catch(ListenerNotFoundException e) {
            }
        }
    }
}