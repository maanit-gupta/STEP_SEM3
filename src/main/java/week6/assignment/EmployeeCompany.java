package week6.assignment;

public class EmployeeCompany {
    public static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void printCompanyInfo() {
        Employee.printCompanyInfo();
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Amit", 50000);
        Employee employee2 = new Employee("Priya", 60000);
        Employee employee3 = new Employee("Rahul", 55000);

        Employee.printCompanyInfo();
    }
}
