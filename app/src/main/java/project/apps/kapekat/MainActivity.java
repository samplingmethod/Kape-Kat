package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)

public class MainActivity extends AppCompatActivity {

    @ViewById()
    Button btnLoginLanding;

    @ViewById()
    Button btnRegisterLanding;

    @AfterViews
    public void init(){

    }

    @Click(R.id.btnLoginLanding)
    public void btnLoginLanding()
    {
        Login_.intent(this).start();
    }

    @Click(R.id.btnRegisterLanding)
    public void btnRegisterLanding()
    {
        Register_.intent(this).start();
    }



}