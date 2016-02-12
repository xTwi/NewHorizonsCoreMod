package com.dreammaster.main;

import com.dreammaster.modbabychest.ContainerBabyChest;
import com.dreammaster.modbabychest.GuiBabyChest;
import com.dreammaster.modbabychest.TileEntityBabyChest;
import com.dreammaster.modlootbags.ContainerLootBag;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public static int GUI_BABYCHEST = 1;
    public static int GUI_LOOTBAG = 2;

    @Override
    public Object getServerGuiElement(int pGuiID, EntityPlayer pPlayer, World pWorld, int pX, int pY, int pZ)
    {
        if (pGuiID == GUI_BABYCHEST)
        {
            TileEntity tTileEntity = pWorld.getTileEntity(pX, pY, pZ);
            if (tTileEntity instanceof TileEntityBabyChest) return new ContainerBabyChest(pPlayer.inventory, (TileEntityBabyChest) tTileEntity);
        }
        else
            if (pGuiID == GUI_LOOTBAG)
            {
                return new ContainerLootBag(pPlayer, pPlayer.inventory, new InventoryItem(pPlayer.getHeldItem()));
            }

        return null;
    }

    @Override
    public Object getClientGuiElement(int pGuiID, EntityPlayer pPlayer, World pWorld, int pX, int pY, int pZ)
    {
        if (pGuiID == GUI_BABYCHEST)
        {
            TileEntity tTileEntity = pWorld.getTileEntity(pX, pY, pZ);
            if (tTileEntity instanceof TileEntityBabyChest) return new GuiBabyChest(pPlayer.inventory, (TileEntityBabyChest) tTileEntity);
        }
        else
            if (pGuiID == GUI_LOOTBAG)
            {
                return null;
            }

        return null;
    }
}
