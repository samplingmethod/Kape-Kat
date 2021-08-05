package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

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

@EActivity(R.layout.activity_order_review_management)

public class OrderReviewDatabase extends AppCompatActivity {
}