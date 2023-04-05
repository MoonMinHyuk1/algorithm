-- 코드를 입력하세요
select  B.CATEGORY, sum(sales) as TOTAL_SALES
from    book B
join    book_sales BS
on      B.BOOK_ID = BS.BOOK_ID
where   BS.SALES_DATE LIKE '2022-01%'
group by B.CATEGORY
order by B.CATEGORY