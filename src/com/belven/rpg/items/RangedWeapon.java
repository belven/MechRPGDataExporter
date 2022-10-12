package com.belven.rpg.items;

import java.util.ArrayList;

public class RangedWeapon extends RowData {
	public static ArrayList<RangedWeapon> rangedWeapons = new ArrayList<>();
	public static String RangedWeaponTable = "\\RangedWeaponData.csv";

	int weaponID;

	public RangedWeapon() {
		if (rangedWeapons.size() > 0) {
			ID = GetLastID() + 1;
		}

		rangedWeapons.add(this);

	}
	
	public static RangedWeapon CreateRangedWeapon(int weaponID) {
		RangedWeapon rw = new RangedWeapon();
		rw.weaponID = weaponID;
		return rw;
	}


	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(String.valueOf(ID));
		rowData.add(String.valueOf(weaponID));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return rangedWeapons.get(rangedWeapons.size() - 1).ID;
	}
}