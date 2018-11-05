package mab.belal.madarweatherdemo.data.models.cloud;

import com.google.gson.annotations.SerializedName;


public class ListDetails {

    @SerializedName("main")
    private MainDetails main;


    public MainDetails getMain() {
        return main;
    }

    public void setMain(MainDetails main) {
        this.main = main;
    }
}
