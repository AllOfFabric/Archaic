package io.github.alloffabric.archaic.init;

import io.github.alloffabric.archaic.Archaic;
import io.github.alloffabric.archaic.util.NamedLazySupplier;
import io.github.alloffabric.archaic.util.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;

public class ArchaicBlocks {

    public static final RegistryHelper<Block> BLOCKS = new RegistryHelper<>(Archaic.MODID, Registry.BLOCK);
    public static final NamedLazySupplier<Block> DEFAULT_STONE = BLOCKS.register("default_stone", () -> new Block(Block.Settings.copy(Blocks.STONE)));
    public static final NamedLazySupplier<Block> MINERAL_STONE = BLOCKS.register("mineral_stone", () -> new Block(Block.Settings.copy(Blocks.STONE)));
    public static final NamedLazySupplier<Block> RICH_MINERAL_STONE = BLOCKS.register("rich_mineral_stone", () -> new Block(Block.Settings.copy(Blocks.STONE)));
    public static final NamedLazySupplier<Block> GEODE = BLOCKS.register("geode", () -> new Block(Block.Settings.copy(Blocks.STONE)));
    public static final NamedLazySupplier<Block> NETHER_MINERAL_STONE = BLOCKS.register("nether_mineral_stone", () -> new Block(Block.Settings.copy(Blocks.STONE)));
    public static final NamedLazySupplier<Block> NETHER_GEODE = BLOCKS.register("nether_geode", () -> new Block(Block.Settings.copy(Blocks.STONE)));
    public static final NamedLazySupplier<Block> END_MINERAL_STONE = BLOCKS.register("end_mineral_stone", () -> new Block(Block.Settings.copy(Blocks.STONE)));
    public static final NamedLazySupplier<Block> END_GEODE = BLOCKS.register("end_geode", () -> new Block(Block.Settings.copy(Blocks.STONE)));
}
