package mab.belal.madarweatherdemo.view.list_cities;


import java.util.ArrayList;

import mab.belal.madarweatherdemo.baseClass.BaseView;
import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;

//class created for register function for main view
public interface CityListView extends BaseView {

    void showLoading();
    void hideLoading();
    void showMessage(String message);
    void getCityList(ArrayList<CityAttributes> items);
    void showEmptyList();

}
