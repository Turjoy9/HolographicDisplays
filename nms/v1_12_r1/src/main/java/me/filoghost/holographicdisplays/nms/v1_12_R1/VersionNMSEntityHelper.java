/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.nms.v1_12_R1;

import me.filoghost.holographicdisplays.core.nms.entity.NMSEntityHelper;
import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityTrackerEntry;
import net.minecraft.server.v1_12_R1.Packet;
import net.minecraft.server.v1_12_R1.WorldServer;

public class VersionNMSEntityHelper extends NMSEntityHelper<EntityTrackerEntry> {

    private final Entity entity;

    public VersionNMSEntityHelper(Entity entity) {
        this.entity = entity;
    }
    
    @Override
    protected EntityTrackerEntry getTracker0() {
        return ((WorldServer) entity.world).tracker.trackedEntities.get(entity.getId());
    }

    public void broadcastPacket(Packet<?> packet) {
        EntityTrackerEntry tracker = getTracker();
        if (tracker != null) {
            tracker.broadcast(packet);
        }
    }

}