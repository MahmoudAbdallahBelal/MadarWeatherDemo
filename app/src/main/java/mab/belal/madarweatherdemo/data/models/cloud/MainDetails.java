package mab.belal.madarweatherdemo.data.models.cloud;

import com.google.gson.annotations.SerializedName;


public class MainDetails {

    @SerializedName("temp")
    private double temp;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
