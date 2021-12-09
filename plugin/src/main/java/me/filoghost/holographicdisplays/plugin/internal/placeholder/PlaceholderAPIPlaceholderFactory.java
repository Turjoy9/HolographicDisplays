/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.plugin.internal.placeholder;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;
import me.filoghost.holographicdisplays.api.beta.placeholder.IndividualPlaceholder;
import me.filoghost.holographicdisplays.api.beta.placeholder.IndividualPlaceholderFactory;
import me.filoghost.holographicdisplays.plugin.bridge.placeholderapi.PlaceholderAPIHook;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlaceholderAPIPlaceholderFactory implements IndividualPlaceholderFactory {

    @Override
    public @Nullable IndividualPlaceholder getPlaceholder(@Nullable String argument) {
        if (argument == null) {
            return null;
        }
        return new PlaceholderAPIPlaceholder(argument);
    }


    private static class PlaceholderAPIPlaceholder implements IndividualPlaceholder {

        private final String identifier;
        private final String params;

        PlaceholderAPIPlaceholder(String content) {
            int separatorIndex = content.indexOf('_');
            if (separatorIndex >= 0) {
                identifier = content.substring(0, separatorIndex).toLowerCase();
                params = content.substring(separatorIndex + 1);
            } else {
                identifier = null;
                params = null;
            }
        }

        @Override
        public int getRefreshIntervalTicks() {
            return 1;
        }

        @Override
        public @Nullable String getReplacement(@NotNull Player player, @Nullable String argument) {
            if (PlaceholderAPIHook.isEnabled() && identifier != null) {
                PlaceholderHook placeholderHook = PlaceholderAPI.getPlaceholders().get(identifier);
                if (placeholderHook != null) {
                    return placeholderHook.onPlaceholderRequest(player, params);
                }
            }
            return null;
        }

    }

}
