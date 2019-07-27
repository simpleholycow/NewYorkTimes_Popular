package xebia.newyorktimes;

import android.app.Application;

import xebia.newyorktimes.di.components.ApplicationComponent;
import xebia.newyorktimes.di.components.DaggerApplicationComponent;
import xebia.newyorktimes.di.modules.ApplicationModule;

public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public MyApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

}
