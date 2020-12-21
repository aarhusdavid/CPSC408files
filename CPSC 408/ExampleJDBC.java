//STEP 1. Import required packages

import java.sql.*;

public class ExampleJDBC {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/cpsc408?serverTimezone=UTC";

   //  Database credentials
   static final String USER = "jdbcuser";
   static final String PASS = "jdbc";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String createTable = "CREATE TABLE Employee( "
        + "ID INT NOT NULL,"
        + "Name VARCHAR(255), "
        + "Age INT NOT NULL, "
        + "Job VARCHAR(255))";
        stmt.execute("Drop table Employee");
        boolean bool = stmt.execute(createTable);

      String insertData = "INSERT INTO Employee("
         + "ID, Name, Age, Job) VALUES "
         + "(1, 'Amit', 30, 'Sales Rep'), "
         + "(2, 'Kalyan', 40, 'Customer Service Rep'), "
         + "(3, 'Tom', 35, 'Sales Rep'), "
         + "(4, 'Bob', 50, 'Sales Rep'), "
         + "(5, 'Mary', 45, 'Customer Service Rep'), "
         + "(6, 'Jess', 34, 'Sales Rep'), "
         + "(7, 'Jim', 54, 'Customer Service Rep'), "
         + "(8, 'Jessica', 43, 'Customer Service Rep'), "
         + "(9, 'Rich', 32, 'Manager'), "
         + "(10, 'Archana', 45, 'Owner')";

      int i = stmt.executeUpdate(insertData);
      System.out.println("Rows inserted: "+i);
      System.out.println("");

      //Retrieving data
      System.out.println("First Query: Select All Employees");
      ResultSet rs = stmt.executeQuery("Select * from Employee");
      while(rs.next()) {
         System.out.print("ID: "+rs.getString("ID")+", ");
         System.out.print("Name: "+rs.getString("Name")+", ");
         System.out.print("Age: "+rs.getInt("Age")+", ");
         System.out.print("Job: "+rs.getString("Job"));
         System.out.println();
      }
      System.out.println("");

    // Update PreparedStatement
    System.out.println("Update: Change Employee 1's Name from Amit to David");
    String sql = "update Employee set Name=? where Name=?";
    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    preparedStatement.setString(1, "David");
    preparedStatement.setString(2, "Amit");
    int rowsAffected = preparedStatement.executeUpdate();
    System.out.println("Update Complete!");
    System.out.println("");

    // Query PreparedStatement
    System.out.println("Query 2: Select All Employees who are Sales Reps and are over 30 yrs old");
    sql = "select * from Employee where job=? and age > ?";
    PreparedStatement qpreparedStatement = conn.prepareStatement(sql);
    qpreparedStatement.setString(1,"Sales Rep");
    qpreparedStatement.setLong(2,30);
    ResultSet result = qpreparedStatement.executeQuery();

    while(result.next()) {
       System.out.print("ID: "+result.getString("ID")+", ");
       System.out.print("Name: "+result.getString("Name")+", ");
       System.out.print("Age: "+result.getInt("Age")+", ");
       System.out.print("Job: "+result.getString("Job"));
       System.out.println();
    }
    System.out.println("Query Complete!");
    System.out.println("");

    // Deletion PreparedStatement
    System.out.println("Deletion: Delete the employee whose name is Tom");
    sql = "Delete from Employee where name=?";
    PreparedStatement dpreparedStatement = conn.prepareStatement(sql);
    dpreparedStatement.setString(1, "Tom");
    int deleteRow = dpreparedStatement.executeUpdate();
    System.out.println("Deletion Complete!");
    System.out.println("");

    System.out.println("Print of Existing Employees");
    rs = stmt.executeQuery("Select * from Employee");
    while(rs.next()) {
       System.out.print("ID: "+rs.getString("ID")+", ");
       System.out.print("Name: "+rs.getString("Name")+", ");
       System.out.print("Age: "+rs.getInt("Age")+", ");
       System.out.print("Job: "+rs.getString("Job"));
       System.out.println();
    }
    System.out.println("");

      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample
