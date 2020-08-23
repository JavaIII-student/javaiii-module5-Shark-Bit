package module5;

import javax.print.attribute.standard.MediaSize;
import java.sql.*;

public class MovieDBModel {

    public MovieDBModel() throws SQLException {

        createDB();

        createTable();

        printTables();
    }

    private void createDB() {
        try{
            this.connection = DriverManager.getConnection(URL);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void createTable() throws SQLException {

        if(connection!=null)
        {

            String CREATE_TABLE_SQL = "CREATE TABLE " + TABLENAME + "("
                    + UID + " INT NOT NULL,"
                    + NAME + " VARCHAR(255),"
                    + RATING + " INT NOT NULL,"
                    + DESCRIPTION + " VARCHAR(255),"
                    + "PRIMARY KEY (UID))";

            String dropTable = "DROP TABLE " + TABLENAME;

            DatabaseMetaData dbmd = connection.getMetaData();

            Statement statement = connection.createStatement();

            ResultSet rs = dbmd.getTables(null, null, TABLENAME.toUpperCase(), null);

            if(!rs.next()) {

                statement.execute(CREATE_TABLE_SQL);
            }else{

                statement.execute(dropTable);
                statement.execute(CREATE_TABLE_SQL);
            }
        }
    }

    private void printTables() throws SQLException {

        DatabaseMetaData dbmd = connection.getMetaData();

        Statement statement = connection.createStatement();

        ResultSet rs = dbmd.getTables(null, null, TABLENAME, null);

        System.out.println(rs.next());

        System.out.println(rs.getString(3));

        System.out.println(rs.getString("TABLE_NAME"));

        statement.executeUpdate("INSERT INTO MOVIES VALUES (1, 'DUNE', 10, 'Space Sand Movie')");

        statement.executeUpdate("INSERT INTO MOVIES VALUES (2, 'TRON', 9, 'CYBERPUNK PROM')");

        ResultSet rs2 =  statement.executeQuery("SELECT "
                + UID + ", "
                + NAME +", "
                + RATING +", "
                + DESCRIPTION + " FROM MOVIES");

        while (rs2.next()){
            System.out.println(rs2.getString(UID));
            System.out.println(rs2.getString(NAME));
            System.out.println(rs2.getString(RATING));
            System.out.println(rs2.getString(DESCRIPTION));
        }
    }

    private final String URL = "jdbc:derby:MoveDataBase;create=true";
    private final String TABLENAME = "MOVIES",
            UID = "UID",
            NAME = "NAME",
            RATING = "RATING",
            DESCRIPTION = "DESCRIPTION";

    private Connection connection;
}
