package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main_menu)

public class MainMenu extends AppCompatActivity {

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

    @AfterViews
    public void init()
    {

    }

    @Click(R.id.btnRate)
    public void btnRate()
    {
        ReviewActivity_.intent(this).start();
    }

    @Click(R.id.btnUserManagement)
    public void btnUserManagement()
    {
        UserManagement_.intent(this).start();
    }

    @Click(R.id.btnLilyLatteMain)
    public void latte()
    {
        ItemLilysLatte_.intent(this).start();
    }

    @Click(R.id.btnMochatMain)
    public void mocha()
    {
        ItemMochatLatte_.intent(this).start();
    }

    @Click(R.id.btnChaiMain)
    public void chaitea()
    {
        ItemChaiameseTea_.intent(this).start();
    }

    @Click(R.id.btnMeowtchaMain)
    public void matcha()
    {
        ItemMeowtcha_.intent(this).start();
    }

    @Click(R.id.btnCatpuccinoMain)
    public void cappuccino()
    {
        ItemCatpuccino_.intent(this).start();
    }

    @Click(R.id.btnAmericatoMain)
    public void americano()
    {
        ItemAmericato_.intent(this).start();
    }

}