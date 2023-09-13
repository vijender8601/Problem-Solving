# Write your MySQL query statement below
SELECT W.id FROM Weather W,Weather W1
WHERE DATEDIFF(W.recordDate,W1.recordDate)=1 and  W1.temperature<W.temperature;