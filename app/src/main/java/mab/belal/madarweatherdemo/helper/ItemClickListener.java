package mab.belal.madarweatherdemo.helper;

import android.view.View;

import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;


//this interface class for communication between Adapter and View
public interface ItemClickListener {
    void onItemClick(int position, CityAttributes item, View view);
}
