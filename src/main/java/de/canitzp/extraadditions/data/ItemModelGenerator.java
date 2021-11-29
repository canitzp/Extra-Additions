package de.canitzp.extraadditions.data;

import de.canitzp.extraadditions.ExtraAdditions;
import de.canitzp.extraadditions.items.ItemOnAStickItem;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper helper){
        super(generator, ExtraAdditions.MODID, helper);
    }
    
    @Override
    protected void registerModels(){
        singleTexture(ItemOnAStickItem.FURNACE_NAME, mcLoc("item/handheld"), "layer0", modLoc("item/" + ItemOnAStickItem.FURNACE_NAME));
        singleTexture(ItemOnAStickItem.ENDER_CHEST_NAME, mcLoc("item/handheld"), "layer0", modLoc("item/" + ItemOnAStickItem.ENDER_CHEST_NAME));
    }
}
