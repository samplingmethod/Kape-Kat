package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import io.realm.Realm;

@EActivity(R.layout.activity_item_lilys_latte)

public class ItemLilysLatte extends AppCompatActivity {

    @Extra
    String uuid;

    @ViewById(R.id.etQuantityInput)
    TextView etQuantityNum;

    @ViewById(R.id.btnOrder)
    Button btnOrder;

    @ViewById(R.id.btnItemCancel)
    Button btnCancel;

    Realm realm;
    User u;
    @AfterViews
    public void init()
    {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
    }
    @Click(R.id.btnItemCancel)
    public void btnCancel(){
        Intent intent = new Intent(this, MainMenu_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }
    @Click(R.id.btnOrder)
    public void btnOrder(){
        int qty = Integer.parseInt(etQuantityNum.getText().toString());

        Drink newOrder =  new Drink();
        newOrder.setUuid(UUID.randomUUID().toString());
        newOrder.setDrink("Lily's Latte");
        newOrder.setPrice(160);
        newOrder.setQty(qty);
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(newOrder);  // save
            realm.commitTransaction();
            Toast t = Toast.makeText(this, "Order confirmed", Toast.LENGTH_LONG);
            t.show();
            Intent intent = new Intent(this, OrderSummary_.class);
            intent.putExtra("uuid", newOrder.getUuid());
            intent.putExtra("user_uuid", uuid);
            startActivity(intent);
        }

        catch(Exception e)
        {
            Toast t = Toast.makeText(this, "Error ordering", Toast.LENGTH_LONG);
            t.show();
        }
    }
}
