package module5;

public class Movie {


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    private String movieName;
}
