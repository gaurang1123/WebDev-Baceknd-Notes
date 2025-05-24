# Databases
There are two types of Database 
1. Relational (SQL)
2. NON-RELATIONAL (NOSQL)

-Relational Database uses a Table like structure with Rows and Columns.
-Non Relational Databases which uses any format other than table (json, key/value, graphs).

# Relational Database
We use DBMS (Database management system) for Relational Database.

Database are like a folder which has files. where folder is database and files are tables.

## Database in Mysql

### CREATE DATABASE

```sql
CREATE DATABASE db_name
```

i.e CREATE DATABASE myDB;

### USE DATABASE

```sql
USE db_name;
```

i.e USE myDB;

### DELETE DATABASE / DROP DATABASE

```sql
DROP db_name;
```

i.e DROP myDB;

### CREATE TABLE

```sql
CREATE TABLE table_name(
    col1_name data_type constrains,
    col2_name data_type constrains,
    col3_name data_type constrains
) 
```

i.e
```sql
CREATE TABLE Employee(
    employee_id INT ,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    salary_hour DECIMAL(5,2),
    hire_date DATE,
);
```

### RENAME TABLE

```sql
RENAME TABLE prev_name new_name;
```

i.e RENAME TABLE Employee Workers;

### DROP/DELETE TABLE

```sql
DROP TABLE table_name;
```

i.e DROP TABLE Employee

### ALTER TABLE / CHANGE TABLE 

#### ADD FIELD
```sql
ALTER TABLE EMPLOYEE ADD field_name type;
```

i.e ALTER TABLE EMPLOYEE ADD phone_number VARCHAR(10);

#### DROP FIELD

```sql
ALTER TABLE EMPLOYEE DROP field_name;
```

i.e ALTER TABLE EMPLOYEE DROP phone_number;

#### RENAME FIELD

```sql
ALTER TABLE EMPLOYEE RENAME prev_name to new_field;
```

i.e ALTER TABLE EMPLOYEE RENAME COLUMN phone_number to email; 

#### MODIFY TYPE OF FIELD

```sql
ALTER TABLE EMPLOYEE MODIFY field_name type;
```

i.e ALTER TABLE EMPLOYEE MODIFY COLUMN email VARCHAR(50);

#### CHANGE FIELD POSITION

```sql
ALTER TABLE EMPLOYEE MODIFY field_name type AFTER after_field_name; 
```

i.e ALTER TABLE EMPLOYEE MODIFY email varchar(50) AFTER last_name;

```sql
ALTER TABLE EMPLOYEE MODIFY field_name type FIRST;
```

i.e ALTER TABLE EMPLOYEE MODIFY email varchar(50) FIRST; 


### DATA TYPES IN MySql
1. Character
-CHAR
-- Create memory for fixed size 
-- i.e CHAR(5) will take memory for 5 charachters even if there is only 2 used.

-VARCHAR
-- Create memory only for reuired charachters.
-- i.e VARCHAR(5) only takes required memory.
-BLOB
-- Larger strings like file data.

2. Numbers
-INT
-- interger range(-2147483648 to 2147483647)

-TINYINT
-- small interger range(-128 to 127)

-BIGINT
-- Larger interger 

3. Decimal
-FLOAT
-- Decimal numbers with 23 precision 

-DOUBLE
-- Decimal with 24 to 53 digits

4. BOOLEAN
-TRUE
-- uses TINYINT to store 1 for TRUE

-False
-- uses TINYINT to store 0 for FALSE

### SIGNED AND UNSIGNED 
TINYINT UNSIGNED (0 to 255) i.e id TINYINT UNSIGNED;
TINYINT (-128 to 127)

### INSERT VALUES INTO TABLES

