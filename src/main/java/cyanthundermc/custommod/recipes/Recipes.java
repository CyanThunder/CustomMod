package cyanthundermc.custommod.recipes;

import cyanthundermc.custommod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class Recipes {
    public static void addRecipes() {
        //ArmorChestplateOfFlight Repair 'Refuel' Recipe
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.armorChestOfFlight, 1, 250), new Object[]{
                new ItemStack(ModItems.armorChestOfFlight, 1, OreDictionary.WILDCARD_VALUE),
                Items.coal,
                Items.coal,
                Items.coal,
                Items.coal,
                Items.coal,
                Items.coal
        });

        //ArmorChestplateOfFlight Crafting Recipe (TEMP|TEMP|TEMP)
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.armorChestOfFlight, 1, 1000), new Object[]{
                "FNF",
                "FDF",
                "EBE",
                'F', Blocks.furnace,
                'N', Items.nether_star,
                'D', Items.diamond_chestplate,
                'E', Items.feather,
                'B', Blocks.diamond_block
        });
    }
}
