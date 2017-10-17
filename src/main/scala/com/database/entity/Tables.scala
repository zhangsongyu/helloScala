package com.database.entity

// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Coffees.schema ++ Quotes.schema ++ Suppliers.schema ++ User.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Coffees
   *  @param cofName Database column COF_NAME SqlType(VARCHAR), Length(0,true), Default(None)
   *  @param supId Database column SUP_ID SqlType(INT), Default(None)
   *  @param price Database column PRICE SqlType(DOUBLE), Default(None)
   *  @param sales Database column SALES SqlType(INT), Default(None)
   *  @param total Database column TOTAL SqlType(INT), Default(None) */
  case class CoffeesRow(cofName: Option[String] = None, supId: Option[Int] = None, price: Option[Double] = None, sales: Option[Int] = None, total: Option[Int] = None)
  /** GetResult implicit for fetching CoffeesRow objects using plain SQL queries */
  implicit def GetResultCoffeesRow(implicit e0: GR[Option[String]], e1: GR[Option[Int]], e2: GR[Option[Double]]): GR[CoffeesRow] = GR{
    prs => import prs._
    CoffeesRow.tupled((<<?[String], <<?[Int], <<?[Double], <<?[Int], <<?[Int]))
  }
  /** Table description of table COFFEES. Objects of this class serve as prototypes for rows in queries. */
  class Coffees(_tableTag: Tag) extends Table[CoffeesRow](_tableTag, "COFFEES") {
    def * = (cofName, supId, price, sales, total) <> (CoffeesRow.tupled, CoffeesRow.unapply)

    /** Database column COF_NAME SqlType(VARCHAR), Length(0,true), Default(None) */
    val cofName: Rep[Option[String]] = column[Option[String]]("COF_NAME", O.Length(0,varying=true), O.Default(None))
    /** Database column SUP_ID SqlType(INT), Default(None) */
    val supId: Rep[Option[Int]] = column[Option[Int]]("SUP_ID", O.Default(None))
    /** Database column PRICE SqlType(DOUBLE), Default(None) */
    val price: Rep[Option[Double]] = column[Option[Double]]("PRICE", O.Default(None))
    /** Database column SALES SqlType(INT), Default(None) */
    val sales: Rep[Option[Int]] = column[Option[Int]]("SALES", O.Default(None))
    /** Database column TOTAL SqlType(INT), Default(None) */
    val total: Rep[Option[Int]] = column[Option[Int]]("TOTAL", O.Default(None))

    /** Foreign key referencing Suppliers (database name SUP_FK) */
    lazy val suppliersFk = foreignKey("SUP_FK", supId, Suppliers)(r => Rep.Some(r.supId), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Coffees */
  lazy val Coffees = new TableQuery(tag => new Coffees(tag))

  /** Entity class storing rows of table Quotes
   *  @param quote Database column quote SqlType(VARCHAR), Length(128,true)
   *  @param author Database column author SqlType(VARBINARY), Default(None)
   *  @param age Database column age SqlType(INT), Default(None) */
  case class QuotesRow(quote: String, author: Option[java.sql.Blob] = None, age: Option[Int] = None)
  /** GetResult implicit for fetching QuotesRow objects using plain SQL queries */
  implicit def GetResultQuotesRow(implicit e0: GR[String], e1: GR[Option[java.sql.Blob]], e2: GR[Option[Int]]): GR[QuotesRow] = GR{
    prs => import prs._
    QuotesRow.tupled((<<[String], <<?[java.sql.Blob], <<?[Int]))
  }
  /** Table description of table quotes. Objects of this class serve as prototypes for rows in queries. */
  class Quotes(_tableTag: Tag) extends Table[QuotesRow](_tableTag, "quotes") {
    def * = (quote, author, age) <> (QuotesRow.tupled, QuotesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(quote), author, age).shaped.<>({r=>import r._; _1.map(_=> QuotesRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column quote SqlType(VARCHAR), Length(128,true) */
    val quote: Rep[String] = column[String]("quote", O.Length(128,varying=true))
    /** Database column author SqlType(VARBINARY), Default(None) */
    val author: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("author", O.Default(None))
    /** Database column age SqlType(INT), Default(None) */
    val age: Rep[Option[Int]] = column[Option[Int]]("age", O.Default(None))
  }
  /** Collection-like TableQuery object for table Quotes */
  lazy val Quotes = new TableQuery(tag => new Quotes(tag))

  /** Entity class storing rows of table Suppliers
   *  @param supId Database column SUP_ID SqlType(INT), PrimaryKey, Default(0)
   *  @param supName Database column SUP_NAME SqlType(VARCHAR), Length(0,true), Default(None)
   *  @param street Database column STREET SqlType(VARCHAR), Length(0,true), Default(None)
   *  @param city Database column CITY SqlType(VARCHAR), Length(0,true), Default(None)
   *  @param state Database column STATE SqlType(VARCHAR), Length(0,true), Default(None)
   *  @param zip Database column ZIP SqlType(VARCHAR), Length(0,true), Default(None) */
  case class SuppliersRow(supId: Int = 0, supName: Option[String] = None, street: Option[String] = None, city: Option[String] = None, state: Option[String] = None, zip: Option[String] = None)
  /** GetResult implicit for fetching SuppliersRow objects using plain SQL queries */
  implicit def GetResultSuppliersRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[SuppliersRow] = GR{
    prs => import prs._
    SuppliersRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table SUPPLIERS. Objects of this class serve as prototypes for rows in queries. */
  class Suppliers(_tableTag: Tag) extends Table[SuppliersRow](_tableTag, "SUPPLIERS") {
    def * = (supId, supName, street, city, state, zip) <> (SuppliersRow.tupled, SuppliersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(supId), supName, street, city, state, zip).shaped.<>({r=>import r._; _1.map(_=> SuppliersRow.tupled((_1.get, _2, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SUP_ID SqlType(INT), PrimaryKey, Default(0) */
    val supId: Rep[Int] = column[Int]("SUP_ID", O.PrimaryKey, O.Default(0))
    /** Database column SUP_NAME SqlType(VARCHAR), Length(0,true), Default(None) */
    val supName: Rep[Option[String]] = column[Option[String]]("SUP_NAME", O.Length(0,varying=true), O.Default(None))
    /** Database column STREET SqlType(VARCHAR), Length(0,true), Default(None) */
    val street: Rep[Option[String]] = column[Option[String]]("STREET", O.Length(0,varying=true), O.Default(None))
    /** Database column CITY SqlType(VARCHAR), Length(0,true), Default(None) */
    val city: Rep[Option[String]] = column[Option[String]]("CITY", O.Length(0,varying=true), O.Default(None))
    /** Database column STATE SqlType(VARCHAR), Length(0,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("STATE", O.Length(0,varying=true), O.Default(None))
    /** Database column ZIP SqlType(VARCHAR), Length(0,true), Default(None) */
    val zip: Rep[Option[String]] = column[Option[String]]("ZIP", O.Length(0,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Suppliers */
  lazy val Suppliers = new TableQuery(tag => new Suppliers(tag))

  /** Entity class storing rows of table User
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(256,true), Default(None)
   *  @param role Database column role SqlType(VARCHAR), Length(256,true), Default(None) */
  case class UserRow(id: Int, name: Option[String] = None, role: Option[String] = None)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends Table[UserRow](_tableTag, "user") {
    def * = (id, name, role) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, role).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(256,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(256,varying=true), O.Default(None))
    /** Database column role SqlType(VARCHAR), Length(256,true), Default(None) */
    val role: Rep[Option[String]] = column[Option[String]]("role", O.Length(256,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
