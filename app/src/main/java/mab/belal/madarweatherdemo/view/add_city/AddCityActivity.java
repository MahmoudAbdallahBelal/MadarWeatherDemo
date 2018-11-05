package mab.belal.madarweatherdemo.view.add_city;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mab.belal.madarweatherdemo.R;
import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;
import mab.belal.madarweatherdemo.di.DaggerApplication;

public class AddCityActivity extends FragmentActivity implements OnMapReadyCallback , AddCityView  {

    private GoogleMap mMap;
    List<CityAttributes> cityAttributesList ;
    List<Address> address;
    Geocoder geocoder;


    @Inject
    AddCityPresenter addCityPresenter;


    @BindView(R.id.text_counter)
    public TextView tvCounter;

    @BindView(R.id.progressBar_get_city_info)
    public ProgressBar progressBarLoadingCityInfo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);


        ((DaggerApplication)getApplication()).getAppComponent().inject(this);
        addCityPresenter.onAttach(this);
        ButterKnife.bind(this);

        cityAttributesList = new ArrayList<>();
        address = new ArrayList<>();
        addCityPresenter.setCounterPresenter(0);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }




    @Override
    protected void onPause() {
        super.onPause();

        if(cityAttributesList.size() != 0)
        {
            addCityPresenter.saveListOfCitiesLocalData(cityAttributesList);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
         geocoder = new Geocoder(this, Locale.getDefault());


        if(mMap != null) {


            mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(LatLng latLng) {
                    try {
                        mMap.clear();
                        address = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                        mMap.addMarker(new MarkerOptions().position(latLng).title(address.get(0).getAddressLine(0)));

                        // TODO Call Cloud API
                        addCityPresenter.addSelectedCitiesPresenter(String.valueOf(latLng.latitude) , String.valueOf(latLng.longitude));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

    }


    @Override
    public void onAttache() {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void showLoading() {

        progressBarLoadingCityInfo.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {

        progressBarLoadingCityInfo.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage() {
        Toast.makeText(this, getString(R.string.wait), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInternetMessage() {
        Toast.makeText(this, getString(R.string.check_internet), Toast.LENGTH_LONG).show();
    }

    @Override
    public void setCounter(int counter) {
        tvCounter.setText(""+getString(R.string.you_saved) +" " + counter);
    }

    @Override
    public void saveCity(CityAttributes items) {

        cityAttributesList.add(items);


    }
}
