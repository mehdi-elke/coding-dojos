package co.mookeo;

import co.mookeo.domain.Company;
import co.mookeo.domain.Employee;

public class CompanyRunner {

    public static void main(String[] args) {
        Company company = new Company("Schnitzels and Bits");

        System.out.println("Welcome to our company, " + company.getName());

        company.setName("Bob's Bicycle Repair");

        System.out.println("Renamed the company to " + company.getName());

        company.addEmployee(new Employee("001", " Alice", 100_000.00));
        company.addEmployee(new Employee("002", "Bob", 120_000.00));
        company.addEmployee(new Employee("003", "Carl", 80_000.00));
        company.addEmployee(new Employee("004", "Bob ", 90_000.00));

        System.out.println("There are " + company.numberOfEmployees() + " employees at the company");

        company.addEmployee(new Employee("005", "Billy Bob", 70_000.00));
        company.addEmployee(new Employee("006", "Anna Lee", 90_000.00));

        System.out.println("Welcome " + company.findEmployeeById("005").getName() + " and "
                + company.findEmployeeById("006").getName() + " to the company");

        System.out.println("Now there are " + company.numberOfEmployees() + " employees at the company");

        System.out.println("Time for a pay raise for everyone!");

        Employee bob = company.findEmployeeById("002");
        System.out.printf("%s's salary before the raise is %,.2f\n", bob.getName(), bob.getSalary());

        company.everybodyGetsRaiseBy(0.1);

        System.out.printf("%s's salary after the raise is %,.2f\n", bob.getName(), bob.getSalary());
    }
}
