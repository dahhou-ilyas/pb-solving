# Write your MySQL query statement below
SELECT unique_id, name FROM Employees left join EmployeeUNI ON Employees.id=EmployeeUNI.id