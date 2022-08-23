CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
 Set N=N-1;
  RETURN (
      # Write your MySQL query statement below.
     
      Select Distinct salary From Employee
      ORDER BY salary desc limit 1 offset N
  );
END