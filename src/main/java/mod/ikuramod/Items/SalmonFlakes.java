package mod.ikuramod.Items;

import mod.ikuramod.IkuraMod;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class SalmonFlakes extends Item {
    public SalmonFlakes() {
        this.setUnlocalizedName("SalmonFlakes");
        this.setCreativeTab(IkuraMod.IKURAMODTAB);
        this.setRegistryName(new ResourceLocation(MODID, "SalmonFlakes"));
    }
}
