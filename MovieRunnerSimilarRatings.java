import java.util.*;

public class MovieRunnerSimilarRatings {
    public void printSimilarRatings(){
        FourthRatings sr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        String id = "65";
        ArrayList<Rating> rating = sr.getSimilarRatings(id,10,5);
        Rater me = RaterDatabase.getRater(id);
        ArrayList<String> mymov = me.getItemsRated();
        for(Rating ra : rating){
            if(mymov.contains(ra.getItem())){
                System.out.println("****** " + MovieDatabase.getTitle(ra.getItem()) + " " + ra.getValue());
            }
            else{
                System.out.println(MovieDatabase.getTitle(ra.getItem()) + " " + ra.getValue());
            }
        }
    }
    
    public void printSimilarRatingsByGenre(){
        FourthRatings sr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        String id = "964";
        Rater me = RaterDatabase.getRater(id);
        ArrayList<String> mymov = me.getItemsRated();
        ArrayList<Rating> rating = sr.getSimilarRatingsByFilter(id,10,5,new GenreFilter("Mystery"));
        for(Rating ra : rating){
            if(mymov.contains(ra.getItem())){
                System.out.println("****** " + MovieDatabase.getTitle(ra.getItem()) + " " + ra.getValue());
                System.out.println("****** " + MovieDatabase.getGenres(ra.getItem()));
            }
            else{
                System.out.println(MovieDatabase.getTitle(ra.getItem()) + " " + ra.getValue());
                System.out.println(MovieDatabase.getGenres(ra.getItem()));
            }
        }
    }
    
    public void printSimilarRatingsByDirector(){
        FourthRatings sr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        String id = "120";
        Rater me = RaterDatabase.getRater(id);
        ArrayList<String> mymov = me.getItemsRated();
        ArrayList<Rating> rating = sr.getSimilarRatingsByFilter(id,10,2,new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        for(Rating ra : rating){
            if(mymov.contains(ra.getItem())){
                System.out.println("****** " + MovieDatabase.getTitle(ra.getItem()) + " " + ra.getValue());
                System.out.println("****** " + MovieDatabase.getDirector(ra.getItem()));
            }
            else{
                System.out.println(MovieDatabase.getTitle(ra.getItem()) + " " + ra.getValue());
                System.out.println(MovieDatabase.getDirector(ra.getItem()));
            }
        }
    }
    
    public void  printSimilarRatingsByGenreAndMinutes(){
        FourthRatings sr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        String id = "168";
        Rater me = RaterDatabase.getRater(id);
        ArrayList<String> mymov = me.getItemsRated();
        GenreFilter genreF = new GenreFilter("Drama");
        MinutesFilter minuteF = new MinutesFilter(80,160);
        AllFilters af = new AllFilters();
        af.addFilter(genreF);
        af.addFilter(minuteF);
        ArrayList<Rating> rating = sr.getSimilarRatingsByFilter(id,10,3,af);
        for(Rating ra : rating){
            if(mymov.contains(ra.getItem())){
                System.out.println("****** " + MovieDatabase.getTitle(ra.getItem()) + " " + MovieDatabase.getMinutes(ra.getItem()) + " " + ra.getValue());
                System.out.println("****** " + MovieDatabase.getGenres(ra.getItem()));
            }
            else{
                System.out.println(MovieDatabase.getTitle(ra.getItem()) + " " + MovieDatabase.getMinutes(ra.getItem()) + " " + ra.getValue());
                System.out.println(MovieDatabase.getGenres(ra.getItem()));
            }
        }
    }
    
    public void printSimilarRatingsByYearAfterAndMinutes(){
        FourthRatings sr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        String id = "314";
        Rater me = RaterDatabase.getRater(id);
        ArrayList<String> mymov = me.getItemsRated();
        YearAfterFilter genreF = new YearAfterFilter(1975);
        MinutesFilter minuteF = new MinutesFilter(70,200);
        AllFilters af = new AllFilters();
        af.addFilter(genreF);
        af.addFilter(minuteF);
        ArrayList<Rating> rating = sr.getSimilarRatingsByFilter(id,10,5,af);
        for(Rating ra : rating){
            if(mymov.contains(ra.getItem())){
                System.out.println("****** " + MovieDatabase.getTitle(ra.getItem()) + " " + MovieDatabase.getYear(ra.getItem()) + " " + MovieDatabase.getMinutes(ra.getItem()) + " " + ra.getValue());
            }
            else{
                System.out.println(MovieDatabase.getTitle(ra.getItem()) + " " + MovieDatabase.getYear(ra.getItem()) + " " + MovieDatabase.getMinutes(ra.getItem()) + " " + ra.getValue());
            }
        }
    }
}
