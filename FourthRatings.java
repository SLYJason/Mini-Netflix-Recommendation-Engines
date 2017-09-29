import java.util.*;

public class FourthRatings {
    public double dotProduct(Rater me, Rater r){
        ArrayList<String> memov = me.getItemsRated();
        ArrayList<String> rmov = r.getItemsRated();
        double dot = 0;
        for(String mes : memov){
            for(String rs : rmov){
                if(mes.equals(rs)){
                    dot = dot + (me.getRating(rs)-5)*(r.getRating(rs)-5);
                }
            }
        }
        return dot;
    }
    
    public ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> list = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r : RaterDatabase.getRaters()) {
            double sim = dotProduct(me,r);
            if(!me.getID().equals(r.getID()) && sim>0){
                list.add(new Rating(r.getID(),sim));
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters){
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<Rating> ret = new ArrayList<Rating>();
        double total = 0;
        int num = 0;
        for(String movieID : MovieDatabase.filterBy(new TrueFilter())){
            for(int k=0; k<numSimilarRaters; k++){
                Rating r = list.get(k);
                Rater ra = RaterDatabase.getRater(r.getItem());
                for(String m : ra.getItemsRated()){
                    if(movieID.equals(m)){
                        num++;
                        total = r.getValue()*ra.getRating(movieID) + total;
                    }
                }
            }
            if(num >= minimalRaters){
                ret.add(new Rating(movieID, total/num));
            }
            num = 0;
            total = 0;
        }
        Collections.sort(ret, Collections.reverseOrder());
        return ret;
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> list = getSimilarities(id);
        ArrayList<Rating> ret = new ArrayList<Rating>();
        double total = 0;
        int num = 0;
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for(String movieID : MovieDatabase.filterBy(new TrueFilter())){
            if(movies.contains(movieID)){
                for(int k=0; k<numSimilarRaters; k++){
                    Rating r = list.get(k);
                    Rater ra = RaterDatabase.getRater(r.getItem());
                    for(String m : ra.getItemsRated()){
                        if(movieID.equals(m)){
                            num++;
                            total = r.getValue()*ra.getRating(movieID) + total;
                        }
                    }
                }   
                if(num >= minimalRaters){
                    ret.add(new Rating(movieID, total/num));
                }
                num = 0;
                total = 0;
            }
        }
        Collections.sort(ret, Collections.reverseOrder());
        return ret;
    }
}
