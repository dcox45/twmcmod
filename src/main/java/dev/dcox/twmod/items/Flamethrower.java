package dev.dcox.twmod.items;

import dev.dcox.twmod.ClientAccess;
import dev.dcox.twmod.TwMod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

import java.util.List;

public class Flamethrower extends Item {
    public Flamethrower(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(hand == InteractionHand.MAIN_HAND && !level.isClientSide()) {
            Vec3 look = player.getLookAngle();
            Vec3 eyePos = player.getEyePosition(1.0f);
            for(int i = 0; i < 4; i++) {
                SmallFireball fireballentity = new SmallFireball(level, player, look.x * 1.5, look.y * 1.5, look.z * 1.5);
                fireballentity.setPos(eyePos.x  +look.x * (i + 1), eyePos.y + look.y * (i + 1), eyePos.z + look.z * (i + 1));
                level.addFreshEntity(fireballentity);
            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        super.appendHoverText(stack, level, components, flag);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientAccess.advancedItemTooltip(components));


    }
}
