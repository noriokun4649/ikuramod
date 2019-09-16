package mod.ikuramod.Blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;
import static mod.ikuramod.Items.ItemSet.SOY;

public class BlockSoy extends BlockCrops {
    public BlockSoy() {
        this.setUnlocalizedName("blocksoy");
        this.setRegistryName(new ResourceLocation(MODID, "blocksoy"));
    }

    @Override
    protected Item getSeed() {
        return SOY;
    }

    @Override
    protected Item getCrop() {
        return SOY;
    }
}
