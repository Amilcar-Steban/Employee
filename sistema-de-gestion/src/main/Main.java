package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.Empleado;

public class Main {
    private static final ArrayList<Empleado> data = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        data.add(new Empleado("Amilcar", 21, 5000000, "DevOps"));
        data.add(new Empleado("Natalia", 19, 5000000, "Medica"));
        data.add(new Empleado("Cooper", 5, 1000000, "Pet"));
        init();
    }

    public static void menu(){
        System.out.print("""
                \t Menu
                1. Show employee
                2. Create employee
                3. Filter employee
                4. Sort employee
                5. Increase Salary
                6. Clear filters
                7. Exit
                -------------------------
                Opcion: """);
    }

    public static void menuFilter(){
        System.out.print("""
                \t Menu
                1. Name
                2. Age
                3. Salary
                4. Department
                5. Atras
                -------------------------
                Opcion: """);
    }


    public static void createEmployee(){
        Empleado newUser = new Empleado();
        
        System.out.print("Name: ");
        newUser.setName(sc.next());
        System.out.print("Age: ");
        newUser.setAge(sc.nextInt());
        System.out.print("Salary: ");
        newUser.setSalary(sc.nextDouble());
        System.out.print("Department: ");
        newUser.setDepartment(sc.next());

        data.add(newUser);
    }

    public static void logicFilter(int option){
        switch (option) {
            case 1-> {
                String name = sc.next();
                Empleado.showData(Empleado.filterByNameEmployee(data, name));
            }
            case 2-> {
                int min = sc.nextInt();
                int max = sc.nextInt();
                
                Empleado.showData(Empleado.filterByAgeEmployee(data, min, max));
            }
            case 3-> {
                int min = sc.nextInt();
                int max = sc.nextInt();
                Empleado.showData(Empleado.filterBySalaryEmployee(data, min, max));
            }
            case 4-> {
                String department = sc.next();
                Empleado.showData(Empleado.filterByDepartmentEmployee(data, department));
            }
            case 5 -> System.out.println("Atras... ");

            default -> System.out.println("Opcion invalida");
        }
    }

    public static void logicSort(int option){
        switch (option) {
            case 1-> Empleado.showData(Empleado.sortEmployee(data, "name"));
            case 2-> Empleado.showData(Empleado.sortEmployee(data, "Age"));
            case 3-> Empleado.showData(Empleado.sortEmployee(data, "Salary"));
            case 4-> Empleado.showData(Empleado.sortEmployee(data, "Department"));
            case 5 -> System.out.println("Atras... ");

            default -> System.out.println("Opcion invalida");
        }
    }
    public static void logic(int option){
        switch (option) {
            case 1-> Empleado.showData(data);
            case 2-> createEmployee();
            case 3-> {
                menuFilter();
                int optionFilter = sc.nextInt();
                logicFilter(optionFilter);
            }
            case 4-> {
                menuFilter();
                int optionSort = sc.nextInt();
                logicSort(optionSort);
            }
            case 5-> {
                Empleado.showData(data);
                updateSalaryLogic();
            }
            case 6-> Empleado.showData(data);
            case 7 -> System.out.println("Byee");
            default -> System.out.println("Opcion invalida");
        }

    }

    public static void updateSalaryLogic(){
        System.out.print("Ingrese el id del usuario: ");
        String userName = sc.next();
        System.out.print("Ingrese el % a incrementar: ");
        double percent = Double.parseDouble(sc.next());

        Empleado.showData(Empleado.updateSalary(Empleado.searchByName(data, userName), percent));
    }

    public static void init(){
        int option;
        do { 
            menu();
            option = sc.nextInt();
            logic(option);

        } while (option!=7);
    }
}
