package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;

@EActivity(R.layout.activity_item_catpuccino)

public class ItemCatpuccino extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_catpuccino);
    }
}