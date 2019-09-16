package mod.ikuramod.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class BlockVeryCuttingBoard extends BaseCuttingBoardBlock {
    public BlockVeryCuttingBoard(Material materialIn) {
        super(materialIn);
        this.setUnlocalizedName("block_very_cb");
        this.setRegistryName(new ResourceLocation(MODID, "block_very_cb"));
    }

}
