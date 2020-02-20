package io.github.alloffabric.archaic.util;

import it.unimi.dsi.fastutil.objects.Object2BooleanArrayMap;
import it.unimi.dsi.fastutil.objects.Object2BooleanMap;
import net.fabricmc.loader.api.FabricLoader;

@SuppressWarnings("SpellCheckingInspection")
public class ModCompatHelper {
    public static final String ID_TECH_REBORN = "techreborn";
    private static final Object2BooleanMap<String> MOD_LOADED_LOOKUP = new Object2BooleanArrayMap<>();

    public static boolean isModLoaded(String modid) {
        return MOD_LOADED_LOOKUP.computeBooleanIfAbsent(modid, id -> FabricLoader.getInstance().isModLoaded(id));
    }
}
