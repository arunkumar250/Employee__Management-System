package EMS;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class FileHandler {
	
	public static void addEmployee(int[] arr) throws IOException
	{
		int key = 0;
		JSONObject object = new JSONObject();
		for(int i=0;i<arr.length;i++)
		{
			object.put(key++, arr[i]);
		}
		try(FileWriter file = new FileWriter("test.json"))
		{
			file.write(object.toJSONString());
		}
	}
}
