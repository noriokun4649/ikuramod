package mod.ikuramod.Items;

import mod.ikuramod.IkuraMod;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class BakedSalmonFillet extends Item {
    public BakedSalmonFillet() {
        this.setUnlocalizedName("BakedSalmonFillet");
        this.setCreativeTab(IkuraMod.IKURAMODTAB);
        this.setRegistryName(new ResourceLocation(MODID, "BakedSalmonFillet"));
    }
}
