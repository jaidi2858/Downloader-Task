package com.rapidzz.kidcap.Utils.GeneralUtils;



public class AppInstance {


    public AppInstance() {
    }




    

    private static class SingletonHelper {
        private static final AppInstance uniqInstance = new AppInstance();
    }

    public static AppInstance getInstance() {
        return SingletonHelper.uniqInstance;
    }

}