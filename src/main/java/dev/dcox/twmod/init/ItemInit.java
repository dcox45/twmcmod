package dev.dcox.twmod.init;

import dev.dcox.twmod.TwMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TwMod.MODID);

    public static final RegistryObject<Item> FIRST_ITEM =
              ITEMS.register("first_item", () -> new Item(props()));


    public static final RegistryObject<Item> first_food =
            ITEMS.register("first_food", () -> new Item(props().food(Foods.first_food)));

    public static final RegistryObject<SwordItem> mySword_tool =
            ITEMS.register("mysword_tool", () -> new SwordItem
                    (Tiers.example_tier, 5, 3.5f,props()));
    public static final RegistryObject<PickaxeItem> myPickaxe_tool =
            ITEMS.register("mypickaxe_tool", () -> new PickaxeItem(
                    Tiers.example_tier, 5, 3.5f, props()));
    public static final RegistryObject<ShovelItem> myShovel_tool =
            ITEMS.register("myshovel_tool", () -> new ShovelItem(
                    Tiers.example_tier, 5, 3.5f, props()));
    public static final RegistryObject<AxeItem> myAxe_tool =
            ITEMS.register("myaxe_tool", () -> new AxeItem(
                    Tiers.example_tier, 5f, 3.5f, props()));
    public static final RegistryObject<HoeItem> myHoe_tool =
            ITEMS.register("myhoe_tool", () -> new HoeItem(
                    Tiers.example_tier, 5, 3.5f, props()));

    private static Item.Properties props() {
        return new Item.Properties();
    }


    public static class Foods {
        public static final FoodProperties first_food =
                new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(0.3f)
                        .alwaysEat()
                        .meat()
                        .fast()
                        .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600),
                                0.9f).build();
    }

    public static class Tiers {
        public static final Tier example_tier = new ForgeTier(
                4, 2200, 5.0f, 3, 350, null, () ->
            Ingredient.of(ItemInit.FIRST_ITEM.get()));
    }
}
