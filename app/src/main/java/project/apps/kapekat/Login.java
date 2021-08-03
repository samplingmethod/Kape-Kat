package project.apps.kapekat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
@EActivity(R.layout.activity_login)

public class Login extends AppCompatActivity
{

    @ViewById(R.id.ptUsernameLogin)
    EditText username;

    @ViewById(R.id.ptPasswordLogin)
    EditText password;

    @ViewById(R.id.btnLogin)
    Button login;

    @ViewById(R.id.tvRegister)
    TextView Register;

    @ViewById(R.id.cbRememberMe)
    CheckBox cb;

    Realm realm;

    @AfterViews
    public void init(){
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        //Code for Signup (start)
        String text = "Don't have an account yet? Sign Up";
        SpannableString ss = new SpannableString(text);
        ClickableSpan SignUp = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(Login.this, Register_.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#009688"));
                ds.setUnderlineText(false);

            }
        };

        ss.setSpan(SignUp, 27, 34,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Register.setText(ss);
        Register.setMovementMethod(LinkMovementMethod.getInstance());

        //Code for Signup (end)

//        realm = Realm.getDefaultInstance();
//        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
//        Boolean check = preferences.getBoolean("rememberme", false);
//        String uuid = preferences.getString("uuid", null);

    }
    @Click(R.id.btnLogin)
    public void login(){

        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        String un = username.getText().toString();
        String pword = password.getText().toString();

        User results = realm.where(User.class).equalTo("username", un).findFirst();
        if (results != null) {
            String check_un = results.getUsername();
            String check_pw = results.getPassword();
            String check_uuid = results.getUuid();

            if ((check_un.equals(un)) && (check_pw.equals(pword))) {
                if (cb.isChecked()) {
                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putBoolean("rememberme", true);
                    edit.putString("uuid", check_uuid);
                    edit.apply();
                } else {
                    SharedPreferences.Editor edit = preferences.edit();
                    edit.putBoolean("rememberme", false);
                    edit.putString("uuid", check_uuid);
                    edit.apply();
                }
                MainMenu_.intent(this).start();
            }
            else {
                Toast toast = Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG);
                toast.show();
            }
        }
        if (results==null) {
            Toast toast = Toast.makeText(this, "No User Found", Toast.LENGTH_LONG);
            toast.show();
        }
    }

//    @Click(R.id.btnLogin)
//    public void login(){
//
//        SharedPreferences prefs = getSharedPreferences("creds", MODE_PRIVATE);
//
//        // Input fields
//        String Username = username.getText().toString();
//        String Password = password.getText().toString();
//
//        // Preferences fields
//
//        String prefsUN = prefs.getString("un", null);
//        String prefsPW =  prefs.getString("pw", null);
//
//        // Source: https://stackoverflow.com/questions/13910156/how-to-check-the-sharedpreferences-string-is-empty-or-null-android/13910268
//
//        User info = realm.where(User.class).equalTo("username", Username).findFirst();
//
//        if (info == null)
//        {
//            Toast toast = Toast.makeText(Login.this, "No user found", Toast.LENGTH_LONG);
//            toast.show();
//        }
//
//        else if (info != null)
//        {
//            String realmUsername = info.getUsername();
//            String realmPassword = info.getPassword();
//            String realmUuid = info.getUuid();
//
//            if ((realmUsername.equals(Username)) && (realmPassword.equals(Password)))
//            {
//                if (cb.isChecked())
//                {
//                    SharedPreferences.Editor edit = prefs.edit();
//                    edit.putBoolean("rm", true);
//                    edit.putString("uuid", realmUuid);
//                    edit.apply();
//                }
//                else
//                {
//                    SharedPreferences.Editor edit = prefs.edit();
//                    edit.putBoolean("rm", false);
//                    edit.putString("uuid", realmUuid);
//                    edit.apply();
//
//                }
//                MainMenu_.intent(this).start();
//            }
//            else
//            {
//                Toast toast = Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_LONG);
//                toast.show();
//            }
//        }
//
//
//
//    }
//
//    public void onDestroy()
//    {
//        super.onDestroy();
//        realm.close();
//    }
}

