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
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TwMod.MODID)
    @Mod.EventBusSubscriber

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
                    output.accept(ItemInit.FIRST_ITEM.get());
                    output.accept(BlockInit.firstBlock.get());
                    output.accept(ItemInit.first_food.get());
                })
        );
    }

    private void addItemsToTabs(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.COMBAT)
        {
            event.accept(ItemInit.FIRST_ITEM);
        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(BlockInit.firstBlock);
        }
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ItemInit.first_food);
        }
    }

}