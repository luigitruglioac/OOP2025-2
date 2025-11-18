package movies;

import java.util.ArrayList;
import java.util.List;

public class CinemaSystem {
    private List<Movies> moviesList;

    public CinemaSystem() {
        this.moviesList = new ArrayList<>();
    }

    public void addMovie(Movies movie) {
        this.moviesList.add(movie);
        System.out.println("Successfully added the new movie! ");
    }

    public void removeMovie(String title) throws MovieNotExistException {
        Movies deletedMovie = null;
        for (Movies mv : this.moviesList) {
            if (mv.getTitle().equalsIgnoreCase(title)) {
                deletedMovie = mv;
                break;
            }
        }
        if (deletedMovie != null) {
            this.moviesList.remove(deletedMovie);
            System.out.println("Successfully deleted the movie " + title + " from the catalogue! ");
        } else {
            throw new MovieNotExistException("This movie is not on the catalogue");
        }
    }

    // additional method
    public List<Movies> searchByDirector(String director){
        List<Movies> results = new ArrayList<>();
        for(Movies mv : moviesList){
            if(mv.getDirector().equals(director)){
                results.add(mv);
            }
        }return results;
    }




}





