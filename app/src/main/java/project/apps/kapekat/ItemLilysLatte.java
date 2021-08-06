package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

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

    @AfterViews
    public void init()
    {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_lilys_latte);
    }
}