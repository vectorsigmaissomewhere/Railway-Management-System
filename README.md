## Getting Started


Database Design
```text
+-------------------------------------+
| Tables_in_railway_management_system |
+-------------------------------------+
| employees                           |
| passengers                          |
| trains                              |
| trip 0 passengers                   |
| trip 1 passengers                   |
| trip_passengers                     |
| trips                               |
+-------------------------------------+
7 rows in set (0.04 sec)

mysql> desc employees;
+----------+---------------+------+-----+---------+-------+
| Field    | Type          | Null | Key | Default | Extra |
+----------+---------------+------+-----+---------+-------+
| ID       | int           | NO   | PRI | NULL    |       |
| Name     | varchar(255)  | YES  |     | NULL    |       |
| Email    | varchar(255)  | YES  |     | NULL    |       |
| Tel      | varchar(20)   | YES  |     | NULL    |       |
| Salary   | decimal(10,2) | YES  |     | NULL    |       |
| Position | varchar(255)  | YES  |     | NULL    |       |
+----------+---------------+------+-----+---------+-------+
6 rows in set (0.04 sec)

mysql> desc passengers;
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| ID    | int          | NO   | PRI | NULL    |       |
| Name  | varchar(255) | YES  |     | NULL    |       |
| Email | varchar(255) | YES  |     | NULL    |       |
| Tel   | varchar(20)  | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

mysql> desc trains;
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| ID          | int          | NO   | PRI | NULL    |       |
| Capacity    | int          | YES  |     | NULL    |       |
| Description | varchar(255) | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> desc trip_passengers;
+-----------+------+------+-----+---------+-------+
| Field     | Type | Null | Key | Default | Extra |
+-----------+------+------+-----+---------+-------+
| TripID    | int  | YES  | MUL | NULL    |       |
| Passenger | int  | YES  | MUL | NULL    |       |
| Tickets   | int  | YES  |     | NULL    |       |
+-----------+------+------+-----+---------+-------+
3 rows in set (0.04 sec)

mysql> desc trips;
+---------------+---------------+------+-----+---------+-------+
| Field         | Type          | Null | Key | Default | Extra |
+---------------+---------------+------+-----+---------+-------+
| ID            | int           | NO   | PRI | NULL    |       |
| Start         | varchar(255)  | YES  |     | NULL    |       |
| Destination   | varchar(255)  | YES  |     | NULL    |       |
| DepartureTime | time          | YES  |     | NULL    |       |
| ArrTime       | time          | YES  |     | NULL    |       |
| Date          | date          | YES  |     | NULL    |       |
| BookedSeats   | int           | YES  |     | NULL    |       |
| Price         | decimal(10,2) | YES  |     | NULL    |       |
| Driver        | int           | YES  | MUL | NULL    |       |
| Train         | int           | YES  | MUL | NULL    |       |
+---------------+---------------+------+-----+---------+-------+
```