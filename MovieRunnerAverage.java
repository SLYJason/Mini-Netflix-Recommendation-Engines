import java.util.*;
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (SLY) 
 * @version (1.0.0)
 */
public class MovieRunnerAverage {
    public void printAverageRatings(){
        SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv","data/ratings.csv");
        System.out.println("Movie size: " + sr.getMovieSize());
        System.out.println("Rater size: " + sr.getRaterSize());
        ArrayList<Rating> ar = sr.getAverageRatings(12);
        Collections.sort(ar);
        for(Rating r : ar){
            if(r.getValue() > 0){
                System.out.println(r.getValue() + " " + sr.getTitle(r.getItem()));
            }
        }
    }
    
    public void getAverageRatingOneMovie(){
        SecondRatings sr = new SecondRatings("data/ratedmoviesfull.csv","data/ratings.csv");
        String title = "Vacation";
        double score = sr.getAverageByID(sr.getID(title),0);
        System.out.println(title +" : " + score);
    }
}
