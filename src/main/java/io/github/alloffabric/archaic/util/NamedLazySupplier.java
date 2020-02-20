package io.github.alloffabric.archaic.util;

import com.google.common.base.Preconditions;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class NamedLazySupplier<T> implements Supplier<T> {

    private static final Identifier UNNAMED = new Identifier("unnamed");
    private static final NamedLazySupplier<?> EMPTY = new NamedLazySupplier<>(new Identifier("empty"), null);
    private final Identifier name;
    private Supplier<T> supplier;
    private T value;

    public static <T> NamedLazySupplier<T> of(Supplier<T> delegate) {
        return of(null, delegate);
    }

    public static <T> NamedLazySupplier<T> of(Identifier name, Supplier<T> delegate) {
        Preconditions.checkNotNull(delegate, "delegate supplier must not be null!");
        return new NamedLazySupplier<>(name, delegate);
    }

    private NamedLazySupplier(Identifier name, Supplier<T> delegate) {
        this.name = name != null ? name : UNNAMED;
        this.supplier = delegate;
    }

    public static <T> NamedLazySupplier<T> empty() {
        @SuppressWarnings("unchecked")
        NamedLazySupplier<T> t = (NamedLazySupplier<T>) EMPTY;
        return t;
    }

    public Identifier getName() {
        return name;
    }

    public Optional<T> asOptional() {
        return Optional.ofNullable(this.get());
    }

    @Override
    public T get() {
        if(this.supplier != null) {
            this.value = supplier.get();
            this.supplier = null;
        }
        return this.value;
    }

    public <V> Optional<V> callIfPresent(Function<T, V> function) {
        if(this.isPresent()) {
            return Optional.ofNullable(function.apply(this.value));
        }
        return Optional.empty();
    }

    public boolean isPresent() {
        return this.get() != null;
    }

    public void ifPresent(Consumer<T> action) {
        if(this.isPresent()) {
            action.accept(this.value);
        }
    }
}
