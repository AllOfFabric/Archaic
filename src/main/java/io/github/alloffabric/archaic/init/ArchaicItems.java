package io.github.alloffabric.archaic.init;

import io.github.alloffabric.archaic.Archaic;
import io.github.alloffabric.archaic.item.PebbleItem;
import io.github.alloffabric.archaic.util.NamedLazySupplier;
import io.github.alloffabric.archaic.util.ModCompatHelper;
import io.github.alloffabric.archaic.util.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class ArchaicItems {

    public static final RegistryHelper<Item> ITEMS = new RegistryHelper<>(Archaic.MODID, Registry.ITEM);

    public static final NamedLazySupplier<Item> PEBBLE = ITEMS.register("pebble", () -> new PebbleItem(new Item.Settings().group(ItemGroup.MISC)));
    public static final NamedLazySupplier<Item> STONE_ROD = ITEMS.register("stone_rod", () -> new Item(new Item.Settings().group(ItemGroup.MATERIALS)));

    //vanilla chunks
    public static final NamedLazySupplier<Item> STONE_CHUNK = ITEMS.register("stone_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> COAL_CHUNK = ITEMS.register("coal_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> IRON_CHUNK = ITEMS.register("iron_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> GOLD_CHUNK = ITEMS.register("gold_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> REDSTONE_CHUNK = ITEMS.register("redstone_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> DIAMOND_CHUNK = ITEMS.register("diamond_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> EMERALD_CHUNK = ITEMS.register("emerald_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> NETHER_CHUNK = ITEMS.register("nether_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));
    public static final NamedLazySupplier<Item> END_CHUNK = ITEMS.register("end_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)));

    //tech reborn chunks
    public static final NamedLazySupplier<Item> BAUXITE_CHUNK = ITEMS.register("bauxite_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> COPPER_CHUNK = ITEMS.register("copper_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> TIN_CHUNK = ITEMS.register("tin_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> LEAD_CHUNK = ITEMS.register("lead_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> SILVER_CHUNK = ITEMS.register("silver_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> GALENA_CHUNK = ITEMS.register("galena_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> IRIDIUM_CHUNK = ITEMS.register("iridium_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> TUNGSTEN_CHUNK = ITEMS.register("tungsten_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> SODALITE_CHUNK = ITEMS.register("sodalite_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> SHELDONITE_CHUNK = ITEMS.register("sheldonite_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> PERIDOT_CHUNK = ITEMS.register("peridot_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> RUBY_CHUNK = ITEMS.register("ruby_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> SAPPHIRE_CHUNK = ITEMS.register("sapphire_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> NETHER_CINNABAR_CHUNK = ITEMS.register("nether_cinnabar_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> NETHER_PYRITE_CHUNK = ITEMS.register("nether_pyrite_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> NETHER_SPHALERITE_CHUNK = ITEMS.register("nether_sphalerite_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> END_SHELDONITE_CHUNK = ITEMS.register("end_sheldonite_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> END_SODALITE_CHUNK = ITEMS.register("end_sodalite_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> END_TUNGSTEN_CHUNK = ITEMS.register("end_tungsten_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);
    public static final NamedLazySupplier<Item> END_PERIDOT_CHUNK = ITEMS.register("end_peridot_chunk", () -> new Item(new Item.Settings().group(Archaic.CHUNKS_ITEM_GROUP)), ModCompatHelper.ID_TECH_REBORN);

}
