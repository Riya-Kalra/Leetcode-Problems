# Write your MySQL query statement below
SELECT
	CASE
		WHEN seat.id % 2 = 0 THEN seat.id - 1
        WHEN seat.id = (SELECT COUNT(*) FROM seat) THEN seat.id
		ELSE
			seat.id + 1
	END as id,
	student 
FROM seat
ORDER BY id;