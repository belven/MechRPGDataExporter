package com.belven.rpg.items;

import java.util.ArrayList;

public class MeleeWeapon extends RowData {
	public static ArrayList<MeleeWeapon> meleeWeapons = new ArrayList<>();
	public static String WeaponTable = "\\MeleeWeaponData.csv";

	int weaponID;
	float cleaveRadius;

	public MeleeWeapon() {
		if (meleeWeapons.size() > 0) {
			ID = GetLastID() + 1;
		}

		meleeWeapons.add(this);
	}

	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(String.valueOf(ID));
		rowData.add(String.valueOf(weaponID));
		rowData.add(String.valueOf(cleaveRadius));
		return rowData.toArray(new String[0]);
	}

	public static MeleeWeapon CreateMeleeWeapon(String inName, String inMesh, int inMaxStack, float inRange, float inHealthChange, boolean inHeals, float inCleaveRadius) {
		Item i = Item.CreateItem(inName, inMesh, inMaxStack, ItemType.Weapon);
		Weapon w = Weapon.CreateWeapon(i.ID, inRange, inHealthChange, inHeals, WeaponType.Melee);

		MeleeWeapon mw = new MeleeWeapon();
		mw.cleaveRadius = inCleaveRadius;
		mw.weaponID = w.ID;
		return mw;
	}

	@Override
	public int GetLastID() {
		return meleeWeapons.get(meleeWeapons.size() - 1).ID;
	}
}
