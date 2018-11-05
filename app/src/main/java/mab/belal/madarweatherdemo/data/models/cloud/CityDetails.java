package mab.belal.madarweatherdemo.data.models.cloud;

import com.google.gson.annotations.SerializedName;


public class CityDetails
{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoordDetails getCoord() {
        return coord;
    }

    public void setCoord(CoordDetails coord) {
        this.coord = coord;
    }

    @SerializedName("name")

    private String name;

    @SerializedName("coord")
    private CoordDetails coord;
}
