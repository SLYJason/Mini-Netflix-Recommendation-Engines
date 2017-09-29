
/**
 * Write a description of SecondRatings here.
 * 
 * @author (SLY) 
 * @version (1.0.0)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    
    public SecondRatings(String moviefile, String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.laodRaters(ratingsfile);
    }
    
    public int getMovieSize(){
        return myMovies.size();
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
        ArrayList<String> id = new ArrayList<String>();
        for(Rater r : myRaters){
            ArrayList<String> mov = r.getItemsRated();
            for(String s : mov){
                if(!id.contains(s)){
                    id.add(s);
                    double avg = getAverageByID(s,minimalRaters);
                    Rating ra = new Rating(s,avg);
                    ar.add(ra);
                }
            }
        }
        return ar;
    }
    
    public String getTitle(String id){
        for(Movie m : myMovies){
            if(id.equals(m.getID())){
                return m.getTitle();
            }
        }
        return "The ID is not found";
    }
    
    public String getID(String title){
        for(Movie m : myMovies){
            if(title.equals(m.getTitle())){
                return m.getID();
            }
        }
        return "NO such title";
    }
}
