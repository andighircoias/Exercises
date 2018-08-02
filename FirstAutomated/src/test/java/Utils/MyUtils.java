package Utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MyUtils {
	public static Object getUserDataFromJson(String jsonString, String fieldName) {
		  Object value = "";
		  
		  ObjectMapper mapper = new ObjectMapper();
		  try {
		   JsonNode jsonObject = mapper.readTree(jsonString);
		   value = jsonObject.findValue(fieldName);
		   
		  } catch (IOException e) {
		   e.printStackTrace();
		   return "";
		  }
		  
		  return value;
	}
	public static String createUserJson(String name, String job) {
		  ObjectMapper mapper = new ObjectMapper();
		  ObjectNode rootNode = mapper.createObjectNode();
		  rootNode.put("Username", name);
		  rootNode.put("Password", job);
		  return rootNode.toString();
		 }

}
