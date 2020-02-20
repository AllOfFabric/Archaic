package io.github.alloffabric.archaic.util;

import io.github.alloffabric.archaic.init.ArchaicBlocks;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.Lazy;

public class LootTableMerger {

    private static final Lazy<Identifier> DEFAULT_STONE_LOOT_TABLE = new Lazy<>(() -> ArchaicBlocks.GEODE.get().getDropTableId());
    private static final Lazy<Identifier> MINERAL_STONE_LOOT_TABLE = new Lazy<>(() -> ArchaicBlocks.MINERAL_STONE.get().getDropTableId());
    private static final Lazy<Identifier> RICH_MINERAL_STONE_LOOT_TABLE = new Lazy<>(() -> ArchaicBlocks.RICH_MINERAL_STONE.get().getDropTableId());

    public static void init() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, lootTableID, fabricLootSupplierBuilder, lootTableSetter) -> {
            if(lootTableID.equals(DEFAULT_STONE_LOOT_TABLE.get())) {

            }
        });
    }
}
