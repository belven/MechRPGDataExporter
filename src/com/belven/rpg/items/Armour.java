package com.belven.rpg.items;

import java.util.ArrayList;

public class Armour extends RowData {
	public static String ArmourTable = "\\ArmourData.csv";
	public static ArrayList<Armour> armour = new ArrayList<>();

	int itemID;
	ArmourPosition armourPosition;
	float physicalResistance;
	float blastResistance;
	float energyResistance;

	public Armour() {
		if (armour.size() > 0) {
			ID = GetLastID() + 1;
		}

		armour.add(this);
	}

	public static Armour CreateArmour(String name, String mesh, int maxStatck, ArmourPosition armourPosition, float physicalResistance, float blastResistance, float energyResistance) {
		Item i = Item.CreateItem(name, mesh, maxStatck, ItemType.Armour);
		Armour a = new Armour();
		a.itemID = i.ID;
		a.armourPosition = armourPosition;
		a.physicalResistance = physicalResistance;
		a.blastResistance = blastResistance;
		a.energyResistance = energyResistance;
		return a;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(itemID));
		rowData.add(armourPosition.toString());
		rowData.add(GetString(physicalResistance));
		rowData.add(GetString(blastResistance));
		rowData.add(GetString(energyResistance));
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return armour.get(armour.size() - 1).ID;
	}

}
