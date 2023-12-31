# Write your MySQL query statement below
SELECT st.student_id, st.student_name, sc.subject_name, COUNT(ex.subject_name) AS attended_exams FROM Students st CROSS JOIN Subjects sc LEFT JOIN Examinations ex
ON st.student_id = ex.student_id AND sc.subject_name = ex.subject_name
GROUP BY st.student_id,st.student_name,sc.subject_name
ORDER BY st.student_id, sc.subject_name
;

# cross join of 3 table