package project.apps.kapekat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.realm.Realm;
import io.realm.RealmResults;



@EActivity(R.layout.activity_admin)
public class Admin extends AppCompatActivity {

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    @ViewById
    Button btnLogOut;

    Realm realm;

    @AfterViews
    public void init(){
        LinearLayoutManager mlayoutmanager = new LinearLayoutManager(this);
        mlayoutmanager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(mlayoutmanager);

        realm = Realm.getDefaultInstance();

        RealmResults<User> list = realm.where(User.class).findAll();
        UserAdapter adapter = new UserAdapter(this,list,true);
        recyclerView.setAdapter(adapter);
    }
    @Click
    public void btnLogOut() {
        MainActivity_.intent(this).start();
    }
}
