package com.dreammaster.gtppHandler;

import com.dreammaster.item.ItemList;
import com.dreammaster.main.MainRegistry;
import gtPlusPlus.api.helpers.GregtechPlusPlus_API;
import gtPlusPlus.api.objects.minecraft.multi.SpecialMultiBehaviour;
import net.minecraft.item.ItemStack;

public class NoBonusMultiBehavior extends SpecialMultiBehaviour {

    public NoBonusMultiBehavior() {
        if (!GregtechPlusPlus_API.Multiblock_API.registerSpecialMultiBehaviour(this)){
            MainRegistry.Logger.warn("Failed to register NoBonusMultiBehavior!");
        };
    }

//    uncomment this to disable parallels on GT++ Machines
//    @Override
//    public int getMaxParallelRecipes() {
//        return 1;
//    }

    @Override
    public int getEUPercent() {
        return 0; //NO EXTRA EU!
    }

    @Override
    public int getSpeedBonusPercent() {
        return 0; //NO EXTRA SPEED!
    }

    @Override
    public int getOutputChanceRoll() {
        return 10000; //NO EXTRA ITEMS!
    }

    @Override
    public ItemStack getTriggerItem() {
        return ItemList.GTPPNERFCIRCUIT.getIS();
    }

    @Override
    public String getTriggerItemTooltip() {
        return "Disables all GT++ Boni";
    }
}
