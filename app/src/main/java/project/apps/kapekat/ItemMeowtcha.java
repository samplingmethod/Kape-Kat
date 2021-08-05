package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_item_meowtcha)

public class ItemMeowtcha extends AppCompatActivity {

    @ViewById(R.id.etQuantityInput)
    TextView etQuantityNum;

    @ViewById(R.id.btnOrder)
    Button btnOrder;

    @ViewById(R.id.btnItemCancel)
    Button btnCancel;

    @AfterViews
    public void init()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_meowtcha);
    }
}