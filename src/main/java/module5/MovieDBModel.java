package module5;

import java.sql.*;

public class MovieDBModel {



    public MovieDBModel() throws SQLException {
        createDB();
    }

    private void createDB() throws SQLException {
        try{
            connection = DriverManager.getConnection(URL);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void resetExampleDatabase() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            System.out.println("Creating Table - This will throw an exception if the table is already created.");
            stmt.execute("CREATE TABLE example (" + "id INTEGER PRIMARY KEY," + "name VARCHAR(255))");
            System.out.println("adding values into example table");
            stmt.executeUpdate("INSERT INTO example VALUES (1, 'Example Data')");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    private void createTable() throws SQLException {

        if(connection!=null)
        {
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, sTablename.toUpperCase(),null);
            if(rs.next())
            {
                System.out.println("Table "+rs.getString("TABLE_NAME")+"already exists !!");
            }
            else
            {
                System.out.println("Write your create table function here !!!");
            }

        }


    }

    private static final String URL = "jdbc:derby:MoveDataBase;create=true";

    private Connection connection;
    private PreparedStatement selectAllExample;


}
