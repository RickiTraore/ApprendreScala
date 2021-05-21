import org.apache.spark.sql._
import  org.apache.spark._


object SparkApp {

  def sessionSpark(): Unit = {

    System.setProperty("winutils", "C:\\Hadoop")
    val ss = SparkSession.builder()
      .master("local[*]")
      .appName("Ma_premiere_application")
      .getOrCreate()
    val rdd1 = ss.sparkContext.parallelize(Seq("Ma premiere appli Spark. Je suis TRAORE Oula Siriki"))
    rdd1.foreach(l => println(l))

    val df = ss.read
      .format("csv")
      .option("inferShema", "true")
      .option("header", "true")
      .option("delimiter", ";")
      .csv("F:\\Documents\\Cours_data\\HADOOP\\orders_csv.csv")
    df.show(10)
   // df.printSchema()
    //df.select("city").show()

    df.createOrReplaceTempView("orders")
    //df.createOrReplaceGlobalTempView("orders")
    //ss.sql("select * from orders where city = 'NEWTON' ").show()
    ss.sql("select * from orders where city = 'NEWTON' ").explain()
  }

  def main(args: Array[String]): Unit = {
    sessionSpark()

  }
}
