# Write your MySQL query statement below
Select d.name as Department,e.name as Employee, e.salary as Salary
From Employee e join Department d
Where e.departmentId=d.id 
AND (DepartmentId,Salary) in 
  (SELECT DepartmentId,max(Salary) FROM Employee GROUP BY DepartmentId);