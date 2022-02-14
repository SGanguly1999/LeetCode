SELECT s.id, t.student
FROM seat t,seat s
WHERE t.id=(CASE
   when s.id=(SELECT max(id) from seat) and MOD(s.id,2)!=0 then s.id
   when  MOD(s.id,2)=0 then s.id-1
   when MOD(s.id,2)!=0 then s.id+1
           end)