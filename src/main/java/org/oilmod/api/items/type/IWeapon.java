package org.oilmod.api.items.type;

import org.oilmod.api.items.OilItemStack;

public interface IWeapon extends IUnique {

    default int getMaxStackSize() {
        return 1;
    }
}
