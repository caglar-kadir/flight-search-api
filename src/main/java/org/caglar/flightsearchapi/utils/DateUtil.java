package org.caglar.flightsearchapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
    private DateUtil() {
    }

    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date d = null;
        try {
            d = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Parse Exception - Cannot parse date: " + e);
        }
        Date currentDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        if (d == null) {
            return false;
        }
        return !d.before(currentDate);
    }

    public static boolean isDepartureDateAfterArrivalDate (String departureDate, String arrivalDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try{
            Date dd = dateFormat.parse(departureDate);
            Date ad = dateFormat.parse(arrivalDate);
            if(dd.before(ad)){
                return true;
            }
        } catch (ParseException e){
            System.out.println("Parse Exception - Cannot parse date: " + e);
        }
        return false;
    }
}
