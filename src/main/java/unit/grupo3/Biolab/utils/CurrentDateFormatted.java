package unit.grupo3.Biolab.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateFormatted {

    public String getDate(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormatter.format(new Date());
    }

}
