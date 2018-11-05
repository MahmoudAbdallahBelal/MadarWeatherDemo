package mab.belal.madarweatherdemo.view.list_cities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mab.belal.madarweatherdemo.R;
import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;
import mab.belal.madarweatherdemo.di.DaggerApplication;
import mab.belal.madarweatherdemo.helper.ItemClickListener;
import mab.belal.madarweatherdemo.view.adapters.CityItemAdapter;
import mab.belal.madarweatherdemo.view.add_city.AddCityActivity;

public class CityListActivity extends AppCompatActivity  implements CityListView , ItemClickListener, View.OnClickListener{



    @BindView(R.id.text_no_cities)
    public TextView tvNoCities;

    @BindView(R.id.recyclerView_cities)
    public RecyclerView recyclerViewCities;

    @BindView(R.id.progress_cities)
    public ProgressBar progressBarCitiesLoading;

    @BindView(R.id.floatingActionButton_city)
    public FloatingActionButton floatingActionButtonAddCity;


    @Inject
    CityListPresenter cityListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        ((DaggerApplication)getApplication()).getAppComponent().inject(this);
        cityListPresenter.onAttach(this);

        ButterKnife.bind(this);

        floatingActionButtonAddCity.setOnClickListener(this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewCities.setLayoutManager(linearLayoutManager);
        recyclerViewCities.setHasFixedSize(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        cityListPresenter.getAllSavedCitiesPresenter();

    }

    @Override
    public void onAttache() {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void showLoading() {

        progressBarCitiesLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        progressBarCitiesLoading.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void getCityList(ArrayList<CityAttributes> items) {

      CityItemAdapter adapter  = new CityItemAdapter(this,items,this);
      recyclerViewCities.setAdapter(adapter);
    }

    @Override
    public void showEmptyList() {
       tvNoCities.setVisibility(View.VISIBLE);
       recyclerViewCities.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(int position, CityAttributes item, View view) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.floatingActionButton_city :

                startActivity(new Intent(CityListActivity.this , AddCityActivity.class));
                break;

        }
    }
}
