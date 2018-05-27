package diellza.touristguide.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Models.Monument;

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
        //    cv.put(Constants.createdAt,System.currentTimeMillis());
db.insertWithOnConflict(Constants.TB_NAME, null, cv,SQLiteDatabase.CONFLICT_IGNORE);
         //   db.insert(Constants.TB_NAME, Constants.ID, cv);

            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    //RETRIEVE
    public ArrayList<Monument> getMonuments()
    {
       SQLiteDatabase db1=helper.getReadableDatabase();
        Log.e("DATABASE","readable");
      //  String[] columns={Constants.ID,Constants.title,Constants.overview,Constants.imageURL};
//        String[] columns={Constants.ID,Constants.title, Constants.overview ,Constants.history,Constants.className,Constants.type,
//                Constants.period,Constants.century,Constants.address,Constants.longitude,Constants.latitude,Constants.category,Constants.imageURL};

             //' Cursor c= db.query(Constants.TB_NAME,columns,null,null,null,null,null);

              Cursor c=db1.rawQuery("SELECT * FROM  Monumentet",null);
        Log.e("DATABASE","cursor");

     //   Cursor c= MainActivity.getAdapter().getMonuments();

              ArrayList<Monument> mArrayList = new ArrayList<Monument>();
        if (c.moveToFirst()) {
            do {
                Log.e("DATABASE","1  /n");
                Log.e("DATABASE",c.getColumnCount()+"");

                String [] names=c.getColumnNames();
                for (String name:names
                     ) {
                    Log.e("NAMES",name);

                }


                mArrayList.add(new Monument(c.getInt(c.getColumnIndex(Constants.ID)), c.getString(c.getColumnIndex(Constants.title)), c.getString(c.getColumnIndex(Constants.overview)),
                        c.getString(c.getColumnIndex(Constants.history)), c.getString(c.getColumnIndex(Constants.className)),
                        c.getString(c.getColumnIndex(Constants.type)), c.getString(c.getColumnIndex(Constants.period)),
                        c.getString(c.getColumnIndex(Constants.century)), c.getString(c.getColumnIndex(Constants.address)),
                       (c.getDouble(c.getColumnIndex(Constants.longitude))),  c.getDouble(c.getColumnIndex(Constants.latitude)),
                        c.getString(c.getColumnIndex(Constants.category)), c.getString(c.getColumnIndex(Constants.imageURL)))); //add the item
                Log.e("DATABASE","1  /n");
            }while(c.moveToNext());

                c.moveToNext();
            }

        c.close();
      db1.close();
        return  mArrayList;
    }


}
