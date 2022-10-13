package com.belven.rpg.items;

import java.util.ArrayList;

public class LaserWeapon extends RowData {
	public static ArrayList<LaserWeapon> laserWeapons = new ArrayList<>();
	public static String LaserTable = "\\LaserWeaponData.csv";
	int rangedWeaponID;
	String particle;

	public LaserWeapon() {
		if (laserWeapons.size() > 0) {
			ID = GetLastID() + 1;
		}

		laserWeapons.add(this);
	}

	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(rangedWeaponID));
		rowData.add(particle);
		return rowData.toArray(new String[0]);
	}

	public static LaserWeapon CreateLaserWeapon(String inName, String inMesh, int inMaxStack, float inRange, float inHealthChange, boolean inHeals, float accuracy, String inParticle) {
		Item i = Item.CreateItem(inName, inMesh, inMaxStack, ItemType.Weapon);
		Weapon w = Weapon.CreateWeapon(i.ID, inRange, inHealthChange, inHeals, WeaponType.Laser);
		RangedWeapon rw = RangedWeapon.CreateRangedWeapon(w.ID, accuracy);

		LaserWeapon lw = new LaserWeapon();
		lw.particle = inParticle;
		lw.rangedWeaponID = rw.ID;
		return lw;
	}

	@Override
	public int GetLastID() {
		return laserWeapons.get(laserWeapons.size() - 1).ID;
	}

}
