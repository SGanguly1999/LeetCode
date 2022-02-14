select Name as Employee
FROM Employee as T
Where T.Salary> (select Salary from Employee where Id=T.ManagerId)