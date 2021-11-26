package de.canitzp.extraadditions.items;

import de.canitzp.extraadditions.ExtraAdditions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class FurnaceOnAStickItem extends Item {
    
    public static final String NAME = "furnace_on_a_stick";
    public static final FurnaceOnAStickItem ITEM = new FurnaceOnAStickItem();
    
    private static final ITextComponent CONTAINER_TITLE = new TranslationTextComponent("container.furnace");
    
    private FurnaceOnAStickItem(){
        super(new Properties().stacksTo(1).tab(ExtraAdditions.TAB));
    }
    
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        if (!world.isClientSide) {
            NetworkHooks.openGui((ServerPlayerEntity) player, new SimpleNamedContainerProvider((windowId, playerInventory, playerEntity) -> new FurnaceContainer(windowId, playerInventory), CONTAINER_TITLE));
        }
        return new ActionResult<>(ActionResultType.SUCCESS, player.getItemInHand(hand));
    }
}
