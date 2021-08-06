package project.apps.kapekat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
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

@EActivity(R.layout.activity_user_management)

public class UserManagement extends AppCompatActivity {

    @Extra
    String uuid;

    @ViewById(R.id.ptUserPassword)
    EditText new_pw1;

    @ViewById(R.id.ptUserPassword2)
    EditText new_pw2;

    @ViewById
    Button btnUpdate;

    @ViewById(R.id.tvUserName)
    TextView tvUserName;

    @ViewById
    TextView tvLogOut;

    @ViewById
    Button btnCancel;


    Realm realm;
    User u;

    @AfterViews
    public void init()
    {
        realm = Realm.getDefaultInstance();
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
        tvUserName.setText(u.getUsername());

        //Code for Signup (start)
        String text = "Logout here";
        SpannableString ss = new SpannableString(text);
        ClickableSpan SignUp = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(UserManagement.this, MainActivity_.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#A26A4C"));
                ds.setUnderlineText(false);

            }
        };

        ss.setSpan(SignUp, 0, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvLogOut.setText(ss);
        tvLogOut.setMovementMethod(LinkMovementMethod.getInstance());

        //Code for Signup (end)
    }
    @Click(R.id.btnUpdate)
    public void btnUpdate() {
        User result2 = realm.where(User.class).equalTo("uuid", uuid).findFirst();

            String new_passw1 = new_pw1.getText().toString();
            String new_passw2 = new_pw2.getText().toString();
            if (new_passw1.equals(new_passw2)) {
                realm.beginTransaction();
                u.setPassword(new_passw1);
                realm.commitTransaction();
                Toast t2 = Toast.makeText(this, "Edit Saved", Toast.LENGTH_LONG);
                t2.show();
                Intent intent = new Intent(this, MainMenu_.class);
                intent.putExtra("uuid", uuid);
                startActivity(intent);
            }
            else {
                Toast t1 = Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_LONG);
                t1.show();
            }
        }
    @Click(R.id.btnCancel)
    public void btnCancel(){
        Intent intent = new Intent(this, MainMenu_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

}