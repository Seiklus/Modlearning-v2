package net.seiklus.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.seiklus.TarotCard;

public class ItemPageCard extends ItemEgg {


    public ItemPageCard()  {
        setRegistryName("pagecard");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName(TarotCard.MODID + ".pagecard");     // Used for localization (en_US.lang)
        this.maxStackSize = 4;
        this.setCreativeTab(CreativeTabs.MISC);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);


        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {

            worldIn.createExplosion(null,playerIn.getPosition().getX(),
                                    playerIn.getPosition().getY(),
                                    playerIn.getPosition().getZ(),10,true);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

}

