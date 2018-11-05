package mab.belal.madarweatherdemo.di;


import javax.inject.Singleton;

import dagger.Component;
import mab.belal.madarweatherdemo.view.add_city.AddCityActivity;
import mab.belal.madarweatherdemo.view.add_city.AddCityPresenter;
import mab.belal.madarweatherdemo.view.list_cities.CityListActivity;
import mab.belal.madarweatherdemo.view.list_cities.CityListPresenter;


// this class created for register who need inject
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class,PresenterModule.class})
public interface AppComponent {


    void inject(CityListActivity cityListActivity);
    void inject(CityListPresenter cityListPresenter);

    void inject(AddCityActivity addCityActivity);
    void inject(AddCityPresenter addCityPresenter);

}
