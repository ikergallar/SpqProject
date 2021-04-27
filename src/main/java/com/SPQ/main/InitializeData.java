package com.SPQ.main;

import com.SPQ.dataBase.DBException;
import com.SPQ.dataBase.DBManager;

public class InitializeData {

	public static void main(String[] args) {
		DBManager dbm = new DBManager();
		try {
			dbm.initializeData();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
}