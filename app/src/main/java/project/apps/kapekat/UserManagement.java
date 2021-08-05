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
    Button btnCancel;

    Realm realm;
    User u;

    @AfterViews
    public void init()
    {
        realm = Realm.getDefaultInstance();
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
        tvUserName.setText(u.getUsername());
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
                MainMenu_.intent(this).start();
            }
            else {
                Toast t1 = Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_LONG);
                t1.show();
            }
        }
    @Click
    public void btnCancel(){
        MainActivity_.intent(this).start();
    }
}