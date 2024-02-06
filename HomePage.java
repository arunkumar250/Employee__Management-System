package EMS;

import java.util.*;
import java.util.Map.Entry;
public class HomePage {

    private static Scanner in;
    private static Employee employee;
    private static Department department;
    public static LinkedHashMap<Integer,Employee> employeeStorage = new LinkedHashMap<Integer,Employee>();
    private static int empCount;

    public static void main(String args[])
	{
		in=new Scanner(System.in);
        int choice;
		do
		{
			System.out.println(" ---------------------------------------------------------------------------");
			System.out.println("|                 ---- Employee Management System   ----                       |");
			System.out.println("|                 ----       Home Page         ----                       |");
			System.out.println(" ---------------------------------------------------------------------------\n");
			System.out.println("		[1]  Show Employees ");
			System.out.println("		[2]  Search Employee");
			System.out.println("		[3]  Filter Employees");
			System.out.println("		[4]  Update an Employee Detail");
			System.out.println("		[5]  Delete an Employee");
            System.out.println("		[6]  Add new Employee");
            System.out.println("		[7]  Department Average Salary");
			System.out.print("Press the Option : ");
			addDefaultEmployees();
            choice = in.nextInt();
            in.nextLine();

            switch(choice)
            {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    filterEmployee();
                    break;
                case 4:
                	updateEmployee();
                	break;
                case 5:
                	deleteEmployee();
                	break;
                case 6:
                    addEmployee();
                    break;
                case 7:
                	getAverage();
                	break;
            }
		}while(choice!=8);
	}

