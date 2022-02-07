package Data;

import android.provider.BaseColumns;

public class GameDataStructure {
    public static abstract class GameDataColums implements BaseColumns{
        public static final String TABLE_NAME ="puntuazioa_offline";
        public static final String PUNTUAZIOA = "puntuazioa";
        public static final String DATA = "data";
        public static final String EMPLOYEEID = "employeeid";
        public static final String ADINA = "adina";
        public static final String DEPARTAMENDUA = "departamendua";
    }

}
