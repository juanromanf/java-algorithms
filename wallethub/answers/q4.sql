select a.Date, count(bugs.id) as open_bugs_until_date
from (
    select curdate() - INTERVAL (a.a + (10 * b.a) + (100 * c.a)) DAY as Date
    from (      select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as a
    cross join (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as b
    cross join (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as c
) a
left join bugs on (open_date <= a.Date and (close_date >= a.Date or close_date is null))
where 
a.Date between '2017-01-10' and '2017-02-05' 
group by 1
order by 1 asc