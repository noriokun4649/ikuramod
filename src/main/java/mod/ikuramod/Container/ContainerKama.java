package mod.ikuramod.Container;

import mod.ikuramod.TileEntity.TileEntityKama;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerKama extends Container {
    private TileEntityKama tileEntity;
    /**
     * かまどのインベントリの第一スロットの番号
     */
    private static final int index0 = 0;
    /**
     * プレイヤーのインベントリの第一スロットの番号
     */
    private static final int index1 = 3;
    /**
     * クイックスロットの第一スロットの番号
     */
    private static final int index2 = 30;
    /**
     * このコンテナの全体のスロット数
     */
    private static final int index3 = 39;

    public ContainerKama(EntityPlayer player, TileEntityKama tileEntity) {
        this.tileEntity = tileEntity;
        tileEntity.openInventory(player);
        this.addSlotToContainer(new Slot(tileEntity, 0, 140, 35));
        this.addSlotToContainer(new Slot(tileEntity, 1, 80, 35));
        this.addSlotToContainer(new Slot(tileEntity, 2, 8, 53));
        for (int iy = 0; iy < 3; iy++) {
            for (int ix = 0; ix < 9; ix++) {
                this.addSlotToContainer(new Slot(player.inventory, ix + (iy * 9) + 9, 8 + (ix * 18), 84 + (iy * 18)));
            }
        }
        for (int ix = 0; ix < 9; ix++) {
            this.addSlotToContainer(new Slot(player.inventory, ix, 8 + (ix * 18), 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUsableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotNumber) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot) inventorySlots.get(slotNumber);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if (index0 <= slotNumber && slotNumber < index1) {
// プレゼントボックスのインベントリならプレイヤーのインベントリに移動。
                if (!this.mergeItemStack(itemStack1, index1, index3, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (index1 <= slotNumber && slotNumber < index2) {
// プレイヤーのインベントリならクイックスロットに移動。
                    if (!this.mergeItemStack(itemStack1, index2, index3, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index2 <= slotNumber && slotNumber < index3 && !this.mergeItemStack(itemStack1, index1, index2, false)) {
// クイックスロットからプレイヤーのインベントリに移動できなかったら終了。
                    return ItemStack.EMPTY;
                }
            }
            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            slot.onTake(player, itemStack1);
        }
        return itemStack;
    }
}
