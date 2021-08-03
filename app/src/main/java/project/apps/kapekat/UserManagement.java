package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

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

import io.realm.Realm;

@EActivity(R.layout.activity_main)

public class UserManagement extends AppCompatActivity {
    @Extra
    String uuid;
@ViewById
TextView tvUserName, tvLogOut;

@ViewById
EditText ptUserPassword, ptUserPassword2;

@ViewById
Button btnUpdate, btnCancel;

Realm realm;
User u;

    @AfterViews
    public void init()
    {
        realm = Realm.getDefaultInstance();
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
        tvUserName.setText(u.getUsername());
    }
    @Click
    public void btnUpdate() {
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
        String new_pw = ptUserPassword.getText().toString();
        String new_pw2 = ptUserPassword2.getText().toString();
            if (new_pw.equals(new_pw2)) {
                realm.beginTransaction();
                u.setPassword(new_pw);
                realm.commitTransaction();
                Toast t2 = Toast.makeText(this, "User Password Updated", Toast.LENGTH_LONG);
                t2.show();
                // _.intent(this).start();
            }
            else {
                Toast t1 = Toast.makeText(this, "Confirm password does not match", Toast.LENGTH_LONG);
                t1.show();
            }
        }
    @Click
    public void btnCancel(){
        // _.intent(this).start();
    }
    @Click
    public void tvLogOut(){
        MainActivity_.intent(this).start();
    }
    }