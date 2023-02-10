package dev.dcox.twmod;
        
import dev.dcox.twmod.init.BlockInit;
import dev.dcox.twmod.init.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TwMod.MODID)
@EventBusSubscriber

public class TwMod{

    public static final String MODID = "twmod";

    public static CreativeModeTab MY_TAB;

    public TwMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::registerTabs);
        bus.addListener(this::addItemsToTabs);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

    }

    private void registerTabs(CreativeModeTabEvent.Register event)
    {
        MY_TAB = event.registerCreativeModeTab(new ResourceLocation(MODID, "main_tab"), builder -> builder
                .icon(() -> new ItemStack(ItemInit.FIRST_ITEM.get()))
                .title(Component.translatable("TW Tab"))
                .displayItems((featureFlags, output, hasOp) -> {
                    //for(int i = 0; i < ItemInit.ITEMS.getEntries().size())
                    output.accept(ItemInit.FIRST_ITEM.get());
                    output.accept(ItemInit.firestoneShard.get());
                    output.accept(ItemInit.FLAMETHROWER.get());


                    output.accept(BlockInit.firstBlock.get());
                    output.accept(BlockInit.FIRESTONE_ORE.get());
                    output.accept(BlockInit.HAZARDOUS_WASTE.get());


                    output.accept(ItemInit.first_food.get());

                    output.accept(ItemInit.myAxe_tool.get());
                    output.accept(ItemInit.myHoe_tool.get());
                    output.accept(ItemInit.myPickaxe_tool.get());
                    output.accept(ItemInit.myShovel_tool.get());
                    output.accept(ItemInit.mySword_tool.get());

                    output.accept(ItemInit.firestone_helmet.get());
                    output.accept(ItemInit.firestone_chestplate.get());
                    output.accept(ItemInit.firestone_leggings.get());
                    output.accept(ItemInit.firestone_boots.get());

                })
        );
    }

    private void addItemsToTabs(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.COMBAT)
        {
            event.accept(ItemInit.FIRST_ITEM);
            event.accept(ItemInit.FLAMETHROWER);

        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(BlockInit.firstBlock);
            event.accept(BlockInit.HAZARDOUS_WASTE);

        }
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(BlockInit.FIRESTONE_ORE);
        }
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ItemInit.first_food);
        }
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            event.accept(ItemInit.myAxe_tool);
            event.accept(ItemInit.myPickaxe_tool);
            event.accept(ItemInit.myHoe_tool);
            event.accept(ItemInit.myShovel_tool);
            event.accept(ItemInit.mySword_tool);
        }
        if (event.getTab() == CreativeModeTabs.COMBAT)
        {
            event.accept(ItemInit.firestone_helmet);
            event.accept(ItemInit.firestone_chestplate);
            event.accept(ItemInit.firestone_leggings);
            event.accept(ItemInit.firestone_boots);

        }
        if (event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ItemInit.firestoneShard);
        }
    }

}