package project.apps.kapekat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.bson.types.Code;
import io.realm.Realm;

import java.util.UUID;

@EActivity(R.layout.activity_register)
public class Register extends AppCompatActivity {

    @ViewById(R.id.ptRegisterUsername)
    EditText regUsername;

    @ViewById(R.id.pwRegisterConfirmPassword)
    EditText regPW;

    @ViewById(R.id.pwRegisterConfirmPassword)
    EditText regConfirmPW;

    @ViewById(R.id.btnRegister)
    Button btnRegister;

    @ViewById(R.id.btnRegisterCancel)
    Button btnCancel;

    @ViewById(R.id.tvAlreadyLogin)
    TextView Login;

    Realm realm;

    @AfterViews
    public void init()
    {
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        String txt = "Already have an account? Login";
        SpannableString ss2 = new SpannableString(txt);
        ClickableSpan AlreadyLogin = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(Register.this, Login_.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#009688"));
                ds.setUnderlineText(false);
            }
        };

        ss2.setSpan(AlreadyLogin, 25,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Login.setText(ss2);
        Login.setMovementMethod(LinkMovementMethod.getInstance());




    }
    @Click
    public void btnRegister(){
        User result = realm.where(User.class).equalTo("username",regUsername.getText().toString()).findFirst();

        String pwd1 = regPW.getText().toString();
        String pwd2 = regConfirmPW.getText().toString();

        if (regUsername.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(Register.this, "Name must not be blank", Toast.LENGTH_LONG);
            toast.show();
        }
        else if (regPW.getText().toString().isEmpty()){
            Toast toast = Toast.makeText(Register.this, "Password must not be blank", Toast.LENGTH_LONG);
            toast.show();
        }
        else if (result != null){
            Toast toast = Toast.makeText(Register.this, "User already exists", Toast.LENGTH_LONG);
            toast.show();
        }
        else if ((!regUsername.getText().toString().isEmpty()) && (pwd1.equals(pwd2)) && (!pwd1.isEmpty())){
            User newUser =  new User();
            newUser.setUuid(UUID.randomUUID().toString());
            newUser.setUsername(regUsername.getText().toString());
            newUser.setPassword(pwd1);

            long count = 0;
            try {
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(newUser);  // save
                realm.commitTransaction();

                count = realm.where(User.class).count();

                Toast t = Toast.makeText(this, "New User saved. Total: "+count, Toast.LENGTH_LONG);
                t.show();

                Login_.intent(this).start();
            }

            catch(Exception e)
            {
                Toast t = Toast.makeText(this, "Error saving", Toast.LENGTH_LONG);
                t.show();
            }
        }
        else{
            Toast toast = Toast.makeText(Register.this, "Confirm password does not match", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}