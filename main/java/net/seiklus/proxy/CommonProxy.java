package net.seiklus.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.seiklus.Config;
import net.seiklus.item.ItemPageCard;

import java.io.File;

@Mod.EventBusSubscriber
public class CommonProxy {

    //Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e) {

        //this part reads the tarotCard file from config folder.
        File directory =
                e.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(),"tarotCard.cfg"));
        Config.readConfig();
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemPageCard());
    }
}