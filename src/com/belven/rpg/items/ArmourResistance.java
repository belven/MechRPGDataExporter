package com.belven.rpg.items;

import java.util.ArrayList;

public class ArmourResistance extends RowData {
	public static String ArmourResistanceTable = "\\ArmourResistanceData.csv";
	public static ArrayList<ArmourResistance> ArmourResistances = new ArrayList<>();
	
	private ArmourResistanceData data;

	public ArmourResistance(ArmourResistanceData data) {
		super(ArmourResistanceTable);
		
		this.data = data;
		
		if (ArmourResistances.size() > 0) {
			ID = GetLastID() + 1;
		}

		ArmourResistances.add(this);
	}
	
	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(GetString(data.armourID));
		rowData.add(GetString(data.resistanceValue));
		rowData.add(data.type.toString());
		return rowData.toArray(new String[0]);
	}

	@Override
	public int GetLastID() {
		return ArmourResistances.get(ArmourResistances.size() - 1).ID;
	}

	public ArmourResistanceData getData() {
		return data;
	}

	public static ArmourResistance CreateArmourResistance(ArmourResistanceData ard) {
		return new ArmourResistance(ard);
	}
}
