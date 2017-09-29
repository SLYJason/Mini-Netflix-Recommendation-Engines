
/**
 * Write a description of SecondRatings here.
 * 
 * @author (SLY) 
 * @version (1.0.0)
 */

import java.util.*;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myRaters = fr.laodRaters(ratingsfile);
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }
    
    public double getAverageByID(String id, int minimalRaters){
        int num = 0;
        double total = 0;
        for(Rater r : myRaters){
            ArrayList<String> mov = r.getItemsRated();
            for(String s : mov){
                if(s.equals(id)){
                    num++;
                    total = total + r.getRating(id);
                }
            }
        }
        if(num >= minimalRaters){
           return total/num;
        }
        return 0.0;
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> ar = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String m : movies){
            double avg = getAverageByID(m,minimalRaters);
            Rating ra = new Rating(m,avg);
            if(avg!=0){
                ar.add(ra);
            }
        }
        return ar;
    }
    
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> ar = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String m : movies){
            double avg = getAverageByID(m,minimalRaters);
            Rating ra = new Rating(m,avg);
            if(avg!=0){
                ar.add(ra);
            }
        }
        return ar;
    }
    
}
