package Zodiac;

public class Zodiac {
    private int image;
    private String name, date, details;


    public Zodiac(int image, String name, String date, String details) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.details=details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
