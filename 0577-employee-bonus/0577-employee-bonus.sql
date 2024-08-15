# Write your MySQL query statement below

SELECT name,bonus from Employee left join Bonus on Employee.empId=Bonus.empId
where bonus < 1000 or bonus is null