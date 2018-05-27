package diellza.touristguide.Models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Monument implements Serializable{

    @SerializedName("id")
    private int ID;
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("history")
    private String history;
    @SerializedName("className")
    private String className;
    @SerializedName("type")
    private String type;
    @SerializedName("period")
    private String period;
    @SerializedName("century")
    private String century;
    @SerializedName("address")
    private String address;
    @SerializedName("longitude")
    private double longitude;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("category")
    private String category;
    @SerializedName("overviewImg")
    private String overviewImg;
    private long createdAt;


    public Monument(int ID,
                    String title,
                    String overview,
                    String history,
                    String className, String type,
                    String period,
                    String century,String address, double longitude, double latitude, String category,
                    String overviewImg) {
        this.ID = ID;
        this.title = title;
        this.overview = overview;
        this.history = history;
        this.className = className;
        this.type = type;
        this.century=century;
        this.period = period;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.category = category;
        this.overviewImg = overviewImg;
this.createdAt=System.currentTimeMillis();
    }

    public Monument(int ID, String title, String overview, String history, String address, double longitude, double latitude,
                    String category, String overviewImg) {
        this.ID = ID;
        this.title = title;
        this.overview = overview;
        this.history = history;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.category = category;
        this.overviewImg = overviewImg;
        this.createdAt=System.currentTimeMillis();

    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOverviewImg() {   return overviewImg;   }

    public void setOverviewImg(String overviewImg) {
        this.overviewImg = overviewImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCentury() {
        return century;
    }

    public void setCentury(String century) {
        this.century = century;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
