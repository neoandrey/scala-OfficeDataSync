import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.DriverManager;
import java.sql.{Connection, DriverManager, ResultSet};


class OfficeServer(serverId: String, database: String, port:Int, credentials: Array[String]) {

  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance;
  var serverPort :Int                 =   port;
  var serverDatabase: String          =  database;

  val serverName :String  = serverId;
  if((port == 0 || port.toString().isEmpty())){
     serverPort = 1433;
  }else {
    serverPort  = port;

  }

  if((serverDatabase == null || serverDatabase.isEmpty())){

    serverDatabase = "postilion_office";

  }

  val MSSQL_DRIVER :String            =   "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  val MSSQL_USERNAME  :String         =   credentials(0);
  val MSSQL_PWD :String	              =   credentials(1);
  val MSSQL_CONNECTION_URL :String    = "jdbc:sqlserver://"+serverId+":"+serverPort+"/"+serverDatabase+"?user=" + MSSQL_USERNAME + "&password=" + MSSQL_PWD;

   def getConnection():Connection = {

     val connection: Connection = DriverManager.getConnection(MSSQL_CONNECTION_URL);
      return connection;

   }


}
