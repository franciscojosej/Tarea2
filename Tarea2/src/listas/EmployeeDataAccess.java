package listas;


import java.util.ArrayList;
import java.util.List;

public class EmployeeDataAccess {

    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        String[] depts = {"IT", "Account", "Admin", "Sales"};
        Cliente df = new Cliente("ee", "www", "ss");
        for (int i = 1; i <= 30; i++) {
            Employee e = new Employee();
            e.setName(df.getNombre());
            e.setAddress(df.getCedula() + ", " + df.getCedula() );
            e.setDept("IT");
            e.setPhone(222 + "-" + 33+
                    "-" + 33);
            list.add(e);
        }
        for (int i = 1; i <= 30; i++) {
            Employee e = new Employee();
            e.setName("pablo");
            e.setAddress(df.getCedula() + ", " + df.getCedula() );
            e.setDept("pablo");
            e.setPhone(222 + "-" + 33+
                    "-" + 33);
            list.add(e);
        }
        return list;
    }
}
