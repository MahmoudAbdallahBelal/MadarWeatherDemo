package mab.belal.madarweatherdemo.helper;

import android.content.Context;


public class CheckInternet {

        //   return internet status
    public static boolean checkConnection(Context mContext) {
            if (ConnectivityReceiver.isConnected()) {
               return  true;
            } else {
                return false;
            }

    }

}
