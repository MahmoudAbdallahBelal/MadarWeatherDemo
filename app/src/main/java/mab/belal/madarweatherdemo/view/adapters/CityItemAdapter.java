package mab.belal.madarweatherdemo.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mab.belal.madarweatherdemo.R;
import mab.belal.madarweatherdemo.data.models.local.city.CityAttributes;
import mab.belal.madarweatherdemo.helper.ItemClickListener;
import mab.belal.madarweatherdemo.helper.ItemViewHolder;


public class CityItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private  Context  context;
    private ArrayList<CityAttributes> items;
    private ItemClickListener mItemClickListener;


    public CityItemAdapter(Context context, ArrayList<CityAttributes> items, ItemClickListener itemClickListener){
        this.context = context;
        this.items = items;
        mItemClickListener = itemClickListener;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        final CityAttributes item = items.get(position);
        holder.tvCityName.setText(item.getName());
        double temp = Double.parseDouble(item.getTemp()) - 273.15 ;
         temp =  Math.rint(temp);

        holder.tvCityTemp.setText(String.valueOf(temp) + " °C");


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
