package org.oilmod.api.util;

import org.apache.commons.lang.Validate;
import org.oilmod.api.OilMod;

import java.util.regex.Pattern;

public class OilKey {
    public static final Pattern alphanumericalPattern = Pattern.compile("^[a-z0-9_]*$");
    private OilMod mod;
    private String keyString;
    private NMSKey nmsKey;

    private OilKey(OilMod mod, String keyString) {
        this.mod = mod;
        this.keyString = keyString;
    }

    /**
     *
     * @param mod Mod this key is associated to.
     * @param keyString Short unique string. Restricted to lowercase alphanumerical characters and underscores. Do not change it later, otherwise your mod becomes incompatible with older versions of you mod. This will be used to identify content of this mod and will be visible to admins and players with cheat perms
     * @return Returns an unique key.
     */
    public static OilKey create(OilMod mod, String keyString) {
        Validate.isTrue(alphanumericalPattern.matcher(keyString).find(), "Only lowercase alphanumerical characters and underscores are allowed");
        OilKey result = new OilKey(mod, keyString);
        result.nmsKey = OilUtil.UtilImpl.getInstance().registerOilKey(result);
        return result;
    }

    public OilMod getMod() {
        return mod;
    }

    public NMSKey getNmsKey() {
        return nmsKey;
    }

    public String getKeyString() {
        return keyString;
    }

    @Override
    public String toString() {
        return mod.toString() + ":" + keyString;
    }

    @Override
    public int hashCode() {
        return nmsKey.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof OilKey && nmsKey.equals(((OilKey) obj).nmsKey);
    }
}
