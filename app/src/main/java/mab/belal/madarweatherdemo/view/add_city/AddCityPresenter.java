package mab.belal.madarweatherdemo.view.add_city;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import mab.belal.madarweatherdemo.baseClass.BasePresenter;
import mab.belal.madarweatherdemo.data.cloud.apiClient.ApiInterface;
import mab.belal.madarweatherdemo.data.cloud.apiClient.EndPoints;
import mab.belal.madarweatherdemo.data.local.sqlLite.ItemDbHelper;
import mab.belal.madarweatherdemo.data.models.cloud.WeatherObjectDetails;
import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;
import mab.belal.madarweatherdemo.di.DaggerApplication;
import mab.belal.madarweatherdemo.helper.CheckInternet;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class AddCityPresenter implements BasePresenter<AddCityView> {
    AddCityView mView;
    CityAttributes cityAttributes;

    //inject api interface object

    @Inject
    ApiInterface mApiInterface;

    @Inject
    Context mContext;

    // create sqllit reference
    @Inject
    ItemDbHelper mItemDbHelper;

    int counter = 0;



    @Override
    public void onAttach(AddCityView view) {
        mView = view;
        mView.onAttache();
    }



    @Override
    public void onDetach() {
        mView = null;
    }
    //create Constructor to get reference of api interface object

    public AddCityPresenter(Context context){
        ((DaggerApplication)context).getAppComponent().inject(this);
    }

    //this function created to load items from specific endpoint
    public void addSelectedCitiesPresenter(String lat , String lon) {

        try {

            if(!CheckInternet.checkConnection(mContext)){
                mView.showInternetMessage();
                return;
            }


            cityAttributes = new CityAttributes();
            mView.showLoading();
            mApiInterface.getWeatherInformationObservable(lat, lon, EndPoints.CNT, EndPoints.APPID)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<WeatherObjectDetails>() {
                        @Override
                        public final void onCompleted() {

                            mView.hideLoading();
                        }

                        @Override
                        public final void onError(Throwable e) {

                            mView.hideLoading();
                        }

                        @Override
                        public final void onNext(WeatherObjectDetails response) {


                            if (response.getCode().equals("200")) {
                                cityAttributes.setName(response.getCity().getName());
                                cityAttributes.setLat("" + response.getCity().getCoord().getLat());
                                cityAttributes.setLon("" + response.getCity().getCoord().getLon());
                                cityAttributes.setTemp("" + response.getList().get(0).getMain().getTemp());

                                mView.saveCity(cityAttributes);
                                counter++;
                                mView.setCounter(counter);


                            }


                        }
                    });

        }
        catch (Exception e)
        {
            mView.showMessage();
        }

    }


    public void setCounterPresenter(int counter)
    {
        this.counter = counter;
    }
    public void saveListOfCitiesLocalData(List<CityAttributes> items) {
        mItemDbHelper.saveCities(items);
    }




}
