import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.DriverManager;
import java.sql.{Connection, DriverManager, ResultSet};

class OfficeSyncSpecification{

     var sourceServerName:      String="";
     var destinationServerName: String="";

     var sourceDatabase:        String="";
     var destinationDatabase:   String="";

     var sourceUserName: String="";
     var destinationUserName: String="";

     var sourcePassword:      String= "";
     var destinationPassword: String= "";

     var srcPort:Int              =1433;
     var destinationPort: Int     =1433;

     val TABLE_COPY_MODE: Int    = 0;
     val SCRIPT_COPY_MODE: Int   = 0;
     var copyMode: Int           = 0;

     var shouldTruncate: Boolean = false;
     var copyScript: String   ="";
     var clusteredIndexField: String="";

     var sourceTableName:  String = "";
     var destinationTable: String = "";

     var isDailyTable:Boolean = false;

     def getSourceServer(): OfficeServer = {

          val sourceCredentials = Array(sourceUserName, sourcePassword);
          val sourceServer = new OfficeServer(sourceServerName, sourceDatabase, srcPort, sourceCredentials);
          sourceServer.getConnection();
          return sourceServer;
     }

     def getDestinationServer(): OfficeServer = {
          val destinationCredentials = Array(destinationUserName, destinationPassword);
          val  destinationServer = new OfficeServer(destinationServerName, destinationDatabase, destinationPort, destinationCredentials);
          destinationServer.getConnection();
          return destinationServer;
     }

     def getSourceTable(): OfficeTable = {
          return new  OfficeTable(sourceTableName,isDailyTable, copyScript);

     }
}






