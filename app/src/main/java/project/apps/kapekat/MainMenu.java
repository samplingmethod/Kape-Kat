package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;

@EActivity(R.layout.activity_main_menu)

public class MainMenu extends AppCompatActivity {
    @Extra
    String uuid;

    @ViewById(R.id.tvWelcomeBack)
    TextView tvWelcomeBack;

    @ViewById(R.id.tvWhat)
    TextView tvWhat;

    @ViewById(R.id.btnRate)
    Button btnRate;

    @ViewById(R.id.btnUserManagement)
    Button btnUser;

    @ViewById(R.id.btnLilyLatteMain)
    Button btnLily;

    @ViewById(R.id.btnMeowtchaMain)
    Button btnMeowtcha;

    @ViewById(R.id.btnChaiMain)
    Button btnChai;

    @ViewById(R.id.btnMochatMain)
    Button btnMochat;

    @ViewById(R.id.btnAmericatoMain)
    Button btnAmericato;

    @ViewById(R.id.btnCatpuccinoMain)
    Button btnCatpuccino;

    Realm realm;
    User u;

    @AfterViews
    public void init()
    {
        realm = Realm.getDefaultInstance();
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
        String un = u.getUsername();
        Log.d("debugz",un);
        tvWelcomeBack.setText("Welcome back, @"+un+" !");
    }

    @Click(R.id.btnRate)
    public void btnRate()
    {
        Intent intent = new Intent(this, ReviewActivity_                                                                                                                                                                                                                                                                                                                                                                        .class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    public void btnUserManagement(View v)
    {
        Intent intent = new Intent(this, UserManagement_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    @Click(R.id.btnLilyLatteMain)
    public void latte()
    {
        UserManagement_.intent(this).start();
    }
}