package module5;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getMovieName().equals(movie.getMovieName()) &&
                getMovieRating().equals(movie.getMovieRating()) &&
                getMovieDes().equals(movie.getMovieDes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovieName(), getMovieRating(), getMovieDes());
    }

    private String movieName;
    private String movieRating;
    private String movieDes;

}
