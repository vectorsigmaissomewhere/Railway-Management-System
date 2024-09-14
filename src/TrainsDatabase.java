import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainsDatabase {
    public void AddTrain(Train t, Database database) throws SQLException{
        String insert = "INSERT INTO `trains`(`ID`, `Capacity`, `Description`) VALUES" + "('"+t.getID()+"', '"+t.getCapacity()+"', '"+t.getDescription()+"')";
        database.getStatement().execute(insert);
    }

    static int getNextID(Database database) throws SQLException{
        int id = 0;
        if(getAllTrains(database).size()!=0) {
            id = getAllTrains(database).get(getAllTrains(database).size()-1).getID() + 1;
        }
        return id;
    }

    static ArrayList<Train> getAllTrains(Database database) throws SQLException{
        String select  = "Select * from `trains`;";
        ArrayList<Train> trains = new ArrayList<>();
        ResultSet rs = database.getStatement().executeQuery(select);
        while(rs.next()){
            Train t = new Train();
            t.setID(rs.getInt("ID"));
            t.setCapacity(rs.getInt("Capacity"));
            t.setDescription(rs.getString("Description"));
            trains.add(t);
        }
        return trains;
    }
}
