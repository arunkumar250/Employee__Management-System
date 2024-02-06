package EMS;

import java.util.*;
public class Department {
    
    //Department properties
    private int Department_ID;
    private String Department_Name;
    public List<Department> departments = new ArrayList<Department>();

    //Department Constructor
    Department(int Department_ID,String Department_Name)
    {
        this.Department_ID = Department_ID;
        this.Department_Name = Department_Name;
    }
}

