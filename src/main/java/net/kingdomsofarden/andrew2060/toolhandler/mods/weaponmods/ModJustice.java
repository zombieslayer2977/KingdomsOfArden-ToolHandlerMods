package net.kingdomsofarden.andrew2060.toolhandler.mods.weaponmods;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;

import com.herocraftonline.heroes.api.events.HeroRegainHealthEvent;
import com.herocraftonline.heroes.api.events.WeaponDamageEvent;
import com.herocraftonline.heroes.characters.Hero;
import com.herocraftonline.heroes.characters.skill.Skill;

import net.kingdomsofarden.andrew2060.toolhandler.mods.typedefs.WeaponMod;

public class ModJustice extends WeaponMod {

	public ModJustice() {
		super("Justice", new String[] {"Attacks deal Bonus 2% Target Max Health Damage","Attacks heal for 1% Target Max Health"}, 1, true);
	}

	@Override
	public void applyToWeapon(ItemStack weapon) {
		return;
	}

	@Override
	public void executeOnWeaponDamage(WeaponDamageEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof LivingEntity)) {
			return;
		}
		LivingEntity lE = (LivingEntity) event.getEntity();
		LivingEntity dE = event.getDamager().getEntity();
		Skill.damageEntity(lE, dE, lE.getMaxHealth()*0.02, DamageCause.ENTITY_ATTACK);
		HeroRegainHealthEvent hEvent = new HeroRegainHealthEvent((Hero) event.getDamager(), lE.getMaxHealth()*0.01, null);
		Bukkit.getPluginManager().callEvent(hEvent);
		if(hEvent.isCancelled()) {
			return;
		}
		double newHealth = dE.getHealth() + hEvent.getAmount();
		if(newHealth > dE.getMaxHealth()) {
			newHealth = dE.getMaxHealth();
		}
		dE.setHealth(newHealth);
	}

}