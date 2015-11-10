/**
 * Calculates the Fibonacci range for a given number
 * @author Alizishaan Khatri
 *
 */
public class Fibonacci{
	
	/**
	 * Static method to calculate the Fibonacci range for
	 * any given integer. Mathematically: <br><br>
	 * f(n)=f(n-1)+f(n-2); 
	 * <br><br>
	 * We calculate the Fibonacci range using a down to up approach.
	 * @param query The number whose range is to be calculated
	 * @return The Fibonacci range in which the given number lies 
	 */
	public static String getRange(long query){
		
		long n_minus_1=1; 				//f(n-1)
		long n_minus_2=0;				//f(n-2)
		long curr=1;					//f(n)
		
		/* Calculate the first Fibonacci number larger than the query integer */
		while(query>curr){			
			n_minus_2=n_minus_1;
			n_minus_1=curr;
			curr=n_minus_1+n_minus_2;	
		}
		
		/* Check if the queried integer is a Fibonacci number itself */
		if(query!=curr){
			return(n_minus_1+"-"+curr);
		}else{
			return(curr+"-"+curr);
		}
	}

}
