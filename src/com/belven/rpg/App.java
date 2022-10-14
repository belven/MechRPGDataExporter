package com.belven.rpg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.belven.rpg.items.Armour;
import com.belven.rpg.items.ArmourPosition;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.ItemData;
import com.belven.rpg.items.LaserWeapon;
import com.belven.rpg.items.MeleeWeapon;
import com.belven.rpg.items.RangedWeapon;
import com.belven.rpg.items.RowData;
import com.belven.rpg.items.Weapon;
import com.belven.rpg.items.WeaponData;
import com.opencsv.CSVWriter;

public class App {
	static ArrayList<RowData> tablesRows = new ArrayList<>();
	static String tablesFolder = "D:\\Unreal Projects\\MechRPG\\Source\\Tables";

	static {
		tablesRows.add(LaserWeapon.CreateLaserWeapon(new ItemData("Test Laser Weapon 1", "Laser 1", 1), new WeaponData(500, 30, false), 1, "Particle Path"));
		tablesRows.add(LaserWeapon.CreateLaserWeapon(new ItemData("Test Laser Weapon 2", "Laser 2", 1), new WeaponData(500, 30, false), 1, "Particle Path"));
		tablesRows.add(LaserWeapon.CreateLaserWeapon(new ItemData("Test Laser Weapon 3", "Laser 3", 1), new WeaponData(500, 30, false), 1, "Particle Path"));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Test Melee Weapon 1", "Melee 1", 1), new WeaponData(500, 30, false), 300));
		tablesRows.add(LaserWeapon.CreateLaserWeapon(new ItemData("Test Laser Weapon 4", "Laser 4", 1), new WeaponData(500, 30, false), 1, "Particle Path"));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon(new ItemData("Test Melee Weapon 2", "Melee 2", 1), new WeaponData(500, 30, false), 300));
		tablesRows.add(LaserWeapon.CreateLaserWeapon(new ItemData("Test Laser Weapon 5", "Laser 5", 1), new WeaponData(500, 30, false), 1, "Particle Path"));
		tablesRows.add(Armour.CreateArmour(new ItemData("Headpiece", "Head", 1), ArmourPosition.Head, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour(new ItemData("Chestpiece", "Chest", 1), ArmourPosition.Chest, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour(new ItemData("Left Arm", "Arm", 1), ArmourPosition.LeftArm, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour(new ItemData("Right Arm", "Arm", 1), ArmourPosition.RightArm, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour(new ItemData("Left Leg", "Leg", 1), ArmourPosition.LeftLeg, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour(new ItemData("Right Leg", "Leg", 1), ArmourPosition.RightLeg, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour(new ItemData("Left Arm", "Arm", 1), ArmourPosition.LeftArm, 0.1f, 0.1f, 0.1f));
	}

	public static void SaveData(ArrayList<String[]> data, String filePath) {
		try {
			File csvOutputFile = new File(filePath);
			FileWriter outputfile = new FileWriter(csvOutputFile);
			CSVWriter writer = new CSVWriter(outputfile);
			writer.writeAll(data);
			writer.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SaveRowData(Item.items);
		SaveRowData(Weapon.weapons);
		SaveRowData(RangedWeapon.rangedWeapons);	
		SaveRowData(LaserWeapon.laserWeapons);	
		SaveRowData(MeleeWeapon.meleeWeapons);	
		SaveRowData(Armour.armour);	
	}

	static <T extends RowData> void SaveRowData(ArrayList<T> data) {
		ArrayList<String[]> dataStrings = new ArrayList<String[]>();

		for (T d : data) {
			dataStrings.add(CreateData(d));
		}
		SaveData(dataStrings, tablesFolder + data.get(0).tableName);
	}

	private static String[] CreateData(RowData row) {
		return row.CreateData();
	}
}