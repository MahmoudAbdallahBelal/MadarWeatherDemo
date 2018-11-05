package mab.belal.madarweatherdemo.view.list_cities;

import android.content.Context;

import javax.inject.Inject;

import mab.belal.madarweatherdemo.baseClass.BasePresenter;
import mab.belal.madarweatherdemo.data.cloud.apiClient.ApiInterface;
import mab.belal.madarweatherdemo.data.local.sqlLite.ItemDbHelper;
import mab.belal.madarweatherdemo.di.DaggerApplication;


public class CityListPresenter implements BasePresenter<CityListView> {
    CityListView mView;

    //inject api interface object

    @Inject
    ApiInterface mApiInterface;

    @Inject
    Context mContext;

    // create sqllit reference
    @Inject
    ItemDbHelper mItemDbHelper;

    @Override
    public void onAttach(CityListView view) {
        mView = view;
        mView.onAttache();
    }



    @Override
    public void onDetach() {
        mView = null;
    }
    //create Constructor to get reference of api interface object

    public CityListPresenter(Context context){
        ((DaggerApplication)context).getAppComponent().inject(this);
    }

    //this function created to load items from specific endpoint
    public void getAllSavedCitiesPresenter() {


        mView.showLoading();

        if(mItemDbHelper.getAllCities().size() > 0) {

            mView.getCityList(mItemDbHelper.getAllCities());
        }
       else
           {
            mView.showEmptyList();
        }

        mView.hideLoading();
    }




}
