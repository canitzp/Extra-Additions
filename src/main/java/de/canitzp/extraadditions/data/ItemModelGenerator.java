package de.canitzp.extraadditions.data;

import de.canitzp.extraadditions.ExtraAdditions;
import de.canitzp.extraadditions.items.FurnaceOnAStickItem;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper helper){
        super(generator, ExtraAdditions.MODID, helper);
    }
    
    @Override
    protected void registerModels(){
        singleTexture(FurnaceOnAStickItem.NAME, mcLoc("item/handheld"), "layer0", modLoc("item/" + FurnaceOnAStickItem.NAME));
    }
}
