package movies;

import java.util.List;

public class CinemaApp {
    public static void main(String[] args) {
        CinemaSystem sys = new CinemaSystem();

        Movies mv1 = new Movies("Im Still Here", 8.1, "Walter Salles", "07/11/2002");
        sys.addMovie(mv1);


        List<Movies> directorSearch = sys.searchByDirector("Walter Salles");
        for (Movies mv : directorSearch) {
            System.out.println("Movies found: " + mv.getTitle());
        }

        try {
            sys.removeMovie("Movie not found");
        } catch (MovieNotExistException e) {
            System.err.println("CUSTOM ERROR: " + e.getMessage());
        }

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("ERROR: Invalid division");
        }
    }
}