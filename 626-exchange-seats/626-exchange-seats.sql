# Write your MySQL query statement below
SELECT
    Case
		When id % 2 = 0 THEN id - 1
        When id = (SELECT COUNT(*) FROM seat) THEN id
		ELSE
			id + 1
	END as 'id',
	student 
FROM seat
ORDER BY id;
