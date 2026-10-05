package com.antarip.barrelextender.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BarrelBlockEntity.class)
public abstract class BarrelBlockEntityMixin {
    @Shadow
    private NonNullList<ItemStack> items;

    @Inject(method = "<init>(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At("TAIL"), require = 0)
    private void barrelextender$expandAfterConstruct(BlockPos pos, BlockState state, CallbackInfo ci) {
        barrelextender$ensureSize();
    }

    @Inject(method = "getItems", at = @At("HEAD"), require = 0)
    private void barrelextender$onGetItems(CallbackInfoReturnable<NonNullList<ItemStack>> cir) {
        barrelextender$ensureSize();
    }

    @Inject(method = "setItems", at = @At("TAIL"), require = 0)
    private void barrelextender$onSetItems(NonNullList<ItemStack> list, CallbackInfo ci) {
        barrelextender$ensureSize();
    }

    @Inject(method = "getContainerSize", at = @At("HEAD"), cancellable = true)
    private void barrelextender$size(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(54);
    }

    @Inject(method = "createMenu", at = @At("HEAD"), cancellable = true)
    private void barrelextender$createScreenHandler(int syncId, Inventory playerInventory, CallbackInfoReturnable<AbstractContainerMenu> cir) {
        barrelextender$ensureSize();
        cir.setReturnValue(ChestMenu.sixRows(syncId, playerInventory, (Container) (Object) this));
    }

    @Unique
    private void barrelextender$ensureSize() {
        if (this.items != null && this.items.size() >= 54) {
            return;
        }
        NonNullList<ItemStack> expanded = NonNullList.withSize(54, ItemStack.EMPTY);
        if (this.items != null) {
            for (int i = 0; i < this.items.size(); i++) {
                expanded.set(i, this.items.get(i));
            }
        }
        this.items = expanded;
    }
}