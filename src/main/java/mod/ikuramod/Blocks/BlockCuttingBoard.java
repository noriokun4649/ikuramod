package mod.ikuramod.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class BlockCuttingBoard extends BaseCuttingBoardBlock {
    public BlockCuttingBoard(Material materialIn) {
        super(materialIn);
        this.setUnlocalizedName("block_cb");
        this.setRegistryName(new ResourceLocation(MODID, "block_cb"));
    }
}
