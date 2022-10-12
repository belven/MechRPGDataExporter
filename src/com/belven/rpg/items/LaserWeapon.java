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

		rowData.add(String.valueOf(ID));
		rowData.add(String.valueOf(rangedWeaponID));
		rowData.add(particle);
		return rowData.toArray(new String[0]);
	}

	public static LaserWeapon CreateLaserWeapon(String inName, String inMesh, int inMaxStack, float inRange, float inHealthChange, boolean inHeals, String inParticle) {

		Item i = new Item();
		i.name = inName;
		i.name = inName;
		i.mesh = inMesh;
		i.maxStatck = inMaxStack;

		Weapon w = new Weapon();
		w.range = inRange;
		w.healthChange = inHealthChange;
		w.heals = inHeals;
		w.itemID = i.ID;

		RangedWeapon rw = new RangedWeapon();
		rw.weaponID = w.ID;

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
