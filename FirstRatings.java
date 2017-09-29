import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    public ArrayList<Movie> loadMovies(String filename){
        ArrayList<Movie> list = new ArrayList<Movie>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            String id = record.get("id");
            String title = record.get("title");
            String year = record.get("year");
            String country = record.get("country");
            String genre = record.get("genre");
            String director = record.get("director");
            int minutes = Integer.parseInt(record.get("minutes"));
            String poster = record.get("poster");
            Movie m = new Movie(id, title, year, genre, director, country, poster, minutes);
            list.add(m);
        }
        return list;
    }
    
    public void testLoadMovies(){
        ArrayList<Movie> list = loadMovies("data/ratedmoviesfull.csv");
        int total=0;
        int max = 0;
        HashMap<String,Integer> dir = new HashMap<String,Integer>();
        for(Movie s : list){
            if(s.getGenres().contains("Comedy")){
                //System.out.println(s);
            }
            if(s.getMinutes()>150){
                //System.out.println(s);
            }
            int num = s.getDirector().split(",").length;
            if(num > max){
                max = num;
            }
        }
        for(Movie s : list){
            if(s.getDirector().split(",").length == max){
               total = total + s.getDirector().split(",").length;
            }
        }
        
        for(Movie s : list){
            String[] d = s.getDirector().split(",");
            for(String sd : d){
                if(!dir.containsKey(sd)){
                    dir.put(sd,1);
                }
                else{
                    dir.put(sd,dir.get(sd)+1);
                }
            }
        }
        max = 0;
        String director = "";
        for(String s : dir.keySet()){
            if(dir.get(s)>max){
                max = dir.get(s);
                director = s;
            }
        }
        //System.out.println("The maximum number of movies by any director is " + max);
        //System.out.println("there are " + total + " directors");
        //System.out.println(list.size());
        //System.out.println(director);
    }
    
    public ArrayList<Rater> laodRaters(String filename){
        ArrayList<Rater> list = new ArrayList<Rater>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        ArrayList<String> idlist = new ArrayList<String>();
        for(CSVRecord record : parser){
            Rater raterid = new EfficientRater(record.get("rater_id"));
            if(!idlist.contains(raterid.getID())){
                idlist.add(raterid.getID());
                raterid.addRating(record.get("movie_id"),Integer.parseInt(record.get("rating")));
                list.add(raterid);
                continue;
            }
            list.get(Integer.parseInt(raterid.getID())-1).addRating(record.get("movie_id"),Integer.parseInt(record.get("rating")));
        }
        return list;
    }
    
    public void loadRaters(){
        ArrayList<Rater> list = laodRaters("data/ratings.csv");
        //System.out.println(list.size());
        for(Rater r : list){
            //System.out.println("Rater's ID " + r.getID() + " and number of ratings " + r.numRatings());
            ArrayList<String> itemrated = r.getItemsRated();
            for(String s : itemrated){
                //System.out.print(s + " : " + r.getRating(s));
                //System.out.println();
            }
        }
        
        String raterid = "193";
        for(Rater r : list){
            if(r.getID().equals(raterid)){
                //System.out.println("rater id is " + raterid + " has " + r.numRatings() + " ratings");
            }
        }
        
        int max = 0;
        ArrayList<String> rater = new ArrayList<String>();
        for(Rater r : list){
            if(r.numRatings() > max){
                rater.clear();
                max = r.numRatings();
                rater.add(r.getID());
            }
        }
        //System.out.println("The maximum number of ratings are " + max);
        //System.out.println("The rater id is: " + rater);
        
        String movieid = "1798709";
        int nummov = 0;
        for(Rater r : list){
            ArrayList<String> itemrated = r.getItemsRated();
            if(itemrated.contains(movieid)){
                nummov++;
            }
        }
        //System.out.println(movieid + " is rated by " + nummov + " raters");
        
        ArrayList<String> unimov = new ArrayList<String>();
        for(Rater r : list){
            ArrayList<String> itemrated = r.getItemsRated();
            for(String s : itemrated){
                if(!unimov.contains(s)){
                    unimov.add(s);
                }
            }
        }
        //System.out.println(unimov.size() + " different movies have been rated");
    }
}
