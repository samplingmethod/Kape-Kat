package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.UUID;

import io.realm.Realm;

@EActivity(R.layout.activity_review)

public class ReviewActivity extends AppCompatActivity {

    @Extra
    String uuid;

    @ViewById
    EditText ptReviewText;

    @ViewById
    Button btnSubmit;

    Realm realm;

    @AfterViews
    public void init() {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
    }

    @Click
    public void btnSubmit() {
        String review = ptReviewText.getText().toString();
        Review newReview = new Review();
        newReview.setUuid(UUID.randomUUID().toString());
        newReview.setUser_uuid(uuid);
        newReview.setReview(review);
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(newReview);  // save
            realm.commitTransaction();

            Toast t = Toast.makeText(this, "New Review saved", Toast.LENGTH_LONG);
            t.show();

            Intent intent = new Intent(this, ReviewActivity_.class);
            intent.putExtra("uuid", uuid);
            startActivity(intent);
        } catch (Exception e) {
            Toast t = Toast.makeText(this, "Error saving", Toast.LENGTH_LONG);
            t.show();
        }
    }
}