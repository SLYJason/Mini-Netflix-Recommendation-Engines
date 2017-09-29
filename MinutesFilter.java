
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (SLY) 
 * @version (1.0.0)
 */
public class MinutesFilter implements Filter{
    private int myMin;
    private int myMax;
    
    public MinutesFilter(int min, int max){
        myMin = min;
        myMax = max;
    }

    public boolean satisfies(String id) {
		return MovieDatabase.getMinutes(id)<=myMax && MovieDatabase.getMinutes(id)>=myMin;
	}
}
