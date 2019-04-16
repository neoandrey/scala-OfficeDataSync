import java.text.SimpleDateFormat
import java.util.Calendar

class OfficeTable (name:String, isDaily:Boolean, tableSelect:String) {

    var  tableName:String           = name;
    var  isDailyTable:Boolean       = isDaily;
    var  selectScript:String        =  tableSelect;
    var  recordCount:Long           = 0;
    val  dFormat: SimpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
    val  dFormat2: SimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    var  cal: Calendar = Calendar.getInstance;
    cal.add(Calendar.DATE, -1);
    var  dateSuffix:String =  dFormat.format(cal.getTime())+"_"+dFormat2.format(cal.getTime());
    tableName +="_"+dateSuffix;




}
