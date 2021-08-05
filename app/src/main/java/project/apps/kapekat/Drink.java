package project.apps.kapekat;

import android.media.Image;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Drink extends RealmObject {

    @PrimaryKey
    private String uuid;
    private int price;
    private int qty;
    private String drink;

    public Drink() {
    }

    public Drink(String uuid, int price, int qty, String drink) {
        this.uuid = uuid;
        this.price = price;
        this.qty = qty;
        this.drink = drink;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "uuid='" + uuid + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", drink='" + drink + '\'' +
                '}';
    }
}
