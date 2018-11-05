package mab.belal.madarweatherdemo.di;

import android.app.Application;



// this call create to do some thing when application starts and you must register this file in manifest file
public class DaggerApplication extends Application {
    private AppComponent appComponent;
    public static DaggerApplication mDaggerApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
        mDaggerApplication  = this;
    }



    // this function for creating or generate dagger files
    protected AppComponent initDagger(DaggerApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    //this function for returning  appComponent reference
    public AppComponent getAppComponent() {
        return appComponent;
    }


    public static DaggerApplication getDaggerApplication() {
        return mDaggerApplication;
    }




}
