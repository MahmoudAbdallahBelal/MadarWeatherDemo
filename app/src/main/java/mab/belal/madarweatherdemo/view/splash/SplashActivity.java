package mab.belal.madarweatherdemo.view.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import mab.belal.madarweatherdemo.R;
import mab.belal.madarweatherdemo.view.list_cities.CityListActivity;


public class SplashActivity extends AppCompatActivity {

    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        mIntent = new Intent(this, CityListActivity.class);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(mIntent);
                finish();
            }
        }, 3000);


    }
}
