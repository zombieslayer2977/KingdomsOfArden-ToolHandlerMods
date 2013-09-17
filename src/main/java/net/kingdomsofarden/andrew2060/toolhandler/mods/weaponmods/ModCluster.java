package net.kingdomsofarden.andrew2060.toolhandler.mods.weaponmods;

import java.util.Iterator;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import com.herocraftonline.heroes.api.events.WeaponDamageEvent;
import com.herocraftonline.heroes.characters.skill.Skill;

import net.kingdomsofarden.andrew2060.toolhandler.mods.typedefs.WeaponMod;

public class ModCluster extends WeaponMod {

	public ModCluster() {
		super("Cluster", 4, true, "Attacks deal 30% splash damage");
		setBonusDamage(2.00);
		setLifeSteal(1.00);
		setCritChance(5.00);
	}

	@Override
	public void executeOnWeaponDamage(WeaponDamageEvent event) {
		if(event.isCancelled() || !(event.getEntity() instanceof LivingEntity)) {
			return;
		}
		Entity target = event.getEntity();
		Iterator<Entity> near = target.getNearbyEntities(3, 3, 3).iterator();
		Player p = (Player) event.getDamager().getEntity();
		double amount = event.getDamage() * 1.0D/3.0D;
		while(near.hasNext()) {
			Entity next = near.next();
			if(!(next instanceof LivingEntity)) {
				continue;
			} else {
				LivingEntity lE = (LivingEntity)next;
				if(next.equals(target)|| lE.equals(event.getDamager().getEntity())) {
					continue;
				}
				if(!Skill.damageCheck(p, lE)) {
					continue;
				} else {
					Skill.damageEntity(lE, p, amount, DamageCause.ENTITY_ATTACK);
				}
			}
		}
		return;
	}

}
