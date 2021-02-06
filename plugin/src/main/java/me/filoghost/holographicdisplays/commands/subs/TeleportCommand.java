/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.commands.subs;

import me.filoghost.fcommons.command.sub.SubCommandContext;
import me.filoghost.fcommons.command.validation.CommandException;
import me.filoghost.fcommons.command.validation.CommandValidate;
import me.filoghost.holographicdisplays.Colors;
import me.filoghost.holographicdisplays.commands.HologramCommandValidate;
import me.filoghost.holographicdisplays.commands.HologramSubCommand;
import me.filoghost.holographicdisplays.object.NamedHologram;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;


public class TeleportCommand extends HologramSubCommand {
    
    public TeleportCommand() {
        super("teleport", "tp");
        setMinArgs(1);
        setUsageArgs("<hologram>");
        setDescription("Teleports you to the given hologram.");
    }

    @Override
    public void execute(CommandSender sender, String[] args, SubCommandContext context) throws CommandException {
        Player player = CommandValidate.getPlayerSender(sender);
        NamedHologram hologram = HologramCommandValidate.getNamedHologram(args[0]);
        
        Location loc = hologram.getLocation();
        loc.setPitch(90);
        player.teleport(loc, TeleportCause.PLUGIN);
        player.sendMessage(Colors.PRIMARY + "You were teleported to the hologram named '" + hologram.getName() + "'.");

    }

}
