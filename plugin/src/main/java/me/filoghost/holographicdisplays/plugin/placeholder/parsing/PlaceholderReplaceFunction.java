/*
 * Copyright (C) filoghost and contributors
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
package me.filoghost.holographicdisplays.plugin.placeholder.parsing;

@FunctionalInterface
public interface PlaceholderReplaceFunction {

    String getReplacement(PlaceholderOccurrence placeholderOccurrence);

}