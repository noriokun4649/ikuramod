package mod.ikuramod.Items;

import mod.ikuramod.IkuraMod;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class IkuraGunkan extends Item {
    public IkuraGunkan() {
        this.setUnlocalizedName("IkuraGunkan");
        this.setCreativeTab(IkuraMod.IKURAMODTAB);
        this.setRegistryName(new ResourceLocation(MODID, "IkuraGunkan"));
    }
}
