package com.belven.rpg.items;

public class WeaponData {
	int itemID;
	float range;
	float healthChange;
	boolean heals;
	WeaponType type;		


	public WeaponData( float range, float healthChange, boolean heals) {
		this.range = range;
		this.healthChange = healthChange;
		this.heals = heals;
	}
}