package cyanthundermc.custommod.items;

import cyanthundermc.custommod.materials.ModMaterials;
import net.minecraft.item.Item;

public class ModItems {
    //Declare Item Variables
    //Items

    //Armor
    public static Item armorChestOfFlight;

    public static void init() {
        //<editor-fold desc="Items">
        //</editor-fold>

        //<editor-fold desc="Armor">
        armorChestOfFlight = new ArmorChestplateOfFlight(ModMaterials.armorFlight, 1);
        //</editor-fold>
    }
}
