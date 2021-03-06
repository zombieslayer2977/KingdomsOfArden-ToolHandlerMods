package net.kingdomsofarden.andrew2060.toolhandler.mods.weaponmods;

import java.util.UUID;

import com.herocraftonline.heroes.api.events.WeaponDamageEvent;

import net.kingdomsofarden.andrew2060.toolhandler.mods.typedefs.WeaponMod;

public class ModBolt extends WeaponMod {

	public ModBolt() {
		super(UUID.fromString("5eff2d00-a1de-11e3-a5e2-0800200c9a66"),"Bolt", 20, true);
		setBonusDamage(5.00);
		setCritChance(5.00);
	}

	@Override
	public void executeOnWeaponDamage(WeaponDamageEvent event) {
		return;
	}

}
