package net.kingdomsofarden.andrew2060.toolhandler.mods.weapon;

import org.bukkit.inventory.ItemStack;

import com.herocraftonline.heroes.api.events.WeaponDamageEvent;

import net.kingdomsofarden.andrew2060.toolhandler.mods.typedefs.WeaponMod;
import net.kingdomsofarden.andrew2060.toolhandler.util.WeaponLoreUtil;

public class ModBrute extends WeaponMod {
	public ModBrute() {
		super("Brute", "+4 Bonus Damage", 16, true);
	}

	@Override
	public void applyToWeapon(ItemStack weapon) {
		WeaponLoreUtil.setBonusDamage(WeaponLoreUtil.getBonusDamage(weapon)+4, weapon);
	}

	@Override
	public void executeOnWeaponDamage(WeaponDamageEvent event) {
		return;
	}

}