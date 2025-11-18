package movies;

import java.util.List;
import java.util.Objects;

public class Movies {

    private String title;
    private Double scoreIMDB;
    private String releaseDate;
    private String director;

    public Movies(String title, Double scoreIMDB, String director, String releaseDate){
        this.title = title;
        this.scoreIMDB = scoreIMDB;
        this.director = director;
        this.releaseDate = releaseDate;

    }

    public Movies(){
        this(" ", 0.0, " ", "00/00/0000");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setScoreIMDB(Double scoreIMDB) {
        this.scoreIMDB = scoreIMDB;
    }

    public String getTitle() {
        return title;
    }

    public Double getScoreIMDB() {
        return scoreIMDB;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(){
        this.director = director;
    }

    @Override
    public String toString(){
        return "MOVIE TITLE: " + title +
                "\nRELEASE DATE: " + releaseDate +
                "\nIMDB SCORE: " +scoreIMDB;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movies movies = (Movies) o;
        return Objects.equals(title, movies.title) &&
                Objects.equals(releaseDate, movies.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate);
    }


}

