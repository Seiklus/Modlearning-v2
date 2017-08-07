package net.seiklus.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.seiklus.TarotCard;

public class ItemPageCard extends Item {

    //this is to give the register information about the pagecard item
    public ItemPageCard()  {
        setRegistryName("pagecard");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(TarotCard.MODID + ".pagecard");     // Used for localization (en_US.lang)
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.MISC);
    }

    //this is to load the model in the game using the json file in assets
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }


}

