package module5;

public class Movie {


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieDes() {
        return movieDes;
    }

    public void setMovieDes(String movieDes) {
        this.movieDes = movieDes;
    }

    public Movie(String movieName, String movieRating, String movieDes) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieDes = movieDes;
    }

    private String movieName;
    private String movieRating;
    private String movieDes;

}
