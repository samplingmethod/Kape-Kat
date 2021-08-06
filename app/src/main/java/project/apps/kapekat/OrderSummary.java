package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;
import org.androidannotations.annotations.Extra;

import java.util.UUID;

@EActivity(R.layout.activity_order_summary)

public class OrderSummary extends AppCompatActivity{
    @Extra
    String uuid, user_uuid;

    @ViewById
    TextView tvOrderPlaced, textView9;

    @ViewById
    Button btnOrderReceived;

    Realm realm;
    Drink d;

    @AfterViews
    public void init(){
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        d = realm.where(Drink.class).equalTo("uuid", uuid).findFirst();
        tvOrderPlaced.setText(d.getQty()+"x "+d.getDrink());
        int total = d.getQty() * d.getPrice();
        textView9.setText("Php"+total);
    }

    @Click
    public void btnOrderReceived(){
        Intent intent = new Intent(this, MainMenu_.class);
        intent.putExtra("uuid", user_uuid);
        startActivity(intent);
    }
}