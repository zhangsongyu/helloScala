package com.database.slick.table

import com.database.entity.Tables._
import slick.driver.MySQLDriver.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

// The main application
object HelloSlick extends App {
  val db = Database.forConfig("dbmysql")



  // the base query for the Users table
  val users = TableQuery[User]


  try {
    Await.result(db.run(DBIO.seq(
      // create the schema
//      users.schema.create,

      // insert two User instances
      users += UserRow(1111,Some("John Doe"),Some("admin")),
      users += UserRow(2222,Some("John Doe"),Some("admin")),

      // print the users (select * from USERS)
      users.result.map(println)
    )), Duration.Inf)
  } finally db.close


}
