package com.belven.rpg.items;

public abstract class RowData {
	int ID;
	public static String COMMA = ",";

	public abstract String[] CreateData(); 
	
	public abstract int GetLastID();
}