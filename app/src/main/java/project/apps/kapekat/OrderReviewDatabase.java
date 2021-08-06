package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;



@EActivity(R.layout.activity_order_review_management)
public class OrderReviewDatabase extends AppCompatActivity {

    @Extra
    String uuid;

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    @ViewById(R.id.btnBack)
    Button btnBack;

    @ViewById
    TextView tvUserReviews;

    Realm realm;
    User u;

    @AfterViews
    public void init() {
        LinearLayoutManager mlayoutmanager = new LinearLayoutManager(this);
        mlayoutmanager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(mlayoutmanager);
        realm = Realm.getDefaultInstance();
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
        String un = u.getUsername();
        tvUserReviews.setText(un + "'s Reviews");

        RealmResults<Review> list = realm.where(Review.class).findAll();
        ReviewAdapter adapter = new ReviewAdapter(this, list, true);
        recyclerView.setAdapter(adapter);
    }

    @Click
    public void btnBack(){
        MainMenu_.intent(this).start();
    }

}
