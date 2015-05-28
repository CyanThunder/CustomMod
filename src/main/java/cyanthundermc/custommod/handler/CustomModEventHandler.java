package cyanthundermc.custommod.handler;

import cyanthundermc.custommod.items.ArmorChestplateOfFlight;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CustomModEventHandler {
    @SubscribeEvent
    public void onLivingEventUpdate(LivingEvent.LivingUpdateEvent event) {
        Entity entity = event.entity;
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;

            ItemStack armorChest = player.getCurrentArmor(2);

            //Wearing Chestplate (true?)?
            if (armorChest != null) {
                //Is it the Chestplate of Flight?
                if (armorChest.getItem() instanceof ArmorChestplateOfFlight && armorChest.getItemDamage() <= 1000) {
                    player.capabilities.allowFlying = true;
                }
                else {
                    if (!player.capabilities.isCreativeMode) {
                        player.capabilities.allowFlying = false;
                    }
                    player.capabilities.isFlying = false;
                }
            }
            else {
                if (!player.capabilities.isCreativeMode && player.capabilities.allowFlying || player.capabilities.isFlying) {
                    player.capabilities.allowFlying = false;
                    player.capabilities.isFlying = false;
                }
            }
        }
    }
}
