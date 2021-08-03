package project.apps.kapekat;

import android.media.Image;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Drink extends RealmObject {

    @PrimaryKey
    private String uuid;
    private Image picture;
    private String drink;
    private String price;

    public Drink() {
    }

    public Drink(String uuid, Image picture, String drink, String price) {
        this.uuid = uuid;
        this.picture = picture;
        this.drink = drink;
        this.price = price;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "uuid='" + uuid + '\'' +
                ", picture=" + picture +
                ", drink='" + drink + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