```sql
INSERT INTO table_name
    VALUES
    (value_1,value_2,value_3,value_4,value_5)
    (value_1,value_2,value_3,value_4,value_5)
    (value_1,value_2,value_3,value_4,value_5);
            
            OR

INSERT INTO table_name
    (field_1,field_2,field_3,field_4,field_5,)
    VALUES
    (value_1,value_2,value_3,value_4,value_5)
    (value_1,value_2,value_3,value_4,value_5)
    (value_1,value_2,value_3,value_4,value_5);
```

// We can omit columns whose data is not available in above

i.e
```sql
INSERT INTO Employee
    VALUES
    (1,"Gaurang","Khoraba",99.9,"2024-12-24"),
    (2,"Dharmesh","Solanki",129.9,"2023-04-25");

                        OR

INSERT INTO Employee
    (employee_id,first_name,last_name,salary_hour,hire_date)
    VALUES
    (1,"Gaurang","Khoraba",99.9,"2024-12-24"),
    (2,"Dharmesh","Solanki",129.9,"2023-04-25");
// We can omit columns whose data is not available in above
```


### Adding Current DATE and TIME into table

we can add Current Date and time into Table using functions like
current_date(), current_time(), now()

current_date():- will add today's Date.
current_time():- will add current time.
now():- will add current date and time.

We can also add date in advance by adding a number into them
i.e current_date() + 1

i.e:- 
```sql
INSERT INTO test VALUES
(current_date(),current_time(),now()),
(current_date() + 1,current_time(),now()),
(current_date(),current_time()+1,now()),
(current_date(),current_time(),now()+1);
```
adding advance date/time will change last value like:-
for date it will add into day.  
for time it will add to second.


### UPDATE DATA FROM TABLE

You need to set sql_safe_update to 0 to update vlaues in table using
SET sql_safe_updates = 0;  // SETS TO FALSE
SET sql_safe_updates = 1;  // SETS TO TRUE
```sql
UPDATE Employee SET salary_hour = 60.59 WHERE employee_id = 1;
UPDATE Employee SET salary_hour = 60.59 WHERE first_name = "Gaurang";
UPDATE Employee SET salary_hour = 90 WHERE salary_hour >= 100;
UPDATE Employee SET employee_id = employee_id + 1;
```

Multiple changes
```sql
UPDATE Employee SET salary_hour = 60.59,hire_date ="2024-04-03" WHERE first_name = "Gaurang";
```

Update value for column in all row
```sql
UPDATE Employee SET salary_hour = 60.59;
```

### DELETE DATA FROM TABLES

```sql
DELETE FROM Employee;
```

will Delete values from whole table

```sql
DELETE FROM Employee WHERE salary_hour=60.59;
```

### UNDO/REDO USING COMMIT, AUTOCOMMIT, ROLLBACK

#### AUTOCOMMIT
MySql by default is set to AUTOCOMMIT = 1;
AUTOCOMMIT automatically saves and changes done in database.
To prevent it we can set autocommit to false using

```sql 
SET AUTOCOMMIT = 0;
```

#### COMMIT
It saves the changes in data. After commit we cannot undo changes.

```sql
COMMIT;
```

#### ROLLBACK
It undo all chages done until last commit.

```sql
ROLLBACK;
```

### KEYS
#### PRIMARY KEY
IT is column which has unique value and identify row uniquely. 
Should not be NULL. Only 1 column can be PRIMARY KEY for table.

#### FOREIGN KEY
A column in table which is also present in another table as its PRIMARY KEY. 
We can have multiple FOREIGN KEY in a table.
It can store NULL and Duplicate value. 

### CONSTRAINS
In Mysql we can set constrains on table to specify rules.
#### UNIQUE 
It is used to set values to be unique for a column.
-Adding unique
```sql
CREATE TABLE Posts(
id INT UNIQUE,
content VARCHAR(50))
```

//It will make column id to be unique. so there is no same id for different rows.

-ADDING UNIQUE AFTER CREATING TABLE
```sql
ALTER TABLE Posts
ADD CONSTRAIN UNIQUE(id);
```

