package com.belven.rpg.items;

import java.util.ArrayList;

public class Item extends RowData {
	public static String Item_Table = "\\ItemData.csv";
	public static ArrayList<Item> items = new ArrayList<Item>();

	protected String name;
	protected String mesh;
	protected int maxStatck;
	protected ItemType type;

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

	public static Item CreateItem(String name, String mesh, int maxStatck, ItemType type) {
		Item i = new Item();
		i.name = name;
		i.mesh = mesh;
		i.maxStatck = maxStatck;
		i.type = type;
		return i;
	}

	@Override
	public String[] CreateData() {
		ArrayList<String> rowData = new ArrayList<String>();
		rowData.add(GetString(ID));
		rowData.add(name);
		rowData.add(type.toString());
		rowData.add(mesh);
		rowData.add(GetString(maxStatck));
		return rowData.toArray(new String[0]);
	}
}
