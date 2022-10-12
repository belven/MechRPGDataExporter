package com.belven.rpg;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

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
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 1", "Some Mesh 1", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 2", "Some Mesh 2", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 3", "Some Mesh 3", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon("Test Laser Weapon 4", "Some Mesh 4", 1, 500, 30, false, 300));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 5", "Some Mesh 5", 1, 500, 30, false, "Particle Path"));
		tablesRows.add(MeleeWeapon.CreateMeleeWeapon("Test Laser Weapon 6", "Some Mesh 6", 1, 500, 30, false, 300));
		tablesRows.add(LaserWeapon.CreateLaserWeapon("Test Laser Weapon 7", "Some Mesh 7", 1, 500, 30, false, "Particle Path"));
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
