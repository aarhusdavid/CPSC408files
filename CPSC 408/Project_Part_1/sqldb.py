import sqlite3

from sqlite3 import Error

def create_connection(db_file):
    """ create a database connection to a SQLite database """
    conn = None
    try:
        conn = sqlite3.connect(db_file)
        print(sqlite3.version)
    except Error as e:
        print(e)
    finally:
        if conn:
            conn.close()


if __name__ == '__main__':
    create_connection("/Users/DavidAarhus/Documents/sqlite/db/aarhus_schema.sql")


def create_connection(db_file):
    """ create a database connection to the SQLite database
        specified by db_file
    :param db_file: database file
    :return: Connection object or None
    """
    conn = None
    try:
        conn = sqlite3.connect(db_file)
    except Error as e:
        print(e)

    return conn


def create_table(conn, create_table_sql):
    """ create a table from the create_table_sql statement
    :param conn: Connection object
    :param create_table_sql: a CREATE TABLE statement
    :return:
    """
    try:
        c = conn.cursor()
        c.execute(create_table_sql)
    except Error as e:
        print(e)



def create_employee(conn, employee):
    """
    Create a new employee into the employees table
    :param conn:
    :param employee:
    :return: employeeid
    """
    sql = ''' INSERT INTO employees(employeeid,
                                    address,
                                    age,
                                    yearsexp,
                                    salary,
                                    startingyear,
                                    gender,
                                    email,
                                    dob,
                                    maritalstatus)
              VALUES(?,?,?,?,?,?,?,?,?,?) '''
    cur = conn.cursor()
    cur.execute(sql, employee)
    conn.commit()
    return cur.lastrowid



def create_phonebook(conn, phonebook):
    """
    Create a new phonebook
    :param conn:
    :param phonebook:
    :return:
    """

    sql = ''' INSERT INTO phonebook(employeeid,
                                    phone)
              VALUES(?,?) '''
    cur = conn.cursor()
    cur.execute(sql, phonebook)
    conn.commit()
    return cur.lastrowid


def create_department(conn, department):
    """
    Create a new department
    :param conn:
    :param department:
    :return:
    """

    sql = ''' INSERT INTO department(employeeid,
                                    jobtitle,
                                    department)
              VALUES(?,?,?) '''
    cur = conn.cursor()
    cur.execute(sql, department)
    conn.commit()
    return cur.lastrowid


def create_contact(conn, contact):
    """
    Create a new contact
    :param conn:
    :param contact:
    :return:
    """

    sql = ''' INSERT INTO contact(email,
                                firstname,
                                lastname)
              VALUES(?,?,?) '''
    cur = conn.cursor()
    cur.execute(sql, contact)
    conn.commit()
    return cur.lastrowid

def delete_employee(conn, id):
    """
    Delete a employee by employeeid
    :param conn:  Connection to the SQLite database
    :param id: id of the employee
    :return:
    """
    sql = 'DELETE FROM employees WHERE employeeid=?'
    cur = conn.cursor()
    cur.execute(sql, (id,))
    conn.commit()

def exit():
    conn.close()

def select_all_employees(conn):
    """
    Query employees by yearsexp
    :param conn: the Connection object
    :param
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT * FROM employees")

    rows = cur.fetchall()
    for row in rows:
        print(row)


def select_employee_by_yearsexp(conn, yearsexp):
    """
    Query employees by yearsexp
    :param conn: the Connection object
    :param yearsexp:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT * FROM employees WHERE yearsexp>?", (yearsexp,))

    rows = cur.fetchall()
    for row in rows:
        print(row)

def select_avgSalary_by_department(conn):
    """
    Query avg salary by department
    :param conn: the Connection object
    :param salary:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT department,avg(salary) FROM employees,department WHERE employees.employeeid = department.employeeid GROUP BY department")

    rows = cur.fetchall()

    for row in rows:
        print(row)

def select_employees_firstname_lastname_And_email(conn):
    """
    Query employees by firstname, lastname
    :param conn: the Connection object
    :param email:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT firstname,lastname,employees.email FROM employees,contact WHERE employees.email = contact.email")

    rows = cur.fetchall()

    for row in rows:
        print(row)

