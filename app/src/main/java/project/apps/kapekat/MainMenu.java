package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        u = realm.where(User.class).equalTo("uuid", uuid).findFirst();
        tvWelcomeBack.setText("Welcome back, "+u.getUsername()+"!");
    }

    @Click(R.id.btnRate)
    public void btnRate()
    {
        Intent intent = new Intent(this, ReviewActivity_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    @Click(R.id.btnUserManagement)
    public void btnUserManagement()
    {
        Intent intent = new Intent(this, UserManagement_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }
    @Click(R.id.btnLilyLatteMain)
    public void latte()
    {
        Intent intent = new Intent(this, ItemLilysLatte_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    @Click(R.id.btnMeowtchaMain)
    public void matcha()
    {
        Intent intent = new Intent(this, ItemMeowtcha_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    @Click(R.id.btnAmericatoMain)
    public void americano()
    {
        Intent intent = new Intent(this, ItemAmericato_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    @Click(R.id.btnChaiMain)
    public void chaitea()
    {
        Intent intent = new Intent(this, ItemChaiameseTea_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    @Click(R.id.btnCatpuccinoMain)
    public void cappuccino()
    {
        Intent intent = new Intent(this, ItemCatpuccino_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

    @Click(R.id.btnMochatMain)
    public void mocha()
    {
        Intent intent = new Intent(this, ItemMochatLatte_.class);
        intent.putExtra("uuid", uuid);
        startActivity(intent);
    }

}