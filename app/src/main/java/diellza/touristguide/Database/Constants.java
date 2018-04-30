package diellza.touristguide.Database;

/**
 * Created by SINKOPA on 4/30/2018.
 */

public class Constants {
    //COLUMNS
    static final String ID="ID";
    static final String title = "Title";
    static final  String overview = "Overview";
    static final  String history = "History";
    static final  String className = "ClassName";
    static final  String type = "Type";
    static final  String period = "Period";
    static final  String century = "Century";
    static final  String address = "Address";
    static final  String longitude = "Longitude";
    static final  String latitude = "Latitude";
    static final  String category = "Category";
    static final  String imageURL = "Image_URL";

    //DB PROPERTIES
    static final String DB_NAME="TouristGuide";
    static final String TB_NAME="Monumentet";
    static final int DB_VERSION=1;

    //CREATE TABLE STMT
    static final String CREATE_TB="CREATE TABLE Monumentet(id INTEGER PRIMARY KEY,"
            + " title TEXT, overview TEXT, history TEXT, className TEXT, type TEXT, period TEXT, century TEXT, address TEXT, " +
            " longitude REAL, latitude REAL, category TEXT, Image_URL TEXT );";

    //UPGRADE TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;
}
