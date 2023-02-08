package dev.dcox.twmod.init;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.base.FireArmorMaterial;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
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
            ITEMS.register("mysword_tool", () -> new SwordItem(
                    ToolTiers.example_tier, 5, 3.5f,props()));
    public static final RegistryObject<PickaxeItem> myPickaxe_tool =
            ITEMS.register("mypickaxe_tool", () -> new PickaxeItem(
                    ToolTiers.example_tier, 5, 3.5f, props()));
    public static final RegistryObject<ShovelItem> myShovel_tool =
            ITEMS.register("myshovel_tool", () -> new ShovelItem(
                    ToolTiers.example_tier, 5, 3.5f, props()));
    public static final RegistryObject<AxeItem> myAxe_tool =
            ITEMS.register("myaxe_tool", () -> new AxeItem(
                    ToolTiers.example_tier, 7f, 5.0f, props()));
    public static final RegistryObject<HoeItem> myHoe_tool =
            ITEMS.register("myhoe_tool", () -> new HoeItem(
                    ToolTiers.example_tier, 5, 3.5f, props()));

    public static final RegistryObject<ArmorItem> firestone_helmet =
            ITEMS.register("firestone_helmet", () -> new ArmorItem(
                    ArmorTiers.firestone, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> firestone_chestplate =
            ITEMS.register("firestone_chestplate", () -> new ArmorItem(
                    ArmorTiers.firestone, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> firestone_leggings =
            ITEMS.register("firestone_leggings", () -> new ArmorItem(
                    ArmorTiers.firestone, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> firestone_boots =
            ITEMS.register("firestone_boots", () -> new ArmorItem(
                    ArmorTiers.firestone, EquipmentSlot.FEET, props()));

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
                        .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600),
                                0.9f).build();
    }

    public static class ToolTiers {
        public static final Tier example_tier = new ForgeTier(
                4, 2200, 8.0f, 3.0f, 10, null, () ->
            Ingredient.of(ItemInit.FIRST_ITEM.get()));
    }

    public static class ArmorTiers {
        public static final ArmorMaterial firestone = new FireArmorMaterial(
                "firestone",
                500,
                new int[] {20,40,50,10},
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ItemInit.FIRST_ITEM.get()));
    }

}
