package diellza.touristguide.Models;

/**
 * Created by SINKOPA on 3/20/2018.
 */

public class Category {
    private String title;
    private int thumbnail;

    public Category(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
