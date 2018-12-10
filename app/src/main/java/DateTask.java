import java.util.Calendar;
import java.util.*;
import java.text.*;
public class DateTask{


    public long subtractTimes(String time1, String time2)
    {
        time1 = "5:03 PM";
        time2 = "8:00 AM";
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        Date d1 = new Date();
        Date d2 = new Date();
        try{
            d1 = formatter.parse(time1);
            d2 = formatter.parse(time2);
        }catch(ParseException ex)
        {ex.printStackTrace();}

        long timeDiff = d2.getTime() - d1.getTime();
        Math.abs(timeDiff);
        return timeDiff;
    }
}