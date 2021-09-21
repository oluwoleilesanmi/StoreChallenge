import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONModel {
    JSONParser parser = new JSONParser();
    JSONArray array = null;

    public JSONModel(String fileName){
        try {
            // Read a file containing JSONArray in string format to a JAVA object
            Object JSONArrayObject = parser.parse(new FileReader(fileName));
            // Convert the JSONArray object to a data-structure in JAVA.
            array = (JSONArray) JSONArrayObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public JSONObject getItem(String code){
        JSONObject itemObj = null;
        for (Object abs : array){
            itemObj = (JSONObject) abs;
            if(itemObj.get(Constant.CODE_KEY).equals(code)){
                return itemObj;
            }else if(itemObj.get(Constant.CODE_KEY).equals(code)){
                return itemObj;
            }else if(itemObj.get(Constant.CODE_KEY).equals(code)) {
                return itemObj;
            }
        }
        return null;
    }
}
