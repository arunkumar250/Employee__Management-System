package EMS;

public class Employee {

    //Employee Properties
    public String EmpName,DOB,Department,Role;
    public double Salary;
    public int Emp_ID,Age;

    //Employee Constructor
    Employee(int Emp_ID,String EmpName,int Age,String DOB,String Department,String Role,double Salary)
    {
        this.Emp_ID = Emp_ID;
        this.EmpName = EmpName;
        this.Age = Age;
        this.DOB = DOB;
        this.Department = Department;
        this.Role = Role;
        this.Salary = Salary;
    }
}

