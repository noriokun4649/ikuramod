package mod.ikuramod.Items;

import mod.ikuramod.IkuraMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class RicePrant extends ItemSeeds {

    public RicePrant(Block crops, Block soil) {
        super(crops, soil);
        this.setUnlocalizedName("RicePrant");
        this.setCreativeTab(IkuraMod.IKURAMODTAB);
        this.setRegistryName(new ResourceLocation(MODID, "RicePrant"));
    }
}
