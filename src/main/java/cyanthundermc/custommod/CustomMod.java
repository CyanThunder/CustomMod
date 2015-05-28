package cyanthundermc.custommod;

import cyanthundermc.custommod.blocks.ModBlocks;
import cyanthundermc.custommod.handler.CustomModEventHandler;
import cyanthundermc.custommod.items.ModItems;
import cyanthundermc.custommod.materials.ModMaterials;
import cyanthundermc.custommod.recipes.Recipes;
import cyanthundermc.custommod.reference.ModReference;
import cyanthundermc.custommod.utility.LogHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static net.minecraftforge.fml.common.Mod.EventHandler;

@Mod(modid = ModReference.MODID, name = ModReference.MODNAME, version = ModReference.VERSION)
public class CustomMod {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("Pre-Init Started");
        //<editor-fold desc="PreInitialization">
        ModMaterials.addMaterials();
        ModBlocks.init();
        ModItems.init();
        //</editor-fold>
        LogHelper.info("Pre-Init Finished");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.info("Init Started");
        //<editor-fold desc="Initialization">
        Recipes.addRecipes();


        MinecraftForge.EVENT_BUS.register(new CustomModEventHandler());
        FMLCommonHandler.instance().bus().register(new CustomModEventHandler());
        //</editor-fold>
        LogHelper.info("Init Complete");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("Post-Init Started");
        //<editor-fold desc="PostInitialization">
        //</editor-fold>
        LogHelper.info("Post-Init Complete");
    }

    //Add Creative Tab Item
    public static final CreativeTabs CreativeTab = new CreativeTabs(ModReference.MODNAME) {
        @Override
        public Item getTabIconItem() {
            return Items.item_frame;
        }

        @Override
        public String getTranslatedTabLabel() {
            return ModReference.MODNAME;
        }
    };
}
