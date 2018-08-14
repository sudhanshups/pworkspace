
package demo;
import java.util.HashMap;
public class CountryDB 
{
	private static HashMap<String, String[]> countryStates = new HashMap<String, String[]>();
	
	static
	{
		countryStates.put
		("INDIA", new String[]{"Andhra Pradesh","Karnataka"});
		countryStates.put
		("USA", new String[]{"Illinois","New York","Texas"});		
	}
	
	public static String[] getStates(String country)
	{
		return countryStates.get(country);
	}	
}
