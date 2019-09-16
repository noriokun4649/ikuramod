package mod.ikuramod.Drop;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static mod.ikuramod.Items.ItemSet.RICE_PRANT;
import static mod.ikuramod.Items.ItemSet.SOY;

public class DropSet {
    @SubscribeEvent
    public void onDropSet(BlockEvent.HarvestDropsEvent event) {
        if (event.getState().getBlock() == Blocks.TALLGRASS) {
            EntityItem entityItem;
            Random random = new Random();
            int randoms = random.nextInt(30);
            if (randoms != 0) return;
            Item playeritem = event.getHarvester().getHeldItem(EnumHand.MAIN_HAND).getItem();
            if (playeritem == null) return;
            ArrayList<Item> hoe_1 = new ArrayList<>();
            ArrayList<Item> hoe_2 = new ArrayList<>();
            Collections.addAll(hoe_1, Items.WOODEN_HOE, Items.STONE_HOE, Items.IRON_HOE);
            Collections.addAll(hoe_2, Items.DIAMOND_HOE, Items.GOLDEN_HOE);
            if (hoe_1.indexOf(playeritem) != -1) {
                entityItem = new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(RICE_PRANT));
            } else if (hoe_2.indexOf(playeritem) != -1) {
                entityItem = new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(SOY));
            } else return;
            event.getWorld().spawnEntity(entityItem);
        }
    }
}
