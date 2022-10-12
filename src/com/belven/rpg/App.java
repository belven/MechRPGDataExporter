package com.belven.rpg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.belven.rpg.items.Armour;
import com.belven.rpg.items.ArmourPosition;
import com.belven.rpg.items.Item;
import com.belven.rpg.items.LaserWeapon;
import com.belven.rpg.items.MeleeWeapon;
import com.belven.rpg.items.RangedWeapon;
import com.belven.rpg.items.RowData;
import com.belven.rpg.items.Weapon;
import com.opencsv.CSVWriter;

public class App {
	static ArrayList<RowData> tablesRows = new ArrayList<>();
	static String tablesFolder = "D:\\Unreal Projects\\MechRPG\\Source\\Tables";

	static {
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 1", "Laser 1", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 2", "Laser 2", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 3", "Laser 3", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon("Test Melee Weapon 1", "Melee 1", 1, 500, 30, false, 300));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 4", "Laser 4", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon("Test Melee Weapon 2", "Melee 2", 1, 500, 30, false, 300));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 5", "Laser 5", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(Armour.CreateArmour("Headpiece", "Head", 1, ArmourPosition.Head, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour("Chestpiece", "Chest", 1, ArmourPosition.Chest, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour("Left Arm", "Arm", 1, ArmourPosition.LeftArm, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour("Right Arm", "Arm", 1, ArmourPosition.RightArm, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour("Left Leg", "Leg", 1, ArmourPosition.LeftLeg, 0.1f, 0.1f, 0.1f));
		tablesRows.add(Armour.CreateArmour("Right Leg", "Leg", 1, ArmourPosition.RightLeg, 0.1f, 0.1f, 0.1f));
	}

	public App() {

	}

	public static void SaveData(ArrayList<String[]> data, String filePath) {
		try {
			File csvOutputFile = new File(filePath);
			FileWriter outputfile = new FileWriter(csvOutputFile);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);
			writer.writeAll(data);
			writer.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SaveItems();
		SaveWeapons();
		SaveRangedWeapons();
		SaveLaserWeapons();
		SaveMeleeWeapons();
		SaveArmour();
	}

	private static void SaveArmour() {
		ArrayList<String[]> data = new ArrayList<String[]>();

		for (Armour i : Armour.armour) {
			data.add(i.CreateData());
		}
		SaveData(data, tablesFolder + Armour.ArmourTable);
	}

	public static void SaveItems() {
		ArrayList<String[]> data = new ArrayList<String[]>();

		for (Item i : Item.items) {
			data.add(i.CreateData());
		}
		SaveData(data, tablesFolder + Item.Item_Table);
	}

	public static void SaveWeapons() {
		ArrayList<String[]> data = new ArrayList<String[]>();

		for (Weapon d : Weapon.weapons) {
			data.add(d.CreateData());
		}
		SaveData(data, tablesFolder + Weapon.WeaponTable);
	}

	public static void SaveRangedWeapons() {
		ArrayList<String[]> data = new ArrayList<String[]>();

		for (RangedWeapon d : RangedWeapon.rangedWeapons) {
			data.add(d.CreateData());
		}
		SaveData(data, tablesFolder + RangedWeapon.RangedWeaponTable);
	}

	public static void SaveLaserWeapons() {
		ArrayList<String[]> data = new ArrayList<String[]>();

		for (LaserWeapon d : LaserWeapon.laserWeapons) {
			data.add(d.CreateData());
		}
		SaveData(data, tablesFolder + LaserWeapon.LaserTable);
	}

	public static void SaveMeleeWeapons() {
		ArrayList<String[]> data = new ArrayList<String[]>();

		for (MeleeWeapon d : MeleeWeapon.meleeWeapons) {
			data.add(d.CreateData());
		}
		SaveData(data, tablesFolder + MeleeWeapon.WeaponTable);
	}
}
