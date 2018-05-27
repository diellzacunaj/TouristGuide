package diellza.touristguide.Database;

/**
 * Created by SINKOPA on 4/30/2018.
 */

public class Constants {
    //COLUMNS
    static final String ID="id";
    static final String title = "title";
    static final  String overview = "overview";
    static final  String history = "history";
    static final  String className = "className";
    static final  String type = "type";
    static final  String period = "period";
    static final  String century = "century";
    static final  String address = "address";
    static final  String longitude = "longitude";
    static final  String latitude = "latitude";
    static final  String category = "category";
    static final  String imageURL = "Image_URL";
    static final  String createdAt = "createdAt";
    //DB PROPERTIES
    static final String DB_NAME="TouristGuide";
    static final String TB_NAME="Monumentet";
    static final String TB_NAME1="Monuments";
    static final int DB_VERSION=1;

    //CREATE TABLE STMT
    static final String CREATE_TB="CREATE TABLE Monumentet(id INTEGER PRIMARY KEY,"
            + " title TEXT, overview TEXT, history TEXT, className TEXT, type TEXT, period TEXT, century TEXT, address TEXT, " +
            " longitude REAL, latitude REAL, category TEXT, Image_URL TEXT );";


    //UPGRADE TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;

}
