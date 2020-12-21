#data generator

# generate random integer values
import random
import string
from random import randint

# resources
# https://www.educative.io/edpresso/how-to-generate-a-random-string-in-python
#generate sql strings and write them to data.sql file


# Variables

# value arrays
gender = ['m','f']
letters = ['a','b','c','d','e','f','g','h','i',
            'j','k','l','m','n','o','p','q','r','s','t','u',
            'v','w','x','y','z']
compass = ['east','north','west','south']
str_numbers = ['0','1','2','3','4','5','6','7','8','9']
Enthnicty = ['asian','white','black','hispanic','irish','creol',
            'german','thai','greek','indian','cuban','russian']
Jobs = ['Sales Rep', 'CS Rep', 'Claims Specialist']
state = ['CA','WA','MT','TN','TX','NM','OR','ID','NY','VA','AZ','NV']
educative = ['bachelor', 'hs diploma', 'masters']
payyyrate = ['part-time', 'Salary']
paymentype = ['check','direct deposit']
month = ['jan','feb','march','april','may','june'
        ,'july','aug','sept','oct','nov','dec']
relationstat = ['married','single','itsComplicated']
relation = ['parent','sibling','aunt','uncle','grandparent']
complaintt = ['bullying', 'misconduct', 'None', 'None', 'None', 'None']
workdays = ['mon','tues','wed','thur','fri']
worktime = ['8am','9am','10am','11am','12pm','1pm','2pm','3pm','4m']
schools = ['Chapman','Stanford','Cal','Chapman',
        'Texas','Harvard','NC State','Brown','ITT Tech',
        'Virgina','Utah','Hawaii', 'High School',
        'Yale','UNLV','Montana']
department = ['entry level', 'entry level', 'entry level', 'mid level', 'mid level', 'management']

data = open("data.sql", "w")

for i in range(1,1000001):

    #id
    id = str(i)
    #address
    addystart = (''.join(random.choice(str_numbers) for _ in range(randint(1, 5))) )
    addyfinish = (''.join(random.choice(letters) for _ in range(randint(1, 5))) )
    comp = (''.join(random.choice(compass)) )
    addy = addystart + ' ' + comp + ' ' + addyfinish

    #age
    age = randint(21,50)
    age = str(age)

    #yearsExp
    exp = randint(2,10)
    exp = str(exp)

    #StartingYear
    startyear = randint(2010,2018)
    startyear = str(startyear)

    # Gender
    gend = random.choice(gender)

    # emailnew
    handle = '@gc.com'
    emailhead = (''.join(random.choice(letters) for _ in range(randint(5, 8))) )
    newemail = emailhead + handle

    # birthmonth
    mon = random.choice(month)

    # MaritalStatus
    relationship = random.choice(relationstat)

    # Ethnicity
    race = random.choice(Enthnicty)

    # ot
    # overt = 'NULL'

    employeesql = "INSERT INTO Employees values("
    employeesql = (employeesql + id + ',' + "'" +  addy + "'" + ','
                        + age + ','
                        + exp + ','
                        + startyear + ','
                        + "'" + gend + "'" + ','
                        + "'" + newemail + "'" + ','
                        + "'" + mon + "'" + ','
                        + "'" + relationship + "'" + ','
                        + "'" + race + "'" +
                        # + ','
                        # + "PRIMARY KEY (" + id + ')'
    ');' + '\n')

    # Phone
    phone = randint(1111111111,9999999999)
    phone = str(phone)

    # EmergenceyPhone
    Ephone = randint(1111111111,9999999999)
    Ephone = str(Ephone)

    phonebooksql = "INSERT INTO Phonebook values("
    phonebooksql = (phonebooksql + id + ',' + "'" +  phone + "'" + ','
                        + "'" + Ephone + "'"
    ');' + '\n')


    # jobtitle
    duty = random.choice(Jobs)

    # department
    d = random.choice(department)

    # income
    money = randint(30000,90000)
    money = str(money)

    departmentsql = "INSERT INTO Department values("
    departmentsql = (departmentsql + id + ',' + "'" +  duty + "'" + ','
                        + "'" + d + "'" + ','
                        + money +
    ');' + '\n')


    # firstname
    fname = (''.join(random.choice(letters) for _ in range(randint(4, 7))) )

    # lastname
    lname = (''.join(random.choice(letters) for _ in range(randint(4, 7))) )

    # EmergencyContact
    econtact = (''.join(random.choice(letters) for _ in range(randint(4, 7))) )

    # EmergencyRelation
    erelation = random.choice(relation)

    contactsql = "INSERT INTO Contact values("
    contactsql = (contactsql + id + ',' + "'" +  fname + "'" + ','
                        + "'" + lname + "'" + ','
                        + "'" + econtact + "'" + ','
                        + "'" + erelation + "'"
    ');' + '\n')


    # complaint
    complain = random.choice(complaintt)

    # complaintDate
    complaindate = random.choice(workdays)

    # complaintTime
    complaintime = random.choice(worktime)

    hrsql = "INSERT INTO HumanResources values("
    hrsql = (hrsql + id + ',' + "'" +  complain + "'" + ','
                        + "'" + complaindate + "'" + ','
                        + "'" + complaintime + "'"
    ');' + '\n')


    # Hometown
    town = (''.join(random.choice(letters) for _ in range(randint(6, 8))) )

    # HomeState
    st = random.choice(state)

    # SchoolAttended
    school = random.choice(schools)

    # Education
    edu = random.choice(educative)

    bgsql = "INSERT INTO Background values("
    bgsql = (bgsql + id + ',' + "'" +  town + "'" + ','
                        + "'" + st + "'" + ','
                        + "'" + school + "'" + ','
                        + "'" + edu + "'"
    ');' + '\n')

    # Payrate
    Payrate = random.choice(payyyrate)

    # PayType
    PayType = random.choice(paymentype)

    # absences
    abs = randint(3,10)
    abs = str(abs)

    # Overtimehours
    overhrs = randint(0,7)
    overhrs = str(overhrs)

    paysql = "INSERT INTO Payment values("
    paysql = (paysql + id + ',' + "'" +  Payrate + "'" + ','
                        + "'" + PayType + "'" + ','
                        + abs + ','
                        + overhrs +
    ');' + '\n')


    data.write(employeesql)
    data.write(phonebooksql)
    data.write(departmentsql)
    data.write(contactsql)
    data.write(hrsql)
    data.write(bgsql)
    data.write(paysql)



# data.write(sql)
data.close()

#open and read the file after the appending:
# read = open("data.sql", "r")
# print(read.read())
