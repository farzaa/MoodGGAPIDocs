import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;



public class JavaExample{
    public static void main(String[] args) throws Exception {
        //Overwatch
        //retrieve all heroes supported by Mood
        String getHeroes = "https://moodggapi.herokuapp.com/api/ow/listOfHeroes";

        //for retrieving information about a specific hero enter it here
        String hero = "Genji";
        String getSpecificHero = "https://moodggapi.herokuapp.com/api/ow/" + hero;

        //League of Legends
        //retrieve all heroes supported by Mood
        String getChamps = "https://moodggapi.herokuapp.com/api/lol/listOfChampions";

        //for retrieving information about a specific hero enter it here
        String champion = "Yasuo";
        String getSpecificChamp = "https://moodggapi.herokuapp.com/api/lol/" + champion;


        //for LOL replace with getChamps
        System.out.println(callAPI(getHeroes));

        /*for specific heroes/champions the data returned is in JSON format. The data contains these fields:
        id
        name
        playlistID
        videoArray
        suggestionPlaylistID
        suggestionArray*/


        //for LOL replace with getSpecificChamps
        JSONObject obj = parseJSON(callAPI(getSpecificHero));
        System.out.println(obj.get("name"));
        System.out.println(obj.get("playlistID"));

    }

    public static String callAPI(String str) throws Exception{

        URL url = new URL(str);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static JSONObject parseJSON(String str){
        JSONObject jsonObj = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(str);
            JSONArray array = new JSONArray();
            array.add(obj);
            jsonObj = (JSONObject)array.get(0);
        }catch(ParseException pe){
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
        return jsonObj;
    }
}
