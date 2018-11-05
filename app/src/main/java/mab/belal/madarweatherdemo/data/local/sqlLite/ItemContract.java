package mab.belal.madarweatherdemo.data.local.sqlLite;

import android.provider.BaseColumns;


public class ItemContract {

    public static final class ItemEntry implements BaseColumns {

        public static final String TABLE_NAME = "city";

        public static final String COLUMN_CITY_NAME = "city_name";
        public static final String COLUMN_CITY_LAT = "lat";
        public static final String COLUMN_CITY_LON = "lon";
        public static final String COLUMN_CITY_Temp = "temp";



    }
}
