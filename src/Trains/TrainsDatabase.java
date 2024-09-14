package Trains;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import RailwayManagementSystem.Database;

public class TrainsDatabase {
	
	public static void AddTrain(Train t, Database database) throws SQLException {
		String insert = "INSERT INTO `trains` (`ID`, `Capacity`, `Description`) VALUES" 
				+ "('"+t.getID()+"','"+t.getCapacity()+"','"+t.getDescription()+"');";
		database.getStatement().execute(insert);
	}

	public static int getNextID (Database database) throws SQLException {
		int id = 0;
		if (getAllTrains(database).size()!=0) {
			id = getAllTrains(database).get(getAllTrains(database).size()-1).getID() + 1;
		}
		return id;
	}
	
	public static ArrayList<Train> getAllTrains (Database database) throws SQLException {
		String select = "SELECT * FROM trains ;";
		ArrayList<Train> trains = new ArrayList<>();
		ResultSet rs = database.getStatement().executeQuery(select);
		while (rs.next()) {
			Train t = new Train();
			t.setID (rs.getInt("ID"));
			t.setCapacity(rs.getInt("Capacity"));
			t.setDescription(rs.getString("Description"));
			trains.add(t);
		}
		return trains;
	}
	
	public static String[] getTrainsIDs (Database database) throws SQLException {
		ArrayList<Train> trains = getAllTrains(database);
		String[] array = new String[trains.size()];
		for (int i=0;i<trains.size();i++) {
			array[i]= String.valueOf(trains.get(i).getID());
		}
		return array;
	}
	
	public static Train getTrain(String id, Database database) throws SQLException {
		Train t = new Train();
		String select = "SELECT `ID`, `Capacity`, `Description` FROM `trains` "
				+ "WHERE `ID` = "+id+";";
		ResultSet rs = database.getStatement().executeQuery(select);
		rs.next();
		t.setID(rs.getInt("ID"));
		t.setCapacity (rs.getInt("Capacity"));
		t.setDescription (rs.getString("Description"));
		return t;
	}
	
	public static void EditTrain(Train train, Database database) throws SQLException {
		String update = "UPDATE `trains` SET `Capacity`='"+train.getCapacity()+
				"',`Description`='"+train.getDescription()+"' WHERE `ID` = "+
				train.getID()+" ;";
		database.getStatement().execute(update);
	}
	
	public static void DeleteTrain(String id, Database database) throws SQLException {
		String delete = "DELETE FROM `trains` WHERE `ID` = "+id+" ;";
		database.getStatement().execute(delete);
	}
	
	public static String[] getTrains(Database database) throws SQLException {
		ArrayList<Train> trains = getAllTrains(database);
		String[] array = new String[trains.size()];
		for (int i=0;i<trains.size();i++) {
			array[i] = trains.get(i).getDescription();
		}
		return array;
	}
	
	public static Train getTrainByDescription(String description, Database database) throws SQLException {
		Train t = new Train();
		String select = "SELECT `ID`, `Capacity`, `Description` FROM `trains` "
				+ "WHERE `Description` = '"+description+"';";
		ResultSet rs = database.getStatement().executeQuery(select);
		rs.next();
		t.setID(rs.getInt("ID"));
		t.setCapacity (rs.getInt("Capacity"));
		t.setDescription (rs.getString("Description"));
		return t;
	}
	
}