def select_employees_salary_greaterthan60000_andfirstandlastname(conn):
    """
    Query employees by salary, lastname
    :param conn: the Connection object
    :param salary, lastname:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT firstname,lastname FROM employees NATURAL JOIN contact WHERE salary > 60000")

    rows = cur.fetchall()

    for row in rows:
        print(row)

def select_salary_from_management(conn):
    """
    Query salarys by department
    :param conn: the Connection object
    :param salary, department:
    :return:
    """
    cur = conn.cursor()
    cur.execute("SELECT salary,department FROM employees NATURAL JOIN department WHERE department = 'Management' AND salary > 100000")

    rows = cur.fetchall()

    for row in rows:
        print(row)





def main():
    database = "aarhus_schema.sql"

    sql_create_employees_table = """ CREATE TABLE IF NOT EXISTS employees (
                                        employeeid integer PRIMARY KEY,
                                        address varchar(100),
                                        age integer,
                                        yearsexp integer,
                                        salary numeric,
                                        startingyear double,
                                        gender varchar varchar(1),
                                        email varchar(30),
                                        dob varchar(10),
                                        maritalstatus varchar(10)
                                    ); """

    sql_create_phonebook_table = """ CREATE TABLE IF NOT EXISTS phonebook (
                                        employeeid integer,
                                        phone numeric,
                                        FOREIGN KEY(employeeid) references employees(employeeid)
                                    ); """

    sql_create_department_table = """ CREATE TABLE IF NOT EXISTS department (
                                        employeeid integer,
                                        jobtitle text,
                                        department text,
                                        FOREIGN KEY (employeeid) references employees(employeeid)
                                    ); """


    sql_create_contact_table = """ CREATE TABLE IF NOT EXISTS contact (
                                        email varchar(30),
                                        firstname varchar(20),
                                        lastname varchar(20),
                                        FOREIGN KEY (email) references employees(email)
                                    ); """

    # create a database connection
    conn = create_connection(database)
    with conn:

        if conn is not None:
        # create projects table
            create_table(conn, sql_create_employees_table)
            create_table(conn, sql_create_phonebook_table)
            create_table(conn, sql_create_department_table)
            create_table(conn, sql_create_contact_table)


        # create tasks table
        #create_table(conn, sql_create_tasks_table)
        else:
            print("Error! cannot create the database connection.")


        # create employees

        employee = (1,'1122 N Chapman',22,1,50000,2019,'m','daarhus@gc.com','6/21/98','single');
        employee2 = (2,'3422 SE Circle',25,3,70000,2017,'m','asmith@gc.com','6/1/95','single');
        employee3 = (3,'1772 W Sway',28,6,80000,2014,'f','jbon@gc.com','7/21/92','married');
        employee4 = (4,'112 N Fox',31,7,75000,2013,'f','gfin@gc.com','8/2/89','married');
        employee5 = (5,'112287 Lane West',29,7,90000,2013,'m','tlone@gc.com','10/21/91','single');
        employee6 = (6,'112222 N man',42,10,100000,2010,'m','pwall@gc.com','7/11/78','married');
        employee7 = (7,'32 SE Key',29,6,36000,2014,'m','ljames@gc.com','8/24/98','single');
        employee8 = (8,'3434 E Sway',34,6,55000,2014,'f','bham@gc.com','5/23/98','married');
        employee9 = (9,'908 Chap Fox',33,2,67000,2018,'f','lhamilton@gc.com','5/25/98','married');
        employee10 = (10,'17 Lane Place',29,7,135000,2013,'m','mstone@gc.com','6/20/98','single');

        employee1 = create_employee(conn, employee)
        employee22 = create_employee(conn, employee2)
        employee33 = create_employee(conn, employee3)
        employee44 = create_employee(conn, employee4)
        employee55 = create_employee(conn, employee5)
        employee66 = create_employee(conn, employee6)
        employee77 = create_employee(conn, employee7)
        employee88 = create_employee(conn, employee8)
        employee99 = create_employee(conn, employee9)
        employee1010 = create_employee(conn, employee10)


        contact1 = ('daarhus@gc.com', 'David','Aarhus')
        contact2 = ('asmith@gc.com', 'Alex','Smith')
        contact3 = ('jbon@gc.com', 'Jesse','Bon')
        contact4 = ('gfin@gc.com', 'Gabby','Fin')
        contact5 = ('tlone@gc.com', 'Trevor','lone')
        contact6 = ('pwall@gc.com', 'Paul','Wall')
        contact7 = ('ljames@gc.com', 'Lebron','James')
        contact8 = ('bham@gc.com', 'Becky','Ham')
        contact9 = ('lhamilton@gc.com', 'Lilly','Hamilton')
        contact10 = ('mstone@gc.com', 'Mike','Stone')

        phonebook1 = (employee1, 3602163557)
        phonebook2 = (employee22, 2163456657)
        phonebook3 = (employee33, 3234567678)
        phonebook4 = (employee44, 3432123243)
        phonebook5 = (employee55, 1213435676)
        phonebook6 = (employee66, 3432536776)
        phonebook7 = (employee77, 2322322323)
        phonebook8 = (employee88, 8987876765)
        phonebook9 = (employee99, 2341112212)
        phonebook10 = (employee1010, 2324443343)

        department1 = (employee1,'sales rep','Sales')
        department2 = (employee22,'customer service rep','Customer Service')
        department3 = (employee33,'sales rep','Sales')
        department4 = (employee44,'accountant','Accounting')
        department5 = (employee55,'Sales Manager','Management')
        department6 = (employee66,'sales rep','Sales')
        department7 = (employee77,'sales rep','Sales')
        department8 = (employee88,'customer service rep','Customer Service')
        department9 = (employee99,'sales rep','Sales')
        department10 = (employee1010,'Owner','Management')

        create_phonebook(conn, phonebook1)
        create_phonebook(conn, phonebook2)
        create_phonebook(conn, phonebook3)
        create_phonebook(conn, phonebook4)
        create_phonebook(conn, phonebook5)
        create_phonebook(conn, phonebook6)
        create_phonebook(conn, phonebook7)
        create_phonebook(conn, phonebook8)
        create_phonebook(conn, phonebook9)
        create_phonebook(conn, phonebook10)

        create_department(conn, department1)
        create_department(conn, department2)
        create_department(conn, department3)
        create_department(conn, department4)
        create_department(conn, department5)
        create_department(conn, department6)
        create_department(conn, department7)
        create_department(conn, department8)
        create_department(conn, department9)
        create_department(conn, department10)


        create_contact(conn, contact1)
        create_contact(conn, contact2)
        create_contact(conn, contact3)
        create_contact(conn, contact4)
        create_contact(conn, contact5)
        create_contact(conn, contact6)
        create_contact(conn, contact7)
        create_contact(conn, contact8)
        create_contact(conn, contact9)
        create_contact(conn, contact10)


    while True:
        print("Query Options")
        print("1) Select all employees where yearsExp > 6 ")
        print("2) Select the average salary by department ")
        print("3) Select firstname, lastname, and email from all the employees ")
        print("4) Select firstname, lastname, of all employees whose salary is greater than 60000 ")
        print("5) Select salary from management ")
        print("6) Enter a new employee ")
        print("7) Delete an employee ")
        print("8) Select all employees ")
        print("9) Exit the Database ")


        # print("2) Select firstname and lastment of the employee that has the email 'daarhus@gc.com' ")
        query = int(input("Enter the number for your query: "))
        print("")

        if query == 1:
            select_employee_by_yearsexp(conn, 6)
            print("")
        elif query == 2:
            select_avgSalary_by_department(conn)
            print("")
        elif query == 3:
            select_employees_firstname_lastname_And_email(conn)
            print("")
        elif query == 4:
            select_employees_salary_greaterthan60000_andfirstandlastname(conn)
            print("")
        elif query == 5:
            select_salary_from_management(conn)
            print("")
        elif query == 6:
            idnew = int(input("Enter the employee id: "))
            firstnamenew = str(input("Enter first name: "))
            lastnamenew = str(input("Enter last name: "))
            phonenew = float(input("Enter their phone number: "))
            addressnew = str(input("Enter the address: "))
            agenew = int(input("Enter the age: "))
            yearsexpnew = int(input("Enter yearexp: "))
            salarynew = float(input("Enter their salary: "))
            startingyearnew = float(input("Enter starting year: "))
            gendernew = str(input("Enter gender: "))
            emailnew = str(input("Enter their email: "))
            dobnew = str(input("Enter their DOB: "))
            maritalstatusnew = str(input("Enter their marital status: "))
            jobnew = str(input("Enter their job title: "))
            departmentnew = str(input("Enter their department: "))

            employeeNew = (idnew,addressnew,agenew,yearsexpnew,salarynew,startingyearnew,gendernew,emailnew,dobnew,maritalstatusnew);
            employee1new = create_employee(conn, employeeNew)
            contact1new = (emailnew, firstnamenew,lastnamenew)
            phonebook1new = (employee1new, phonenew)
            department1new = (employee1new,jobnew,departmentnew)

            create_phonebook(conn, phonebook1new)
            create_department(conn, department1new)
            create_contact(conn, contact1new)

            print("")
        elif query == 7:
            deleteid = int(input("What is the id of the employee you want to delete: "))
            delete_employee(conn, deleteid)
            print("")
            print("Employee ",deleteid, " has been deleted")
            print("")
        elif query == 8:
            select_all_employees(conn)
            print("")
        elif query == 9:
            conn.close()
            quit()




if __name__ == '__main__':
    main()
