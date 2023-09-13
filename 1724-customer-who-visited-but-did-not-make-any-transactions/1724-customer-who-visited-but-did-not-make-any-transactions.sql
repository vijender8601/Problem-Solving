# Write your MySQL query statement below
SELECT  V.customer_id, count(V.customer_id) as count_no_trans FROM Visits V LEFT JOIN Transactions T on V.visit_id=T.visit_id
WHERE T.transaction_id is NULL GROUP BY customer_id;