package futureman.articles;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester {

	public static void main(String[] args) {
	try	{
			
			ObjectMapper mapper = new ObjectMapper();
			
			Kunde k1 = new Kunde("Hans" , "Peter");
			Kunde k2 = new Kunde("Motombo", "Motohombo");
			
			String jsonK1 = mapper.writeValueAsString(k1);
			String jsonK2 = mapper.writeValueAsString(k2);
			
			System.out.println(jsonK1);
			System.out.println(jsonK2);
			
			Kunde a1 = mapper.readValue(jsonK1, Kunde.class);
			Kunde a2 = mapper.readValue(jsonK2, Kunde.class);
			System.out.println(a1.toString());
			System.out.println(a2.toString());
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
