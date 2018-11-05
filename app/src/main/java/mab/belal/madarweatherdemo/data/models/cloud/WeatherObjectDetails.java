package mab.belal.madarweatherdemo.data.models.cloud;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WeatherObjectDetails {


    @SerializedName("cod")
    private String code;

    @SerializedName("list")
    private List<ListDetails> list;

    @SerializedName("city")
    private CityDetails city;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ListDetails> getList() {
        return list;
    }

    public void setList(List<ListDetails> list) {
        this.list = list;
    }

    public CityDetails getCity() {
        return city;
    }

    public void setCity(CityDetails city) {
        this.city = city;
    }



}
