package Common;

import io.restassured.internal.support.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class PayloadBuilder {
    public static JSONObject createTrailerPayload() throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(new FileInputStream("C:\\Users\\pmonaheng\\IdeaProjects\\TIH_APIs\\src\\test\\java\\getFullTrailerQuotePremium.json")));
        return jsonObject;
    }
}
