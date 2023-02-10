package com.belven.rpg.items;

public class ArmourResistanceData {
	int armourID;
	float resistanceValue;
	DamageType type;
	
	public ArmourResistanceData(float resistanceValue, DamageType type) {
		this.resistanceValue = resistanceValue;
		this.type = type;
	}	
}
