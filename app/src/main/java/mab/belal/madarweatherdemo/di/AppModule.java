package mab.belal.madarweatherdemo.di;

import android.app.Application;
import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mab.belal.madarweatherdemo.data.local.sqlLite.ItemDbHelper;


//this class created to put main providers an all application
@Module
public class AppModule {

    private Application application;

    //provide  application reference
    public AppModule(Application application) {
        this.application = application;
    }


    //provide  context
    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }


    //provide  item helper for sqllit
    @Provides
    @Singleton
    public ItemDbHelper provideItemHelper(Context context) {
        return new ItemDbHelper(context);
    }










}
