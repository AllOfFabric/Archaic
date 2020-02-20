package io.github.alloffabric.archaic.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PebbleItem extends Item {

    public PebbleItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (RANDOM.nextFloat() * 0.4F + 0.8F));
        if(!world.isClient) {
            user.addChatMessage(new LiteralText("NOT IMPLEMENTED YET").formatted(Formatting.RED), true);
            //ThrownEggEntity thrownEggEntity = new ThrownEggEntity(world, user);
            //thrownEggEntity.setItem(itemStack);
            //thrownEggEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
            //world.spawnEntity(thrownEggEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if(!user.abilities.creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack);
    }
}
