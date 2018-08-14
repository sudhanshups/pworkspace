package swiggy.delivery.helper;

import java.io.IOException;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonHelper {
	
	public static <S> String objectToJSON(S obj) {
		ObjectMapper mapper = new ObjectMapper();
		//Object to JSON in String
		String jsonInString;
		try {
			jsonInString = mapper.writeValueAsString(obj);
		} catch (IOException e) {
			System.out.println("Exception Occured while converting object to string");
			return null;
		}
		return jsonInString;
	}
	
	
	public static <S> S jsonToObject(String json, Class<S> classType) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		S obj;
		try {
			obj = mapper.readValue(json, classType);
		} catch (IOException e) {
			System.out.println("Exception Occured while converting string to object");
			return null;
		}
		return obj;
	}
}
