package org.oilmod.api.items.crafting;

import org.oilmod.api.items.OilBukkitItemStack;
import org.bukkit.inventory.ItemStack;

/**
 * Created by sirati97 on 24.03.2016.
 */
public abstract class VanillaIngredientBase extends OilIngredientBase {

    @Override
    public boolean match(ItemStack itemStack2, DataHolder dataHolder) {
        return !(itemStack2 instanceof OilBukkitItemStack);
    }
}
