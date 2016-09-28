/**
 * 
 */
package eu.supersede.dm.util;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

/**
 * @author fitsum
 *
 */
public class JSONReaderTest {

	@Test
	public void test1() throws FileNotFoundException {
		String jsonFile = "input/monitoring/feedbackreconfig/json/android.json";
		FileReader fileReader = new FileReader(jsonFile);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);
		String key = "/memory_consumption/opt";
		Object object = jsonObject.query(key);
		System.out.println(object.toString());
		key = "/memory_consumption/value";
		object = jsonObject.query(key);
		System.out.println(object.toString());
		key = "/memory_consumption/domain";
		object = jsonObject.query(key);
		System.out.println(object.toString());
	}
	
	@Test
	public void test2() throws FileNotFoundException {
		String jsonFile = "input/monitoring/feedbackreconfig/json/android.json";
		FileReader fileReader = new FileReader(jsonFile);
		JSONTokener jsonTokener = new JSONTokener(fileReader);
		JSONObject jsonObject = new JSONObject(jsonTokener);
//		String key = "/memory_consumption/opt";
		Map<String, Object> map = jsonObject.toMap();
		for (Entry<String, Object> entry : map.entrySet()){
			System.err.println(entry.getKey());
			Map<Object, Object> innerMap = (Map<Object, Object>)entry.getValue();
			System.out.println(innerMap.get("opt"));
//			for (Entry<Object, Object> innerEntry : innerMap.entrySet()){
//				System.out.println(innerEntry.getKey() + " " + innerEntry.getValue());
//			}
		}
	}

}