#### NOT NULL
We can set a column to ne not null so that a value must be set for it.
-Adding not null constraints
```sql
CREATE TABLE Posts(
id INT NOT NULL,
content VARCHAR(50))
```

-ADDING NOT NULL AFTER CREATING TABLE
```sql
ALTER TABLE Posts
MODIFY content VARCHAR(50) NOT NULL;
```
#### CHECK 
It is used to set a limit on values to be set in column.

like if we want user to only add salary_hour >= 50 we use CHECK
```sql
CREATE TABLE Employee(
    employee_id INT ,
    first_name VARCHAR(50),
    salary_hour DECIMAL(5,2),
    CONSTRAIN chk_salary_hour CHECK (salary_hour >= 50) 
// salary_hour DECIMAL(5,2) CHECK (salary_hour >= 50) 
); 
```
                OR
```sql
CREATE TABLE Employee(
    employee_id INT ,
    first_name VARCHAR(50),
    salary_hour DECIMAL(5,2) CHECK (salary_hour >= 50) 
); 
```

We should use 1st method to set CHECK constrains so that we can remove it all at once from column using name given (chk_salary_hour).

ADD AFTER CREATING TABLE
```sql
ALTER TABLE Employee
ADD CONSTRAIN chk_salary_hour CHECK (salary_hour >= 50); 
```

```sql
DROP CONSTRAIN
ALTER TABLE Employee
DROP CHECK chk_salary_hour;
```

#### DEFALUT
We can set a defalut value to a column so if not set explicitly defalutis used as value.
```sql
CREATE TABLE Employee(
    employee_id INT ,
    first_name VARCHAR(50),
    salary_hour DECIMAL(5,2) DEFALUT 10 , 
); 
```

ADDING AFTER CREATING TABLE
```sql
ALTER TABLE Employee
ALTER salary_hour SET DEFALUT 0;
```

### PRIMARY KEY 
It is used to make column unique and NOT NULL but only one column can be PRIMARY KEY.
BUT we can also create a combination of column to be PRIMARY KEY.
i.e
```sql
CREATE TABLE Employee(
    employee_id INT,
    first_name VARCHAR(50),
    salary_hour DECIMAL(5,2),
    PRIMARY KEY (employee_id, first_name) 
); 
```

It will make combination of employee_id and first_name to be unique.
like we can have 
```javascript
employee_id: 1          1         2     
first_name : gaurang    Dharmesh  gaurang

BUT We cannot have
employee_id: 1          1              
first_name : gaurang    gaurang  
```

In this Combination must be unique.


### OPERATORS
Using operator in WHERE
Arithmetic operator:- +,-,*,/,%
Comparison operator:- >, <, <=, >=, !=, =
Logical operator:- AND, OR, NOT, IN, BETWEEN, ALL, LIKE, ANY


### SELECT FROM TABLE

#### SELECT ALL FROM TABLE

```sql
SELECT * FROM table_name
```

i.e SELECT * FROM EMPLOYEE;

#### SELECT SPECIFIC COLUMN

```sql
SELECT field_name,field_name from Employee;
```

i.e SELECT first_name,last_name from Employee;

#### SELECT USING WHERE CLAUSE

```sql
SELECT * FROM EMPLOYEE WHERE field_name = value; 
```

i.e SELECT * FROM EMPLOYEE WHERE id = 1; 

                OR

```sql
SELECT field_name,field_name from Employee WHERE field_name = value;
```

i.e SELECT first_name,last_name from Employee salary_hour = 100.9;

#### USING OPERATOR WITH WHERE CLAUSE

```sql
SELECT * FROM EMPLOYEE WHERE salary_hour >= 100.0 ;
SELECT * FROM EMPLOYEE WHERE salary_hour <= 100.0 ;
SELECT * FROM EMPLOYEE WHERE salary_hour != 100.0 ;
SELECT * FROM EMPLOYEE WHERE salary_hour IS NULL ;
SELECT * FROM EMPLOYEE WHERE salary_hour IS NOT NULL ;
```

