package mab.belal.madarweatherdemo.helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import mab.belal.madarweatherdemo.R;


// create view holder for single menu single item
public class ItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text_item_city_name)
    public TextView tvCityName;

    @BindView(R.id.text_item_city_temp)
    public TextView tvCityTemp;


    public ItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this , itemView);
    }


}