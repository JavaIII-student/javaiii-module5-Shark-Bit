package module5;

import java.sql.SQLException;
import java.util.List;

public class MovieDBController {

    public MovieDBController() throws SQLException {
    }

    public void addMovie(String name, String rating, String description, MovieDBView movieDBView) throws SQLException {

        movieDBModel.addMove(name, rating, description);

        movieDBView.clearViewTable();

        List<String[]> movies = movieDBModel.getDBMovies();

        for (String[] movie : movies){
            movieDBView.updateViewTable(movie[0], movie[1], movie[2]);
        }
    }
    private final MovieDBModel movieDBModel = new MovieDBModel();
}
