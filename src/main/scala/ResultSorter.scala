import java.sql.ResultSet;
import scala.collection.JavaConversions.mapAsJavaMap

import org.apache.spark.SparkContext;
import org.apache.spark.SparkContext._;
import org.apache.spark.SparkConf;
import com.microsoft.sq
@SerialVersionUID(114L)
class ResultSorter extends Function1[java.sql.ResultSet, Document]with  Serializable {
  var   resultDoc:Document=  new Document ();
  var   scalaMap:scala.collection.immutable.Map[String,Object] = scala.collection.immutable.Map[String,Object]();
  var   javaMap:java.util.Map[String,Object] = new java.util.HashMap[String,Object];

  def apply(row: ResultSet ):Document= {
    var rowData =  JdbcRDD.resultSetToObjectArray(row);
    var rowMap:scala.collection.immutable.Map[String,Object] = scala.collection.immutable.Map[String,Object]()
    val columnnumber = row.getMetaData().getColumnCount.toInt
    for (i <- 2 to columnnumber.toInt) {
      rowMap= rowMap ++ scala.collection.immutable.Map(row.getMetaData().getColumnName(i) ->rowData(i-1) );
    }
    scalaMap = rowMap;
    javaMap  =  resultsAsJavaMap(rowMap);
    var sparkDocument = new Document(javaMap)
    resultDoc = sparkDocument;
    return  sparkDocument;
  }lserver.jdbc.SQLServerDriver;
import java.sql.DriverManager;
import org.apache.spark.rdd.JdbcRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import java.sql.{Connection, DriverManager, ResultSet};
import com.mongodb.spark._;
import com.mongodb.spark.config._;
import org.bson.Document;
import org.apache.spark.sql.{SQLContext, SparkSession}


  def resultsAsJavaMap(resMap:scala.collection.immutable.Map[String,Object] ): java.util.Map[String,Object] = {
    javaMap = mapAsJavaMap(resMap).asInstanceOf[java.util.Map[java.lang.String, java.lang.Object]];
    return javaMap;
  }
}
