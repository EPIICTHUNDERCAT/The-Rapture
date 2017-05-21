package com.github.epiicthundercat.item;

import com.github.epiicthundercat.creativetabs.TRCreativeTab;
import net.minecraft.item.ItemSword;

public class TRItemSword extends ItemSword {
    public TRItemSword(ToolMaterial material) {
        super(material);
        setRegistryName(name.toLowerCase());
        setUnlocalizedName(name.toLowerCase());
        setCreativeTab(TRCreativeTab.RTabs);
        addToItems(this);
    }
}