    //get user inputs
    public static void addEmployee()
    {
        try
        {
            in = new Scanner(System.in);
            System.out.println("Enter Employee Name :");
            String name = in.nextLine();
            System.out.println("Enter Employee Age :");
            int Age = in.nextInt();
            System.out.println("Enter Employee DOB :");
            String DOB = in.next();
            System.out.println("Enter Employee Department :");
            String Dep = in.next();
            System.out.println("Enter Employee Role :");
            String role = in.next();
            in.nextLine();
            System.out.println("Enter Employee Salary :");
            double Salary = in.nextDouble();
            employee = new Employee(empCount,name,Age,DOB,Dep,role,Salary);
            employeeStorage.put(empCount++,employee);
            System.out.println("Employee Added Successfully!!!");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //displayEmployees
    public static void displayEmployees()
    {
        try
        {
            for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
            {
            	System.out.println(entry.getKey());
                System.out.println("Employee ID   : "+entry.getValue().Emp_ID);
                System.out.println("Employee Name : "+entry.getValue().EmpName);
                System.out.println("Employee Age : "+entry.getValue().Age);
                System.out.println("Employee DOB : "+entry.getValue().DOB);
                System.out.println("Employee Department : "+entry.getValue().Department);
                System.out.println("Employee Role : "+entry.getValue().Role);
                System.out.println("Employee Salary : "+entry.getValue().Salary);
                System.out.println("-------------------------------------------------------------------------------");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //searchEmploee();
    public static void searchEmployee()
    {
        char choice;
        in = new Scanner(System.in);
        do
        {
            int option;
            System.out.println("Which one do you prefer to Search?");
            System.out.println("1.Employee ID");
            System.out.println("2.Employee Name");
            option = in.nextInt();
            if(option==1)
            {
                System.out.println("Enter the employee ID");
                int id = in.nextInt();
                try
                {
                    for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
                    {
                        if(entry.getValue().Emp_ID==id)
                        {
                            System.out.println("Employee ID   : "+entry.getValue().Emp_ID);
                            System.out.println("Employee Name : "+entry.getValue().EmpName);
                            System.out.println("Employee Age : "+entry.getValue().Age);
                            System.out.println("Employee DOB : "+entry.getValue().DOB);
                            System.out.println("Employee Department : "+entry.getValue().Department);
                            System.out.println("Employee Role : "+entry.getValue().Role);
                            System.out.println("Employee Salary : "+entry.getValue().Salary);
                            break;
                        }
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            else if(option==2)
            {
                String name = in.nextLine();
                try
                {
                    for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
                    {
                        if(entry.getValue().EmpName.equals(name))
                        {
                            System.out.println("Employee ID   : "+entry.getValue().Emp_ID);
                            System.out.println("Employee Name : "+entry.getValue().EmpName);
                            System.out.println("Employee Age : "+entry.getValue().Age);
                            System.out.println("Employee DOB : "+entry.getValue().DOB);
                            System.out.println("Employee Department : "+entry.getValue().Department);
                            System.out.println("Employee Role : "+entry.getValue().Role);
                            System.out.println("Employee Salary : "+entry.getValue().Salary);
                        }
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            System.out.println("If you want to Continue? [Y/N]");
            choice = in.next().charAt(0);
        }while(choice=='Y');
    }
    
    //updating the Employee Details
    public static void updateEmployee()
    {
    	 int option;
         System.out.println("Enter the Employee ID");
         option = 1;
         if(option==1)
         {
             int id = in.nextInt();
             try
             {
                 for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
                 {
                     if(entry.getValue().Emp_ID==id)
                     {
                         System.out.println("What details you need to Update "+entry.getValue().EmpName);
                         System.out.println("1.name\n2.Age\n3.DOB\n4.Dep\n5.Role\n6.Salary");
                         int takeChoice = in.nextInt();
                         switch(takeChoice)
                         {
                            case 1:
                            	System.out.println("Enter the new Name");
                            	String newName = in.next();
                            	entry.getValue().EmpName = newName;
                            	break;
                            case 2:
                            	System.out.println("Enter the new Age");
                            	int age = in.nextInt();
                            	entry.getValue().Age = age;
                            	break;
                            case 3:
                            	System.out.println("Enter the new DOB");
                            	String DOB = in.next();
                            	entry.getValue().DOB = DOB;
                            	break;
                            case 4:
                            	System.out.println("Enter the new Department");
                            	String Dep = in.next();
                            	entry.getValue().Department = Dep;
                            	break;
                            case 5:
                            	System.out.println("Enter the new Role");
                            	String role = in.next();
                            	entry.getValue().Role = role;
                            	break;
                            case 6:
                            	System.out.println("Enter the new Salary");
                            	double sal = in.nextDouble();
                            	entry.getValue().Salary = sal;
                            	break;
                            default:
                            	System.out.println("Successfully Updated");
                            	break;
                         }
                         System.out.println("Successfully Updated");
                         System.out.println("----------------------------------------------------------");
                         System.out.println("----------------------------------------------------------");
                         System.out.println();
                         break;
                     }
                 }
             }
             catch(Exception e)
             {
                 System.out.println(e);
             }
         }
    }
    
    //deleting the Employee Details
    public static void deleteEmployee()
    {
    	 int option;
         System.out.println("Enter the Employee ID");
         option = 1;
         if(option==1)
         {
             int id = in.nextInt();
             try
             {
                 for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
                 {
                     if(entry.getValue().Emp_ID==id)
                     {
                         System.out.println(entry.getValue().EmpName +" is deleted from DB");
                         employeeStorage.remove(id+1);
                         System.out.println("Successfully Deleted");
                         System.out.println("----------------------------------------------------------");
                         System.out.println("----------------------------------------------------------");
                         System.out.println();
                         break;
                     }
                 }
             }
             catch(Exception e)
             {
                 System.out.println(e);
             }
         }
    }
    
    
    //filterEmployee
    public static void filterEmployee()
    {
    	int choice;
    	in = new Scanner(System.in);
    	System.out.println("What based criteria Details you need?");
    	System.out.println("1.Department");
    	System.out.println("2.Role");
    	System.out.println("3.Salary");
    	choice = in.nextInt();
    	if(choice==1)
    	{
    		System.out.println("Enter the Department");
    		System.out.println("1.SDE");
    		System.out.println("2.Product Management");
    		int ch = in.nextInt();
    		String dep = "";
    		if(ch==1) dep = "SDE";
    		else if(ch==2) dep = "Product Management";
    		try
            {
                for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
                {
                    if(entry.getValue().Department.equals(dep))
                    {
                        System.out.println("Employee ID   : "+entry.getValue().Emp_ID);
                        System.out.println("Employee Name : "+entry.getValue().EmpName);
                        System.out.println("Employee Age : "+entry.getValue().Age);
                        System.out.println("Employee DOB : "+entry.getValue().DOB);
                        System.out.println("Employee Department : "+entry.getValue().Department);
                        System.out.println("Employee Role : "+entry.getValue().Role);
                        System.out.println("Employee Salary : "+entry.getValue().Salary);
                        System.out.println("------------------------------------------------------------------------");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    	}
    	else if(choice==2)
    	{
    		System.out.println("Enter the Role");
    		System.out.println("1.Software Developer");
    		System.out.println("2.Product Manager");
    		int ch = in.nextInt();
    		String role = "";
    		if(ch==1) role = "Software Developer";
    		else if(ch==2) role = "Product Manager";
    		try
            {
                for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
                {
                    if(entry.getValue().Role.equals(role))
                    {
                        System.out.println("Employee ID   : "+entry.getValue().Emp_ID);
                        System.out.println("Employee Name : "+entry.getValue().EmpName);
                        System.out.println("Employee Age : "+entry.getValue().Age);
                        System.out.println("Employee DOB : "+entry.getValue().DOB);
                        System.out.println("Employee Department : "+entry.getValue().Department);
                        System.out.println("Employee Role : "+entry.getValue().Role);
                        System.out.println("Employee Salary : "+entry.getValue().Salary);
                        System.out.println("------------------------------------------------------------------------");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    	}
    	else if(choice==3)
    	{
    		System.out.println("Select the Salary");
    		System.out.println("1.Above 20000");
    		System.out.println("2.Above 40000");
    		System.out.println("3.Above 50000");
    		double salary;
    		int ch = in.nextInt();
    		if(ch==1)
    		{
    			salary = 20000;
    		}
    		else if(ch==2)
    		{
    			salary = 40000;
    		}
    		else 
    		{
    			salary = 50000;
    		}
    		try
            {
                for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
                {
                    if(entry.getValue().Salary>=salary)
                    {
                        System.out.println("Employee ID   : "+entry.getValue().Emp_ID);
                        System.out.println("Employee Name : "+entry.getValue().EmpName);
                        System.out.println("Employee Age : "+entry.getValue().Age);
                        System.out.println("Employee DOB : "+entry.getValue().DOB);
                        System.out.println("Employee Department : "+entry.getValue().Department);
                        System.out.println("Employee Role : "+entry.getValue().Role);
                        System.out.println("Employee Salary : "+entry.getValue().Salary);
                        System.out.println("------------------------------------------------------------------------");
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    	}
    }
    
    
    //addDefaultEmployees
    public static void addDefaultEmployees()
    {
    	int empCount = 0,Age = 20,Salary = 25000;
    	char ch = 'A';
    	String DOB = "",Dep = "SDE",role = "Software Developer",name = "";
    	for(int i=1;i<=5;i++)
    	{
    		if(i%2==0)
    		{
    			name = "Gokul";
    			role = "Product Manager";
    			Dep = "Product Management";
    		}
    		else
    		{
    			name = "Saran";
    			role = "Software Developer";
    			Dep = "SDE";
    		}
    		try
            {
                name += "."+ch++;
                DOB = "11-"+i+"-2002";
                Salary *= i; 
                employee = new Employee(empCount++,name,Age+i,DOB,Dep,role,Salary);
                employeeStorage.put(empCount,employee);
//                System.out.println("Employee Added Successfully!!!");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    	}
    }
    
    //getAverage
    public static void getAverage()
    {
    	try
        {
    		String dep;
    		System.out.println("Enter the Department");
    		System.out.println("1.SDE");
    		System.out.println("2.Product Management");
    		int ch = in.nextInt();
    		dep = "";
    		if(ch==1) dep = "SDE";
    		else if(ch==2) dep = "Product Management";
    		double total = 0,count = 0;
            for(Map.Entry<Integer,Employee> entry : employeeStorage.entrySet())
            {
            	if(entry.getValue().Department.equals(dep))
            	total+=entry.getValue().Salary;
            }
            System.out.println("The Average Salary of the"+dep+" : "+ total/count);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

