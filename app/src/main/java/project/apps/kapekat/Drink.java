package project.apps.kapekat;

import android.media.Image;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Drink extends RealmObject {

    @PrimaryKey
    private String uuid;
    private String drink;
    private String price;
    private String img_url;

    public Drink() {
    }

    public Drink(String uuid, String drink, String price, String img_url) {
        this.uuid = uuid;
        this.drink = drink;
        this.price = price;
        this.img_url = img_url;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "uuid='" + uuid + '\'' +
                ", drink='" + drink + '\'' +
                ", price='" + price + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
