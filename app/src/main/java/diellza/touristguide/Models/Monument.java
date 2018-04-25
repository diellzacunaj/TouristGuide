package diellza.touristguide.Models;


import java.io.Serializable;

public class Monument implements Serializable{

    private long ID;
    private String title;
    private String overview;
    private String history;
    private String className;
    private String type;
    private String period;
    private String century;
    private String address;
    private double longitude;
    private double latitude;
    private String category;
    private int overviewImg;
    private int historyImg;

    public Monument(int ID,
                    String title,
                    String overview,
                    String history,
                    String className, String type,
                    String period,
                    String century,String address, double longitude, double latitude, String category,
                    int overviewImg, int historyImg) {
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
        this.historyImg = historyImg;
    }

    public Monument(int ID, String title, String overview, String history, String address, double longitude, double latitude,
                    String category, int overviewImg, int historyImg) {
        this.ID = ID;
        this.title = title;
        this.overview = overview;
        this.history = history;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.category = category;
        this.overviewImg = overviewImg;
        this.historyImg = historyImg;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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

    public int getOverviewImg() {   return overviewImg;   }

    public void setOverviewImg(int overviewImg) {
        this.overviewImg = overviewImg;
    }

    public int getHistoryImg() {  return historyImg;    }

    public void setHistoryImg(int historyImg) {
        this.historyImg = historyImg;
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
}
