import org.apache.spark.SparkContext;
import org.apache.spark.SparkContext._;
import org.apache.spark.SparkConf;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
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

import org.bson.Document
import org.bson.types.ObjectId
import com.mongodb.spark.config.ReadConfig
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import java.util.Map;
import com.mongodb.spark.MongoSpark;
import org.apache.spark.rdd.RDD;


class ApacheSparkCoordinator (val appName:String,  val script:String, val partitions:Int,sourceConnection:Connection, destinationConnection:Connection){

  def runSparkRequest(): Unit ={


  }
}
