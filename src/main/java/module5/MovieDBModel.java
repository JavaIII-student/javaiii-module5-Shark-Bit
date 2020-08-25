package module5;

import javax.print.attribute.standard.MediaSize;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDBModel {

    public MovieDBModel() throws SQLException {
        createDB();
        createTable();
    }

    public void addMove(String name, String rating, String description) throws SQLException {

        int uid = new Movie(name, rating, description).hashCode();

        Statement statement = connection.createStatement();

        String movieInfo = "INSERT INTO MOVIES VALUES ("
                + uid + ", "
                + "'" + name + "'" + ", "
                +  Integer.parseInt(rating) + ", "
                + "'" + description  + "'"
                + ")";

        System.out.println(movieInfo);

        statement.executeUpdate(movieInfo);
    }

    public List<String[]> getDBMovies() throws SQLException {

        List<String[]> moviesArray = new ArrayList<>();

        Statement statement = connection.createStatement();

        ResultSet rs2 =  statement.executeQuery("SELECT "
                + UID + ", "
                + NAME +", "
                + RATING +", "
                + DESCRIPTION + " FROM MOVIES");

        while (rs2.next()){

            String[] movie = new String[3];

            movie[0] = rs2.getString(NAME);
            movie[1] = rs2.getString(RATING);
            movie[2] = rs2.getString(DESCRIPTION);

            moviesArray.add(movie);
        }

        return moviesArray;
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

    private final String URL = "jdbc:derby:MoveDataBase;create=true";
    private final String TABLENAME = "MOVIES",
            UID = "UID",
            NAME = "NAME",
            RATING = "RATING",
            DESCRIPTION = "DESCRIPTION";

    private Connection connection;
}
