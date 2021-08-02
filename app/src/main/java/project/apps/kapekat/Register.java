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

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.bson.types.Code;

import io.realm.Realm;

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

    //Realm realm;

    @AfterViews
    public void init()
    {
        //realm = Realm.getDefaultInstance();
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



}