package mab.belal.madarweatherdemo.view.add_city;


import mab.belal.madarweatherdemo.baseClass.BaseView;
import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;

//class created for register function for main view
public interface AddCityView extends BaseView {

    void showLoading();
    void hideLoading();
    void showMessage();
    void showInternetMessage();

    void setCounter(int counter);
    void saveCity(CityAttributes items);

}
