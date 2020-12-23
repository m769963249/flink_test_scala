package org.example

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.streaming.api.scala._


object BatchJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val source = env.fromElements("java spark flink python hive java spark flink")
    val value = source.flatMap(_.split(" ")).map((_, 1)).groupBy(0).sum(1)
    value.print()

  }
}
