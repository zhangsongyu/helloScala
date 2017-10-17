package com.database.slick.table.example

import com.database.entity.Tables
import com.database.entity.Tables._
import slick.jdbc.MySQLProfile.api._


object FirstExample extends App{
  val suppliers = TableQuery[Suppliers]
  val coffees = TableQuery[Coffees]

  val db = Database.forConfig("dbmysql")



  //#create
  val setup = DBIO.seq(
    // Create the tables, including primary and foreign keys
    (suppliers.schema ++ coffees.schema).create,

    // Insert some suppliers
    suppliers += com.database.entity.Tables.SuppliersRow(101, Some("Acme, Inc."),Some( "99 Market Street"),Some( "Groundsville"), Some("CA"),Some("95199")),
/*
    suppliers += (101, "Acme, Inc.",      "99 Market Street", "Groundsville", "CA", "95199"),
    suppliers += ( 49, "Superior Coffee", "1 Party Place",    "Mendocino",    "CA", "95460"),
    suppliers += (150, "The High Ground", "100 Coffee Lane",  "Meadows",      "CA", "93966"),*/
    // Equivalent SQL code:
    // insert into SUPPLIERS(SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP) values (?,?,?,?,?,?)

    // Insert some coffees (using JDBC's batch insert feature, if supported by the DB)
    coffees ++= Seq(
/*      ("Colombian",         101, 7.99, 0, 0),
      ("French_Roast",       49, 8.99, 0, 0),
      ("Espresso",          150, 9.99, 0, 0),
      ("Colombian_Decaf",   101, 8.99, 0, 0),
      ("French_Roast_Decaf", 49, 9.99, 0, 0)*/
      CoffeesRow(Some("hahaCaffee"),Some(101),Some(7.77),Some(0),Some(0))
    )
    // Equivalent SQL code:
    // insert into COFFEES(COF_NAME, SUP_ID, PRICE, SALES, TOTAL) values (?,?,?,?,?)
  )

  val setupFuture = db.run(setup.asTry)


    // Equivalent SQL code:
    // select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES
    //#readall



}
