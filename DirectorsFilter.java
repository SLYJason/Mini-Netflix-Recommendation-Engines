
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (SLY) 
 * @version (1.0.0)
 */
public class DirectorsFilter implements Filter {
    private String myDirectors;
	
	public DirectorsFilter(String directors) {
		myDirectors = directors;
	}
	
	@Override
	public boolean satisfies(String id) {
	    String[] directors = myDirectors.split(",");
	    for(String s : directors){
	        if(MovieDatabase.getDirector(id).contains(s)){
	            return true;
	        }
	    }
	    return false;
	}
}
