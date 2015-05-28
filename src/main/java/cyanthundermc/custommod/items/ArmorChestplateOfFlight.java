package cyanthundermc.custommod.items;

import cyanthundermc.custommod.CustomMod;
import cyanthundermc.custommod.reference.ModReference;
import cyanthundermc.custommod.utility.LogHelper;
import cyanthundermc.custommod.utility.PlayerUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

public class ArmorChestplateOfFlight extends ItemArmor {

    private String name = "ChestOfFlight";

    public ArmorChestplateOfFlight(ArmorMaterial material, int armorType) {
        super(material, 0, armorType);
        setUnlocalizedName(ModReference.MODID + "_" + name);
        setCreativeTab(CustomMod.CreativeTab);
        setMaxDamage(1000);
        GameRegistry.registerItem(this, name);
    }

    int tick = 0;
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (tick == 100) {
            if (itemStack.getItemDamage() < 1000)
                if (player.capabilities.isFlying && !player.capabilities.isCreativeMode)
                    itemStack.setItemDamage(itemStack.getItemDamage() + 1);

            if (itemStack.getItemDamage() == 950 || itemStack.getItemDamage() == 975 || itemStack.getItemDamage() == 990 || itemStack.getItemDamage() == 999) {
                PlayerUtils.sendChat(player, EnumChatFormatting.RED + "Fuel Level Low! Fuel Left: " + itemStack.getItemDamage() + "/" + itemStack.getMaxDamage());
            }
            tick = 0;
        }
        tick++;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        tooltip.add("Fuel: " + (1000 - stack.getItemDamage()) + "/" + stack.getMaxDamage());
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
