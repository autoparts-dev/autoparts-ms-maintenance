SELECT CEIL(COUNT(c.ID) OVER() / :pageSize) AS TOTAL_PAGE,
c.ID, c.NAME, c.BRN, c.STATUS, c.CONTACT_NUM, c.ADDR_LINE_1, c.ADDR_LINE_2, c.ADDR_LINE_3, 
c.POSTCODE, c.MT_STATE_ID, c.MT_CTRY_ID, st.NAME STATE, ctry.NAME COUNTRY, c.CONTACT_NUM
FROM T_COMPANY c
LEFT JOIN T_MT_STATE st ON c.MT_STATE_ID = st.ID
LEFT JOIN T_MT_CTRY ctry ON c.MT_CTRY_ID = ctry.ID
WHERE c.NAME LIKE CONCAT(:name, '%') 
AND c.IS_DEL = 'N'
ORDER BY c.NAME
LIMIT :startRow, :pageSize