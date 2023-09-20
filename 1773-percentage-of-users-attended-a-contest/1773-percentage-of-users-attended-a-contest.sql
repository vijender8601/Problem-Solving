SELECT  r.contest_id, ROUND(100*COUNT(u.user_id)/(SELECT COUNT(us.user_id) FROM Users us),2) AS percentage FROM Users u INNER JOIN Register r
ON u.user_id=r.user_id 
GROUP BY r.contest_id
ORDER BY percentage DESC, contest_id;
