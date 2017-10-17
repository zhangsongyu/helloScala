package com.database.simpleJdbc

class JdbcDemo {

}
object J1{
  def main(args: Array[String]): Unit = {
    import java.sql.{Connection, DriverManager, ResultSet};
    // Change to Your Database Config
    val conn_str = "jdbc:mysql://104.224.158.43:3306/test?user=bwg&password=mysql"
    // Load the driver
    classOf[com.mysql.jdbc.Driver]
    // Setup the connection
    val conn = DriverManager.getConnection(conn_str)
    try {
      // Configure to be Read Only
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
      // Execute Query
      val rs = statement.executeQuery("SELECT quote FROM quotes LIMIT 100")
      // Iterate Over ResultSet
      while (rs.next) {
        println(rs.getString("quote"))
      }
    } catch{
      case e:Exception =>e.printStackTrace
    }
    finally {
      conn.close
    }
  }
}

object J2{
  def main(args: Array[String]): Unit = {
    import java.sql.{Connection, DriverManager, ResultSet};
    // Change to Your Database Config
    val conn_str = "jdbc:mysql://104.224.158.43:3306/test?user=bwg&password=mysql"
    // Load the driver
    classOf[com.mysql.jdbc.Driver]
    // Setup the connection
    val conn = DriverManager.getConnection(conn_str)
    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)

    // do database insert
    try {
      val prep = conn.prepareStatement("INSERT INTO quotes (quote, author) VALUES (?, ?) ")
      prep.setString(1, "Nothing great was ever achieved without enthusiasm.")
      prep.setString(2, "Ralph Waldo Emerson")
      prep.executeUpdate
    } catch{
      case e:Exception =>e.printStackTrace
    }
    finally {
      conn.close
    }
  }
}