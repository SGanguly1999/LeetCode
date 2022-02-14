DELETE P FROM 
Person as P
INNER JOIN Person as L
    ON P.Email = L.Email
    AND L.ID < P.ID
