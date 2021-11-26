package de.canitzp.extraadditions.data;

import de.canitzp.extraadditions.ExtraAdditions;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ExtraAdditions.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExtraAdditionsData {

    @SubscribeEvent
    public static void runGenerator(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();
        
        generateItemModels(generator, helper);
    }
    
    private static void generateItemModels(DataGenerator generator, ExistingFileHelper helper){
        generator.addProvider(new ItemModelGenerator(generator, helper));
    }
}
