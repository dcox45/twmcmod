package dev.dcox.twmod;


import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.vehicle.Minecart;

import java.util.List;

public class ClientAccess {

    public static void advancedItemTooltip(List<Component> components) {
        if(Minecraft.getInstance().player.isShiftKeyDown()){
            components.add(Component.literal("Press \u00A7Shift \u00A7for more Info"));
        } else {
            components.add(Component.literal("Flamethrower"));
        }

    }

}
