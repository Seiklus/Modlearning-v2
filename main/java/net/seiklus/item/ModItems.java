package net.seiklus.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.seiklus.item.ItemPageCard;

public class ModItems {

    //this tells the game (use the specific name for the specific item
    @GameRegistry.ObjectHolder("tarot:pagecard")
    public static ItemPageCard pageCard;


    //this initializes all models from every individual item
    @SideOnly(Side.CLIENT)
    public static void initModels() {
        pageCard.initModel();
    }
}


