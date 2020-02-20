package io.github.alloffabric.archaic.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import io.github.alloffabric.archaic.Archaic;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * @author UpcraftLP
 */
public class RegistryHelper<T> {

    private final String modid;
    private final Registry<T> registry;
    private final Map<Identifier, Supplier<T>> toRegister = new TreeMap<>();

    public RegistryHelper(String modid, Registry<T> registry) {
        this.modid = modid;
        this.registry = registry;
    }

    public Map<Identifier, T> fillRegistry() {
        final ImmutableMap.Builder<Identifier, T> builder = ImmutableMap.builder();
        toRegister.forEach((identifier, supplier) -> {
            try {
                T object = supplier.get();
                Preconditions.checkNotNull(object, "supplier for registry object %s returned null", identifier);
                Archaic.getLogger().trace("registering {}: {}", () -> object.getClass().getSimpleName(), () -> identifier);
                builder.put(identifier, Registry.register(this.registry, identifier, object));
            }
            catch (Exception e) {
                Archaic.getLogger().error("exception thrown during registration", e);
            }
        });
        toRegister.clear();
        return builder.build();
    }

    public <V extends T> NamedLazySupplier<V> register(String name, Supplier<V> object, String... requiredMods) {
        BooleanSupplier shouldLoad = requiredMods.length == 0 ? () -> true : () -> Arrays.stream(requiredMods).anyMatch(ModCompatHelper::isModLoaded);
        return register(name, object, shouldLoad);
    }

    @SuppressWarnings("unchecked")
    public <V extends T> NamedLazySupplier<V> register(String name, Supplier<V> object, BooleanSupplier shouldLoad) {
        final Identifier regId = new Identifier(this.modid, name);
        if(!shouldLoad.getAsBoolean()) {
            return NamedLazySupplier.empty();
        }
        if(toRegister.put(regId, (Supplier<T>) object) != null) {
            Archaic.getLogger().warn("Tried to register {} twice! Old value will be overwritten!", regId);
        }
        return NamedLazySupplier.of(regId, () -> (V) this.registry.getOrEmpty(regId).orElseThrow(() -> new NoSuchElementException(String.format("tried to retrieve registry value for %s, but was not registered!", regId))));
    }
}
