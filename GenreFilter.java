
/**
 * Write a description of GenreFilter here.
 * 
 * @author (SLY) 
 * @version (1.0.0)
 */
public class GenreFilter implements Filter {
    private String myGenre;
    
    public GenreFilter(String genre){
        myGenre = genre;
    }

    public boolean satisfies(String id) {
		return MovieDatabase.getGenres(id).contains(myGenre);
	}
}
