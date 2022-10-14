package com.belven.rpg.items;

import java.util.ArrayList;

public class LaserWeapon extends RowData {
	public static ArrayList<LaserWeapon> laserWeapons = new ArrayList<>();
	public static String LaserTable = "\\LaserWeaponData.csv";
	int rangedWeaponID;
	String particle;

	public LaserWeapon() {
		super(LaserTable);
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

	public static LaserWeapon CreateLaserWeapon(ItemData itemData, WeaponData data, float accuracy, String inParticle) {
		itemData.type = ItemType.Weapon;
		Item i = Item.CreateItem(itemData);
		
		data.itemID = i.ID;
		data.type = WeaponType.Laser;
		Weapon w = Weapon.CreateWeapon(data);
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
