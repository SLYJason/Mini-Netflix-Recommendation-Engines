import java.util.*;
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (SLY) 
 * @version (1.0.0)
 */
public class MovieRunnerWithFilters {
    public void printAverageRatings(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Rater size: " + sr.getRaterSize());
        System.out.println("Movie size: " + MovieDatabase.size());
        ArrayList<Rating> ar = sr.getAverageRatings(35);
        System.out.println("Found " + ar.size() + " movies");
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
            }
        }
    }
    
    public void printAverageRatingsByYearAfter(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        YearAfterFilter yearF = new YearAfterFilter(2000);
        ArrayList<Rating> ar = sr.getAverageRatingsByFilter(20,yearF);
        System.out.println("Rater size: " + sr.getRaterSize());
        System.out.println("Movie size: " + MovieDatabase.size());
        System.out.println("Found " + ar.size() + " movies");
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
            }
        }
    }
    
    public void printAverageRatingsByGenre(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        GenreFilter genreF = new GenreFilter("Comedy");
        ArrayList<Rating> ar = sr.getAverageRatingsByFilter(20,genreF);
        System.out.println("Rater size: " + sr.getRaterSize());
        System.out.println("Movie size: " + MovieDatabase.size());
        System.out.println("Found " + ar.size() + " movies");
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
                System.out.println(MovieDatabase.getGenres(r.getItem()));
            }
        }
    }
    
    public void printAverageRatingsByMinutes(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        MinutesFilter minutesF = new MinutesFilter(105,135);
        ArrayList<Rating> ar = sr.getAverageRatingsByFilter(5,minutesF);
        System.out.println("Rater size: " + sr.getRaterSize());
        System.out.println("Movie size: " + MovieDatabase.size());
        System.out.println("Found " + ar.size() + " movies");
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
            }
        }
    }
    
    public void printAverageRatingsByDirectors(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        DirectorsFilter directorF = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating> ar = sr.getAverageRatingsByFilter(4,directorF);
        System.out.println("Rater size: " + sr.getRaterSize());
        System.out.println("Movie size: " + MovieDatabase.size());
        System.out.println("Found " + ar.size() + " movies");
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " " + MovieDatabase.getTitle(r.getItem()));
                System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
            }
        }
    }
    
    public void printAverageRatingsByYearAfterAndGenre(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        AllFilters af = new AllFilters();
        YearAfterFilter yearF = new YearAfterFilter(1990);
        GenreFilter genreF = new GenreFilter("Drama");
        af.addFilter(yearF);
        af.addFilter(genreF);
        ArrayList<Rating> ar = sr.getAverageRatingsByFilter(8,af);
        System.out.println("Rater size: " + sr.getRaterSize());
        System.out.println("Movie size: " + MovieDatabase.size());
        System.out.println(ar.size() + " movies matched");
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
                System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
            }
        }
    }
    
    public void printAverageRatingsByDirectorsAndMinutes(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        MovieDatabase.initialize("ratedmoviesfull.csv");
        AllFilters af = new AllFilters();
        MinutesFilter minutesF = new MinutesFilter(90,180);
        DirectorsFilter directorF = new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
        af.addFilter(minutesF);
        af.addFilter(directorF);
        ArrayList<Rating> ar = sr.getAverageRatingsByFilter(3,af);
        System.out.println("Rater size: " + sr.getRaterSize());
        System.out.println("Movie size: " + MovieDatabase.size());
        System.out.println(ar.size() + " movies matched");
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " Time: " + MovieDatabase.getMinutes(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
                System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
            }
        }
    }
}
