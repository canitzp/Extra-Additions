package de.canitzp.extraadditions;

import de.canitzp.extraadditions.items.FurnaceOnAStickItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
@Mod(ExtraAdditions.MODID)
public class ExtraAdditions {
    
    public static final String MODID = "extraadditions";
    
    private static final Logger LOGGER = LogManager.getLogger("Extra Additions");

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    
    public static final ItemGroup TAB = new ItemGroup(MODID) {
        @Override
        public ItemStack makeIcon(){
            return FurnaceOnAStickItem.ITEM.getDefaultInstance();
        }
    };
    
    public ExtraAdditions() {
        LOGGER.info("Extra Additions loading...");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //modEventBus.addListener(this::setup);
        //modEventBus.addListener(this::doClientStuff);
        
        this.registerItems();
        
        ITEMS.register(modEventBus);
        
        LOGGER.info("Mod event bus registering done.");
    }
    
    private void registerItems(){
        ITEMS.register(FurnaceOnAStickItem.NAME, () -> FurnaceOnAStickItem.ITEM);
    }

    /*private void setup(final FMLCommonSetupEvent event){
        LOGGER.info("PreInit phase of Extra Additions");
        LOGGER.info("Thank you for using!");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Client init phase of Extra Additions");
    }*/

}
