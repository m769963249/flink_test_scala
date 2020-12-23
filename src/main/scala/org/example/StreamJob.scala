package org.example

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala._

object StreamJob{
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val source = env.socketTextStream("localhost", 9001)
    val value = source.flatMap(_.split(" ")).map(wc(_, 1)).keyBy(_.word).sum("count")
    value.print()
    env.execute("start word count")
  }
  case class wc(word:String,count:Long)
}