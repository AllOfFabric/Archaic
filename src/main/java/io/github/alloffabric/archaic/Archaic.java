package io.github.alloffabric.archaic;

import io.github.alloffabric.archaic.init.ArchaicBlocks;
import io.github.alloffabric.archaic.init.ArchaicItems;
import io.github.alloffabric.archaic.util.ItemProvider;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.jetbrains.annotations.Nullable;

public class Archaic implements ModInitializer {

    public static final String MODID = "archaic";
    private static final Logger log = LogManager.getLogger(MODID);
    public static final boolean DEBUG_MODE = Boolean.getBoolean("archaic.debug");
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "items"), () -> new ItemStack(Items.IRON_PICKAXE));
    public static final ItemGroup CHUNKS_ITEM_GROUP = ItemGroup.MATERIALS;

    static {
        @Nullable String debugLevel = System.getProperty("archaic.debug.level");
        if(DEBUG_MODE || debugLevel != null) {
            Configurator.setLevel(MODID, Level.toLevel(debugLevel, Level.ALL));
        }
    }

    public static Logger getLogger() {
        return log;
    }

    public static Identifier id(String name) {
        return new Identifier(MODID, name);
    }

    @Override
    public void onInitialize() {
        ArchaicBlocks.BLOCKS.fillRegistry().forEach((name, block) -> {
            @Nullable Item blockItem = block instanceof ItemProvider ? ((ItemProvider) block).createItem() : new BlockItem(block, new Item.Settings().group(Archaic.ITEM_GROUP));
            if(blockItem != null) {
                ArchaicItems.ITEMS.register(name.getPath(), () -> blockItem);
            }
        });
        ArchaicItems.ITEMS.fillRegistry();
    }
}
