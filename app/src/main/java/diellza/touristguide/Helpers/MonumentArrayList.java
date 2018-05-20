package diellza.touristguide.Helpers;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Models.Monument;

/**
 * Created by SINKOPA on 5/19/2018.
 */

public class MonumentArrayList {

    private static ArrayList<Monument> monumentArrayList;
   private  static  JSONArray jsonArray;

    public static ArrayList<Monument> getArray() {
        monumentArrayList = new ArrayList<>();
        try {

            Log.e("MRENA", "sdsdfsdf");

            int id;
            String title, history, overview, className, type, period, century, overviewImg, address, category;
            double longitude, latitude;
            Log.e("MRENA", MainActivity.getJsonResult() + "");


            jsonArray = new JSONArray(MainActivity.getJsonResult());
            Log.e("MRENA", "" + jsonArray.length());

            int count = 0;


            while (count < jsonArray.length()) {


                JSONObject jsonObject = jsonArray.getJSONObject(count);
                id = Integer.parseInt(jsonObject.getString("id"));
                title = jsonObject.getString("title");
                overview = jsonObject.getString("overview");
                history = jsonObject.getString("history");
                className = jsonObject.getString("className");
                type = jsonObject.getString("type");
                period = jsonObject.getString("period");
                century = jsonObject.getString("century");
                address = jsonObject.getString("address");
                longitude = Double.parseDouble(jsonObject.getString("longitude"));
                latitude = Double.parseDouble(jsonObject.getString("latitude"));
                category = jsonObject.getString("category");
                overviewImg = jsonObject.getString("overviewImg");


                monumentArrayList.add(new Monument(id, title, overview, history, className, type, period, century, address, longitude, latitude, category, overviewImg));

                count++;
            }

            Log.e("MRENA", "" + monumentArrayList.size());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return monumentArrayList;

    }
}
