package de.canitzp.extraadditions.items;

import de.canitzp.extraadditions.ExtraAdditions;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.function.Supplier;

public class ItemOnAStickItem extends Item {
    
    public static final String FURNACE_NAME = "furnace_on_a_stick";
    public static final String ENDER_CHEST_NAME = "enderchest_on_a_stick";
    
    public static final ItemOnAStickItem FURNACE = new ItemOnAStickItem(() -> new SimpleNamedContainerProvider((windowId, inventory, player) -> {
        return new FurnaceContainer(windowId, inventory);
    }, new TranslationTextComponent("container.furnace")));
    public static final ItemOnAStickItem ENDER_CHEST = new ItemOnAStickItem(() -> new SimpleNamedContainerProvider((windowId, inventory, player) -> {
        return ChestContainer.threeRows(windowId, inventory, player.getEnderChestInventory());
    }, new TranslationTextComponent("container.enderchest")));
    
    private Supplier<INamedContainerProvider> container;
    
    private ItemOnAStickItem(Supplier<INamedContainerProvider> container){
        super(new Properties().stacksTo(1).tab(ExtraAdditions.TAB));
        this.container = container;
    }
    
    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        if (!world.isClientSide) {
            NetworkHooks.openGui((ServerPlayerEntity) player, this.container.get());
        }
        return new ActionResult<>(ActionResultType.SUCCESS, player.getItemInHand(hand));
    }
}
