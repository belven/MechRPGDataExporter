package com.belven.rpg.items;

import java.util.ArrayList;

public class Armour extends RowData {
	public static String ArmourTable = "\\ArmourData.csv";
	public static ArrayList<Armour> armour = new ArrayList<>();

	int itemID;
	ArmourPosition armourPosition;

	public Armour() {
		super(ArmourTable);
		if (armour.size() > 0) {
			ID = GetLastID() + 1;
		}

		armour.add(this);
	}

	public static Armour CreateArmour(ItemData itemData, ArmourPosition armourPosition, ArmourResistanceData... resistances) {
		itemData.type = ItemType.Armour;
		Item i = Item.CreateItem(itemData);
		Armour a = new Armour();
		a.itemID = i.ID;
		a.armourPosition = armourPosition;
		
		for(ArmourResistanceData ard : resistances) {
			ard.armourID = a.ID;
			ArmourResistance.CreateArmourResistance(ard);			
		}
		
		return a;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(itemID));
		rowData.add(armourPosition.toString());
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return armour.get(armour.size() - 1).ID;
	}

}
