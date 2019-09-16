package mod.ikuramod.Items;

import mod.ikuramod.IkuraMod;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class IkuraRiceDon extends Item {
    public IkuraRiceDon() {
        this.setUnlocalizedName("IkuraRiceDon");
        this.setCreativeTab(IkuraMod.IKURAMODTAB);
        this.setRegistryName(new ResourceLocation(MODID, "IkuraRiceDon"));
    }
}
