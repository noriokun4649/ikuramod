package mod.ikuramod.Blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;
import static mod.ikuramod.Items.ItemSet.RICE;
import static mod.ikuramod.Items.ItemSet.RICE_PRANT;

public class BlockIne extends BlockCrops {
    public BlockIne() {
        this.setUnlocalizedName("blockine");
        this.setRegistryName(new ResourceLocation(MODID, "blockine"));
    }

    @Override
    protected Item getSeed() {
        return RICE_PRANT;
    }

    @Override
    protected Item getCrop() {
        return RICE;
    }
}
