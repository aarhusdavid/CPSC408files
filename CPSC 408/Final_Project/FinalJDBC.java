import java.sql.*;
import java.util.Scanner;  // takes user input


public class FinalJDBC {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/cpsc408_2291228?serverTimezone=UTC";

   //  Database credentials
   static final String USER = "MySql";
   static final String PASS = "Superbowl22";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
    //STEP 2: Register JDBC driver
    Class.forName(JDBC_DRIVER);

    //STEP 3: Open a connection
    System.out.println("Connecting to database...");
    conn = DriverManager.getConnection(DB_URL,USER,PASS);

    // user input object
    Scanner menuObj = new Scanner(System.in);

    // initial id #'s for each table after data.sql file is imported'
    int curemployeeid = 1000000;
    int curpbid = 1000000;
    int curdepartid = 1000000;
    int curcontactid = 1000000;
    int curhrid = 1000000;
    int curbgid = 1000000;
    int curpayid = 1000000;


    while(true)
    {
        // database menu
        System.out.println();
        System.out.println("Hello, Welcome to the Employee Database");
        System.out.println();
        System.out.println("1) Insert new data");
        System.out.println("2) Delete old data");
        System.out.println("3) Update The Address of an Employee");
        System.out.println("4) Select address of all employees ");
        System.out.println("5) Select the Sales Reps who make more than $50,000 a year");
        System.out.println("6) Print the average absences for each Jobtitle in the Database");
        System.out.println("7) Select the First and Last name of the employees who make over $80,000 a year");
        System.out.println("8) Print the sum overtimeHours for each Jobtitle in the Database");
        System.out.println("9) Print the count of employees who are from CA and WA");
        System.out.println("10) Print the count of employees who went to each school");
        System.out.println("11) Exit the program");
        System.out.println();
        stmt = conn.createStatement();
        System.out.println("Enter the number of your choice: ");
        int userChoice = menuObj.nextInt();  // Read user input
        System.out.println();

        if (userChoice == 1)
        {
            curemployeeid++; // increments id num before inputed
            System.out.println("1) Employees");
            System.out.println("2) Phonebook");
            System.out.println("3) Department");
            System.out.println("4) Contact");
            System.out.println("5) HumanResources");
            System.out.println("6) Background");
            System.out.println("7) Payment");
            System.out.println();
            System.out.println("Enter the number of the table above that would you like to insert into");
            Scanner insertObj = new Scanner(System.in);
            int insertChoice = insertObj.nextInt();  // Read user input
            System.out.println();

            if (insertChoice == 1) // inserts into employees table
            {
                Scanner empObj = new Scanner(System.in); // asks users for attributes
                System.out.println("New Employee ID is " + curemployeeid);
                System.out.println("Enter the employees address:");
                String addy = empObj.nextLine();
                System.out.println("Enter the employees age:");
                int age = empObj.nextInt();
                System.out.println("Enter the employees years exp:");
                int exp = empObj.nextInt();
                System.out.println("Enter the employees starting year:");
                int startyear = empObj.nextInt();
                empObj.nextLine();
                System.out.println("Enter the employees gender:");
                String gend = empObj.nextLine();
                System.out.println("Enter the employees email:");
                String email = empObj.nextLine();
                System.out.println("Enter the employees birthmonth:");
                String bithm = empObj.nextLine();
                System.out.println("Enter the employees MaritalStatus:");
                String relationstatus = empObj.nextLine();
                System.out.println("Enter the employees Ethnicity:");
                String ethnic = empObj.nextLine();


                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String employeesql = "INSERT INTO Employees values(";
                employeesql = (employeesql + curemployeeid + ',' + "'" +  addy + "'" + ','
                                   + age + ','
                                   + exp + ','
                                   + startyear + ','
                                   + "'" + gend + "'" + ','
                                   + "'" + email + "'" + ','
                                   + "'" + bithm + "'" + ','
                                   + "'" + relationstatus + "'" + ','
                                   + "'" + ethnic + "'" + ");");
                stmt.executeUpdate(employeesql);


            }
            else if (insertChoice == 2)
            {
                System.out.println("In order to insert into the Phonebook table you will have to insert a new employee");

                Scanner empObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the employees address:");
                String addy = empObj.nextLine();
                System.out.println("Enter the employees age:");
                int age = empObj.nextInt();
                System.out.println("Enter the employees years exp:");
                int exp = empObj.nextInt();
                System.out.println("Enter the employees starting year:");
                int startyear = empObj.nextInt();
                empObj.nextLine();
                System.out.println("Enter the employees gender:");
                String gend = empObj.nextLine();
                System.out.println("Enter the employees email:");
                String email = empObj.nextLine();
                System.out.println("Enter the employees birthmonth:");
                String bithm = empObj.nextLine();
                System.out.println("Enter the employees MaritalStatus:");
                String relationstatus = empObj.nextLine();
                System.out.println("Enter the employees Ethnicity:");
                String ethnic = empObj.nextLine();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String employeesql = "INSERT INTO Employees values(";
                employeesql = (employeesql + curemployeeid + ',' + "'" +  addy + "'" + ','
                                   + age + ','
                                   + exp + ','
                                   + startyear + ','
                                   + "'" + gend + "'" + ','
                                   + "'" + email + "'" + ','
                                   + "'" + bithm + "'" + ','
                                   + "'" + relationstatus + "'" + ','
                                   + "'" + ethnic + "'" + ");");
                stmt.executeUpdate(employeesql);

                curpbid++;
                Scanner phoneObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the phone:");
                String phone = phoneObj.nextLine();  // Read user input
                System.out.println("Enter the emergency phone:");
                String ephone = phoneObj.nextLine();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String phonebooksql = "INSERT INTO Phonebook values(";
                phonebooksql = (phonebooksql + curemployeeid + ',' + "'" +  phone + "'" + ','
                                    + "'" + ephone + "'" +
                ");");
                stmt.executeUpdate(phonebooksql);

            }
            else if (insertChoice == 3)
            {
                System.out.println("In order to insert into the Department table you will have to insert a new employee");

                Scanner empObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the employees address:");
                String addy = empObj.nextLine();
                System.out.println("Enter the employees age:");
                int age = empObj.nextInt();
                System.out.println("Enter the employees years exp:");
                int exp = empObj.nextInt();
                System.out.println("Enter the employees starting year:");
                int startyear = empObj.nextInt();
                empObj.nextLine();
                System.out.println("Enter the employees gender:");
                String gend = empObj.nextLine();
                System.out.println("Enter the employees email:");
                String email = empObj.nextLine();
                System.out.println("Enter the employees birthmonth:");
                String bithm = empObj.nextLine();
                System.out.println("Enter the employees MaritalStatus:");
                String relationstatus = empObj.nextLine();
                System.out.println("Enter the employees Ethnicity:");
                String ethnic = empObj.nextLine();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String employeesql = "INSERT INTO Employees values(";
                employeesql = (employeesql + curemployeeid + ',' + "'" +  addy + "'" + ','
                                   + age + ','
                                   + exp + ','
                                   + startyear + ','
                                   + "'" + gend + "'" + ','
                                   + "'" + email + "'" + ','
                                   + "'" + bithm + "'" + ','
                                   + "'" + relationstatus + "'" + ','
                                   + "'" + ethnic + "'" + ");");
                stmt.executeUpdate(employeesql);

                curdepartid++;
                Scanner departObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the JobTitle:");
                String jbtitle = departObj.nextLine();  // Read user input
                System.out.println("Enter the Department:");
                String depart = departObj.nextLine();
                System.out.println("Enter the Income:");
                int income = departObj.nextInt();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String departmentsql = "INSERT INTO Department values(";
                departmentsql = (departmentsql + curemployeeid + ',' + "'" +  jbtitle + "'" + ','
                                    + "'" + depart + "'" + ',' + income +
                ");");
                stmt.executeUpdate(departmentsql);

            }
            else if (insertChoice == 4)
            {
                System.out.println("In order to insert into the Contact table you will have to insert a new employee");

                Scanner empObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the employees address:");
                String addy = empObj.nextLine();
                System.out.println("Enter the employees age:");
                int age = empObj.nextInt();
                System.out.println("Enter the employees years exp:");
                int exp = empObj.nextInt();
                System.out.println("Enter the employees starting year:");
                int startyear = empObj.nextInt();
                empObj.nextLine();
                System.out.println("Enter the employees gender:");
                String gend = empObj.nextLine();
                System.out.println("Enter the employees email:");
                String email = empObj.nextLine();
                System.out.println("Enter the employees birthmonth:");
                String bithm = empObj.nextLine();
                System.out.println("Enter the employees MaritalStatus:");
                String relationstatus = empObj.nextLine();
                System.out.println("Enter the employees Ethnicity:");
                String ethnic = empObj.nextLine();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String employeesql = "INSERT INTO Employees values(";
                employeesql = (employeesql + curemployeeid + ',' + "'" +  addy + "'" + ','
                                   + age + ','
                                   + exp + ','
                                   + startyear + ','
                                   + "'" + gend + "'" + ','
                                   + "'" + email + "'" + ','
                                   + "'" + bithm + "'" + ','
                                   + "'" + relationstatus + "'" + ','
                                   + "'" + ethnic + "'" + ");");
                stmt.executeUpdate(employeesql);

                curcontactid++;
                Scanner contactObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the Firstname:");
                String fname = contactObj.nextLine();  // Read user input
                System.out.println("Enter the Lastname:");
                String lname = contactObj.nextLine();
                System.out.println("Enter the Emergency Contact:");
                String econtact = contactObj.nextLine();  // Read user input
                System.out.println("Enter the Emergency Contact Relation:");
                String erelation = contactObj.nextLine();

                // user has to input employee info as well in order to complete the insert for contact

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String contactsql = "INSERT INTO Contact values(";
                contactsql = (contactsql + curemployeeid + ',' + "'" +  fname + "'" + ','
                                    + "'" + lname + "'" + ',' + "'" +  econtact + "'" + ',' + "'" +  erelation + "'" +
                ");");
                stmt.executeUpdate(contactsql);

            }
            else if (insertChoice == 5)
            {
                System.out.println("In order to insert into the HumanResources table you will have to insert a new employee");

                Scanner empObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the employees address:");
                String addy = empObj.nextLine();
                System.out.println("Enter the employees age:");
                int age = empObj.nextInt();
                System.out.println("Enter the employees years exp:");
                int exp = empObj.nextInt();
                System.out.println("Enter the employees starting year:");
                int startyear = empObj.nextInt();
                empObj.nextLine();
                System.out.println("Enter the employees gender:");
                String gend = empObj.nextLine();
                System.out.println("Enter the employees email:");
                String email = empObj.nextLine();
                System.out.println("Enter the employees birthmonth:");
                String bithm = empObj.nextLine();
                System.out.println("Enter the employees MaritalStatus:");
                String relationstatus = empObj.nextLine();
                System.out.println("Enter the employees Ethnicity:");
                String ethnic = empObj.nextLine();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String employeesql = "INSERT INTO Employees values(";
                employeesql = (employeesql + curemployeeid + ',' + "'" +  addy + "'" + ','
                                   + age + ','
                                   + exp + ','
                                   + startyear + ','
                                   + "'" + gend + "'" + ','
                                   + "'" + email + "'" + ','
                                   + "'" + bithm + "'" + ','
                                   + "'" + relationstatus + "'" + ','
                                   + "'" + ethnic + "'" + ");");
                stmt.executeUpdate(employeesql);

                curhrid++;
                Scanner hrObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the Complaint:");
                String complaint = hrObj.nextLine();  // Read user input
                System.out.println("Enter the Date of the Complaint:");
                String compdate = hrObj.nextLine();
                System.out.println("Enter the Time of the Complaint:");
                String comptime = hrObj.nextLine();  // Read user input

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String hrsql = "INSERT INTO HumanResources values(";
                hrsql = (hrsql + curemployeeid + ',' + "'" +  complaint + "'" + ','
                                    + "'" + compdate + "'" + ',' + "'" +  comptime + "'" +
                ");");
                stmt.executeUpdate(hrsql);

            }
            else if (insertChoice == 6)
            {

                System.out.println("In order to insert into the Background table you will have to insert a new employee");

                Scanner empObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the employees address:");
                String addy = empObj.nextLine();
                System.out.println("Enter the employees age:");
                int age = empObj.nextInt();
                System.out.println("Enter the employees years exp:");
                int exp = empObj.nextInt();
                System.out.println("Enter the employees starting year:");
                int startyear = empObj.nextInt();
                empObj.nextLine();
                System.out.println("Enter the employees gender:");
                String gend = empObj.nextLine();
                System.out.println("Enter the employees email:");
                String email = empObj.nextLine();
                System.out.println("Enter the employees birthmonth:");
                String bithm = empObj.nextLine();
                System.out.println("Enter the employees MaritalStatus:");
                String relationstatus = empObj.nextLine();
                System.out.println("Enter the employees Ethnicity:");
                String ethnic = empObj.nextLine();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String employeesql = "INSERT INTO Employees values(";
                employeesql = (employeesql + curemployeeid + ',' + "'" +  addy + "'" + ','
                                   + age + ','
                                   + exp + ','
                                   + startyear + ','
                                   + "'" + gend + "'" + ','
                                   + "'" + email + "'" + ','
                                   + "'" + bithm + "'" + ','
                                   + "'" + relationstatus + "'" + ','
                                   + "'" + ethnic + "'" + ");");
                stmt.executeUpdate(employeesql);

                curbgid++;
                Scanner bgObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the Hometown:");
                String home = bgObj.nextLine();  // Read user input
                System.out.println("Enter the HomeState:");
                String homestate = bgObj.nextLine();
                System.out.println("Enter the School:");
                String school = bgObj.nextLine();  // Read user input
                System.out.println("Enter the level of education earned:");
                String educat = bgObj.nextLine();  // Read user input

                stmt = conn.createStatement();
                String bgsql = "INSERT INTO Background values("; // translates user inputes into SQL statement
                bgsql = (bgsql + curemployeeid + ',' + "'" +  home + "'" + ','
                                    + "'" + homestate + "'" + ',' + "'" +  school + "'" + ',' + "'" + educat + "'" +
                ");");
                stmt.executeUpdate(bgsql);
            }
            else if (insertChoice == 7)
            {

                System.out.println("In order to insert into the Payment table you will have to insert a new employee");

                Scanner empObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the employees address:");
                String addy = empObj.nextLine();
                System.out.println("Enter the employees age:");
                int age = empObj.nextInt();
                System.out.println("Enter the employees years exp:");
                int exp = empObj.nextInt();
                System.out.println("Enter the employees starting year:");
                int startyear = empObj.nextInt();
                empObj.nextLine();
                System.out.println("Enter the employees gender:");
                String gend = empObj.nextLine();
                System.out.println("Enter the employees email:");
                String email = empObj.nextLine();
                System.out.println("Enter the employees birthmonth:");
                String bithm = empObj.nextLine();
                System.out.println("Enter the employees MaritalStatus:");
                String relationstatus = empObj.nextLine();
                System.out.println("Enter the employees Ethnicity:");
                String ethnic = empObj.nextLine();

                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String employeesql = "INSERT INTO Employees values(";
                employeesql = (employeesql + curemployeeid + ',' + "'" +  addy + "'" + ','
                                   + age + ','
                                   + exp + ','
                                   + startyear + ','
                                   + "'" + gend + "'" + ','
                                   + "'" + email + "'" + ','
                                   + "'" + bithm + "'" + ','
                                   + "'" + relationstatus + "'" + ','
                                   + "'" + ethnic + "'" + ");");
                stmt.executeUpdate(employeesql);

                curpayid++;
                Scanner payObj = new Scanner(System.in); // asks users for attributes
                System.out.println("Enter the PayRate:");
                String rate = payObj.nextLine();  // Read user input
                System.out.println("Enter the PayType:");
                String type = payObj.nextLine();
                System.out.println("Enter amount of absences:");
                String absenc = payObj.nextLine();  // Read user input
                System.out.println("Enter Overtime hours:");
                String othr = payObj.nextLine();  // Read user input

                stmt = conn.createStatement();
                String paysql = "INSERT INTO Payment values("; // translates user inputes into SQL statement
                paysql = (paysql + curemployeeid + ',' + "'" +  rate + "'" + ','
                                    + "'" + type + "'" + ',' + "'" +  absenc + "'" + ',' + "'" + othr + "'" +
                ");");
                stmt.executeUpdate(paysql);
            }

        }
        else if (userChoice == 2)
        {
            System.out.println("What is the employeeid of the employee you want to delete?");
            Scanner deleteObj = new Scanner(System.in);
            int id = deleteObj.nextInt();  // Read user input
            System.out.println("What table would you like to delete information from?");
            System.out.println();
            System.out.println("1) Employees");
            System.out.println("2) Phonebook");
            System.out.println("3) Department");
            System.out.println("4) Contact");
            System.out.println("5) HumanResources");
            System.out.println("6) Background");
            System.out.println("7) Payment");
            System.out.println();
            int table = deleteObj.nextInt();  // Read user input

            if (table == 1) // can only delete foreign keys right now
            {
                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String delete = "DELETE FROM Employees where EmployeeID = " + id + ";";
                String deletepb = "DELETE FROM Phonebook where EmployeeIDPB = " + id + ";";
                String deletedepart = "DELETE FROM Department where EmployeeIDDepart = " + id + ";";
                String deletecon = "DELETE FROM Contact where EmployeeIDContact = " + id + ";";
                String deletehr = "DELETE FROM HumanResources where EmployeeIDHR = " + id + ";";
                String deletebg = "DELETE FROM Background where EmployeeIDBG = " + id + ";";
                String deletepay = "DELETE FROM Payment where EmployeeIDPay = " + id + ";";

                stmt.executeUpdate(deletepb);
                stmt.executeUpdate(deletedepart);
                stmt.executeUpdate(deletecon);
                stmt.executeUpdate(deletehr);
                stmt.executeUpdate(deletebg);
                stmt.executeUpdate(deletepay);
                stmt.executeUpdate(delete);

            }
            else if (table == 2)
            {
                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String delete = "DELETE FROM Phonebook where EmployeeIDPB = " + id + ";";
                stmt.executeUpdate(delete);
            }
            else if (table == 3)
            {
                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String delete = "DELETE FROM Department where EmployeeIDDepart = " + id + ";";
                stmt.executeUpdate(delete);
            }
            else if (table == 4)
            {
                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String delete = "DELETE FROM Contact where EmployeeIDContact = " + id + ";";
                stmt.executeUpdate(delete);
            }
            else if (table == 5)
            {
                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String delete = "DELETE FROM HumanResources where EmployeeIDHR = " + id + ";";
                stmt.executeUpdate(delete);
            }
            else if (table == 6)
            {
                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String delete = "DELETE FROM Background where EmployeeIDBG = " + id + ";";
                stmt.executeUpdate(delete);
            }
            else if (table == 7)
            {
                stmt = conn.createStatement(); // translates user inputes into SQL statement
                String delete = "DELETE FROM Payment where EmployeeIDPay = " + id + ";";
                stmt.executeUpdate(delete);
            }

        }
        else if (userChoice == 3)
        {
            Scanner updateObj = new Scanner(System.in);
            System.out.println("What is the id of the employee you would like to change the address of?");
            int updateEmp = updateObj.nextInt();  // Read user input
            updateObj.nextLine();
            System.out.println("What is the new address: ");
            String updateaddy = updateObj.nextLine();  // Read user input

            stmt = conn.createStatement(); // translates user inputes into SQL statement
            String update = "UPDATE Employees SET Address = " + "'" + updateaddy + "'" + " where EmployeeID = " + updateEmp + ";";
            stmt.executeUpdate(update);

        }
        else if (userChoice == 4)
        {
            ResultSet rs = stmt.executeQuery("Select address from Employees");
            while(rs.next()) {
               System.out.println(rs.getString("Address"));
            }
            System.out.println("");
            rs.close();

        }
        else if (userChoice == 5)
        {
            ResultSet rs = stmt.executeQuery("SELECT employeeid,jobtitle,income FROM employees,department WHERE employees.employeeid = department.employeeiddepart and jobtitle = 'Sales Rep' and Income > 50000");
            while(rs.next()) {
               System.out.println(rs.getString("EmployeeID") + " " + rs.getString("JobTitle") + " " + rs.getInt("Income"));
            }
            System.out.println("");
            rs.close();
        }
        else if (userChoice == 6)
        {
            ResultSet rs = stmt.executeQuery("SELECT JobTitle,avg(absences) FROM Payment,department WHERE Payment.EmployeeIDPay = department.employeeiddepart Group BY Jobtitle");
            while(rs.next()) {
               System.out.println(rs.getString("JobTitle") + " " + rs.getString("avg(absences)"));
            }
            System.out.println("");
            rs.close();
        }
        else if (userChoice == 7)
        {
            ResultSet rs = stmt.executeQuery("SELECT firstname,lastname FROM contact NATURAL JOIN department WHERE income > 80000 and contact.employeeidcontact = department.employeeiddepart");
            while(rs.next()) {
               System.out.println(rs.getString("firstname") + " " + rs.getString("lastname"));
            }
            System.out.println("");
            rs.close();
        }
        else if (userChoice == 8)
        {
            ResultSet rs = stmt.executeQuery("SELECT JobTitle,sum(Overtimehours) FROM Payment,department WHERE Payment.EmployeeIDPay = department.employeeiddepart Group BY Jobtitle");
            while(rs.next()) {
               System.out.println(rs.getString("JobTitle") + " " + rs.getString("sum(Overtimehours)"));
            }
            System.out.println("");
            rs.close();
        }
        else if (userChoice == 9)
        {
            ResultSet rs = stmt.executeQuery("SELECT count(employeeid) FROM Background,Employees WHERE Background.EmployeeIDBG = Employees.employeeid and background.HomeState = 'CA'||'WA' ");
            while(rs.next()) {
               System.out.println(rs.getInt("count(employeeid)"));
            }
            System.out.println("");
            rs.close();
        }
        else if (userChoice == 10)
        {
            ResultSet rs = stmt.executeQuery("SELECT count(EmployeeIDBG), School FROM Employees,Background WHERE employees.employeeid = background.employeeidbg GROUP BY school");
            while(rs.next()) {
               System.out.println(rs.getString("school")+ " " + rs.getInt("count(EmployeeIDBG)"));
            }
            System.out.println("");
            rs.close();
        }
        else if (userChoice == 11)
        {
            break;
        }

    }

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
