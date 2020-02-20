package io.github.alloffabric.archaic.util;

import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;


public interface ItemProvider {

    /**
     * @return the item to be registered for this block, or {@code null} if no item should be registered
     */
    @Nullable
    Item createItem();
}
