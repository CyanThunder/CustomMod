package cyanthundermc.custommod.materials;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {
    public static ArmorMaterial armorFlight;
    public static void addMaterials(){
        armorFlight = EnumHelper.addArmorMaterial("MaterialFlight", "", 0, new int[]{0, 8, 0, 0}, 10);
    }
}
