package diellza.touristguide.Models;


public class Monument {

    private int ID;
    private String title;
    private String overview;
    private String history;
    private String founder;
    private int year;
    private String entryFee;
    private String address;
    private double longitude;
    private double latitude;
    private String category;
    private int overviewImg;
    private int historyImg;

    public Monument(int ID, String title, String overview, String history, String founder, int year,
                    String entryFee, String address, double longitude, double latitude, String category,
                    int overviewImg, int historyImg) {
        this.ID = ID;
        this.title = title;
        this.overview = overview;
        this.history = history;
        this.founder = founder;
        this.year = year;
        this.entryFee = entryFee;
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

    public int getID() {
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

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }
}
