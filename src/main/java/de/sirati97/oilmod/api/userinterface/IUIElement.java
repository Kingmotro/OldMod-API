package de.sirati97.oilmod.api.userinterface;

import de.sirati97.oilmod.api.userinterface.internal.NMSClickData;
import de.sirati97.oilmod.api.userinterface.internal.NMSUIElement;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by sirati97 on 16.06.2016 for OilMod-Api.
 */
public interface IUIElement {
    /**
     *
     * @param index the <b>local</b> index of the element
     * @return ItemStack at given slot. Element does not have to behave different with different index, but it is possible
     */
    ItemStack getDisplayed(int index);

    /**
     * Sets ItemStack at given slot. Element does not have to behave different with different index, but it is possible
     * @param index the <b>local</b> index of the element
     */
    void setDisplayed(int index, ItemStack itemStack);

    /**
     * Called when Element got clicked. Element does not have to behave different with different index, but it is possible
     * @param player The player using the ui
     * @param index The <b>local</b> index of the element
     * @param data Only important for NMS Callbacks
     */
    void onClick(Player player, int index, Click click, NMSClickData data);

    /**
     * Sets NMS Version of this Element
     */
    void setNmsWrapper(NMSUIElement nmsWrapper);

    /**
     * @return NMS Version of this Element
     */
    NMSUIElement getNmsWrapper();
}
