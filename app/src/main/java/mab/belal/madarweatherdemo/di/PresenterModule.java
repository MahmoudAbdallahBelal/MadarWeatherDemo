package mab.belal.madarweatherdemo.di;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mab.belal.madarweatherdemo.view.add_city.AddCityPresenter;
import mab.belal.madarweatherdemo.view.list_cities.CityListPresenter;


//this class created to put  providers for Presenters

@Module
public class PresenterModule {


    @Provides
    @Singleton
    CityListPresenter provideCityListPresenter(Context context) {
        return new CityListPresenter(context);
    }


    @Provides
    @Singleton
    AddCityPresenter provideAddCityPresenter(Context context) {
        return new AddCityPresenter(context);
    }



}

