package com.github.tenx.tecnoesis20.ui;

import android.app.Application;

import androidx.lifecycle.ViewModelProviders;

import com.github.tenx.tecnoesis20.BuildConfig;
import com.github.tenx.tecnoesis20.data.AppDataManager;
import com.github.tenx.tecnoesis20.data.models.ModuleBody;
import com.github.tenx.tecnoesis20.data.rest.events.AppEventHelper;
import com.github.tenx.tecnoesis20.logging.ReleaseTree;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MyApplication extends Application {

//    create an instance of AppDatamanager here. This instance will be stored here as a singleton
    private  AppDataManager appDataManager;
    private List<ModuleBody> moduleList;

    @Override
    public void onCreate() {
        super.onCreate();


        moduleList = new ArrayList<>();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }


    public  AppDataManager getDataManager(){
        if(appDataManager == null){
            synchronized (AppEventHelper.class){
                if(appDataManager == null){
                    appDataManager = new AppDataManager(this);
                }
            }
        }
        return appDataManager;
    }


    public List<ModuleBody> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<ModuleBody> moduleList) {
        this.moduleList = moduleList;
    }
}
