package com.dreammaster.gtppHandler;

import com.dreammaster.item.ItemList;
import com.github.bartimaeusnek.bartworks.util.BWRecipes;
import gregtech.api.util.GT_Recipe;

import java.util.Optional;

public class GTPPMultiBlockNerfer {

    public static void apply() {
        new NoBonusMultiBehavior();

        GT_Recipe.GT_Recipe_Map.sMappings
                .stream()
                .filter(gt_recipe_map -> {
                    Optional<GT_Recipe> op = gt_recipe_map.mRecipeList.stream().findAny();
                    return op.isPresent() && !op.get().mFakeRecipe
                            && !(gt_recipe_map instanceof GT_Recipe.GT_Recipe_Map_Fuel)
                            && !(gt_recipe_map instanceof BWRecipes.SpecialObjectSensitiveMap);
                })
                .map(map -> map.mRecipeList)
                .forEach(
                        gt_recipes ->
                                gt_recipes
                                        .stream()
                                        .filter(recipe -> recipe.mSpecialItems == null)
                                        .forEach(recipe -> recipe.mSpecialItems = ItemList.GTPPNERFCIRCUIT.getIS())
                );
    }
}
