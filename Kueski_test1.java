/**
 * Program created as a part of interview with Kueski * 
 * @author Alizishaan Khatri
 *
 */
public class Kueski_test1 {
	/**
	 * The function that puts everything together
	 * @param args
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ProtocolException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws Exception {
		
		String token="token=fBKGmLaotrHOKZbNG5o";

		Data_IO  http = new Data_IO(token);
		
		//Repeat process for 100 queries
		for(int i=0;i<100;i++){
			//Get parameter
			long query=http.getQuery();
			
			//Compute range
			String ans=Fibonacci.getRange(query);
			
			//Send answer
			http.sendAnswer(ans);
		}
	}

	

}
