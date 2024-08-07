SELECT id from
(SELECT
    id,
    recordDate,
    temperature, 
    LAG(temperature) OVER (ORDER BY recordDate) AS prevtem,
    LAG(recordDate) OVER (ORDER BY recordDate) AS prevdate
FROM
    Weather
) as subrequt
where prevdate is not null and ABS(DATEDIFF(prevdate, recordDate)) = 1 && temperature>prevtem