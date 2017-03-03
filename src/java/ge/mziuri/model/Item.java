package ge.mziuri.model;

public class Item {

    private String photo;
    private String Name;
    public int Point;

    public Item() {
    }

    public Item(String photo, String Name, int Point) {
        this.photo = photo;
        this.Name = Name;
        this.Point = Point;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }

}
