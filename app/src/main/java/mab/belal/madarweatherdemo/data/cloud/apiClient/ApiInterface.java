package mab.belal.madarweatherdemo.data.cloud.apiClient;



import mab.belal.madarweatherdemo.data.models.cloud.WeatherObjectDetails;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {



    @GET(EndPoints.GET_WEATHER_GEO)
    Observable<WeatherObjectDetails> getWeatherInformationObservable(@Query("lat") String lat, @Query("lon") String lon, @Query("cnt") String cnt, @Query("APPID") String appid);








}
