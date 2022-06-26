package inflearn.study.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MeActivity meActivity;
    MateActivity mateActivity;
    MenuActivity menuActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.button_menu);

        meActivity = new MeActivity();
        mateActivity = new MateActivity();
        menuActivity = new MenuActivity();

        //제일 처음 띄워줄 뷰 세팅
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,meActivity).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.me_btn: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, meActivity).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.mate_btn: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, mateActivity).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.menu_btn:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, menuActivity).commitAllowingStateLoss();
                        return true;
                    }
                    default: return false;
                }
            }
        });
    }
}
