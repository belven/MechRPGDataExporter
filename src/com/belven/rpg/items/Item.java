package com.belven.rpg.items;

import java.util.ArrayList;

public class Item extends RowData {
	public static String Item_Table = "\\ItemData.csv";
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	protected String name;
	protected String mesh;
	protected int maxStatck;

	public Item() {
		if (items.size() > 0) {
			ID = GetLastID() + 1;
		}
		
		items.add(this);
	}

	
	@Override
	public int GetLastID() {
		return items.get(items.size() - 1).ID;
	}


	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(String.valueOf(ID));
		rowData.add(name);
		rowData.add(mesh);
		rowData.add(String.valueOf(maxStatck));
		return rowData.toArray(new String[0]);
	}	
}
