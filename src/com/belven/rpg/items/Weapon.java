package com.belven.rpg.items;

import java.util.ArrayList;

public class Weapon extends RowData {
	public static ArrayList<Weapon> weapons = new ArrayList<>();
	public static String WeaponTable = "\\WeaponData.csv";

	int itemID;
	float range;
	float healthChange;
	boolean heals;
	WeaponType type;

	public Weapon() {
		if (weapons.size() > 0) {
			ID = GetLastID() + 1;
		}

		weapons.add(this);
	}

	public static Weapon CreateWeapon(int itemID, float range, float healthChange, boolean heals, WeaponType type) {
		Weapon iw = new Weapon();
		iw.itemID = itemID;
		iw.range = range;
		iw.healthChange = healthChange;
		iw.heals = heals;
		iw.type = type;
		return iw;
	}

	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(String.valueOf(ID));
		rowData.add(String.valueOf(itemID));
		rowData.add(type.toString());
		rowData.add(String.valueOf(range));
		rowData.add(String.valueOf(healthChange));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return weapons.get(weapons.size() - 1).ID;
	}
}
