package diellza.touristguide.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by SINKOPA on 4/30/2018.
 */

public class DBAdapter {

    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }
    //OPEN
    public DBAdapter openDB()
    {
        try {
            db=helper.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    //CLOSE
    public void closeDB()
    {
        try {
            helper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //SAVE
    public long add(int ID, String title, String overview, String history, String className, String type,
                    String period, String century, String address, double longitude, double latitude,
                    String category, String imageURL)
    {
        try {
            ContentValues cv=new ContentValues();
            cv.put(Constants.ID,ID);
            cv.put(Constants.title, title);
            cv.put(Constants.overview, overview);
            cv.put(Constants.history, history);
            cv.put(Constants.className, className);
            cv.put(Constants.type, type);
            cv.put(Constants.period, period);
            cv.put(Constants.century, century);
            cv.put(Constants.address, address);
            cv.put(Constants.longitude, longitude);
            cv.put(Constants.latitude, latitude);
            cv.put(Constants.category, category);
            cv.put(Constants.imageURL, imageURL);

            db.insert(Constants.TB_NAME, Constants.ID, cv);

            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    //RETRIEVE
    public Cursor getMonuments()
    {
        String[] columns={Constants.title,Constants.imageURL};

        return db.query(Constants.TB_NAME,columns,null,null,null,null,null);
    }
}
