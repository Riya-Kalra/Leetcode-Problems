CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
 Set N=N-1;
  RETURN (
      # Write your MySQL query statement below.
     
      Select Distinct salary From Employee
      ORDER BY salary desc limit N,1
  );
END