### SELECT WITH OPERATOR
#### AND 
operator checks if both or all conditions are true.
i.e SELECT * FROM Employee WHERE salary_hour >= 100 AND hire_date >= "2023-01-01";

#### OR
operator checks if any one conditions is true.
i.e SELECT * FROM Employee WHERE salary_hour >= 100 OR hire_date >= "2023-01-01";

#### BETWEEN
operator SELECT from given range (must use with AND)
i.e SELECT * FROM Employee WHERE salary_hour BETWEEN 50 AND 120;

#### IN
operator matches value in column
i.e SELECT * FROM Employee WHERE last_name IN ("Solanki", "Khoraba");

#### NOT 
operator return if vlaues is NOT in column
i.e SELECT * FROM Employee WHERE last_name NOT IN ("Solanki", "Khoraba");

### SELECT + LIMIT CLAUSE

It set limit on number of rows returned.
It is used to retrive only specific amount of rows even though condition matches for more.

i.e SELECT * FROM Employee LIMIT 2;
i.e SELECT * FROM Employee WHERE salary_hour >= 90.0 LIMIT 2;

// Only retrive 2 rows even if condition matches for more

### SELECT + ORDER BY CLAUSE
Used to return rows in ASC or DESC Order

i.e SELECT * FROM Employee ORDER BY salary_hour ASC;
i.e SELECT * FROM Employee ORDER BY salary_hour DESC;
i.e SELECT * FROM Employee WHERE salary_hour > 90 ORDER BY salary_hour ASC;


### AGGREGATE Functions with SELECT

AGGREGATE Functions are functions use to perform calcuations on set of value and return single vlaues
1. COUNT() :-  calcuate and return number of rows matching condition.
i.e:- SELECT COUNT(salary_hour) FROM Employee; 
i.e:- SELECT COUNT(salary_hour) FROM Employee WHERE salary_hour >= 100; 

2. MAX() :- calcuate and return max of given field.
i.e:- SELECT MAX(salary_hour) FROM Employee;
i.e:- SELECT MAX(salary_hour) FROM Employee WHERE employee_id <= 3;

3. MIN() :- calcuate and return min of given field.
i.e:- SELECT MIN(salary_hour) FROM Employee;
i.e:- SELECT MIN(salary_hour) FROM Employee WHERE employee_id <= 3;

4. SUM() :- calcuate and return sum of all values in given field
i.e:- SELECT SUM(salary_hour) FROM Employee;
i.e:- SELECT SUM(salary_hour) FROM Employee WHERE employee_id <= 3;

5. AVG() :- calcuate and return average of all values in given field
i.e:- SELECT AVG(salary_hour) FROM Employee;
i.e:- SELECT AVG(salary_hour) FROM Employee WHERE employee_id <= 3;


### SELECT + GROUP BY  CLAUSE
It returns a group of row from given columns which has same values.
Generally we use GROUP BY with AGGREGATE functions.

i.e SELECT last_name, count(first_name) FROM Employee GROUP BY last_name;

It create a group of similar values from column and return as row.
We must do GROUP BY for all column in SELECT.
i.e SELECT last_name, first_name, count(first_name) FROM Employee GROUP BY last_name, first_name;

### SELECT + HAVING CLAUSE
After doing GROUP BY if we can not use WHERE we can use HAVING
HAVING check conditon for/after GROUP BY.
i.e SELECT last_name, count(salary_hour) FROM Employee GROUP BY last_name HAVING avg(salary_hour) > 100;

Will return GropuBy(last_name)  and count(salary_hour) where avg(salary_hour) > 100

### ORDER OF WRITING CLAUSES

SELECT column(s)
FROM table_name
WHERE condition
GROUP BY column(s)
HAVING condition
ORDER BY column(s) ASC;

