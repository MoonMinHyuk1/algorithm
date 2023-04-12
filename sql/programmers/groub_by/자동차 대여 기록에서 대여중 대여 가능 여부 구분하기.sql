select CAR_ID, 
(CASE
    WHEN car_id in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where '2022-10-16' between date_format(start_date, '%Y-%m-%d') and date_format(end_date, '%Y-%m-%d')
    )
    THEN '대여중'
    ELSE '대여 가능'
    END
) as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc;