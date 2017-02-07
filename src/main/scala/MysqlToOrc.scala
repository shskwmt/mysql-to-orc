import java.sql.{Array => SqlArray, _}
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql._
import org.apache.spark.sql.hive._

object MysqlToOrc {
  def main(args: Array[String]) {

    // MySQLからデータ取得し、ORCへ変換
    val conf = new SparkConf().setAppName("MySQL to ORC").setMaster("local[2]").set("spark.executor.memory","3g");
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val options = Map(
      "url" -> "jdbc:mysql://127.0.0.1:3306/spark_demo",
      "user" -> "root",
      "password" -> "",
      "dbtable" -> "customers"
    )
    val customersDF = sqlContext.read.format("jdbc").options(options).load()
    customersDF.registerTempTable("customers")
    customersDF.write.format("orc").save("customers")
  }
}