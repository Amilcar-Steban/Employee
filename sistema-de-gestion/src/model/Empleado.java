package model;

import java.util.ArrayList;

public class Empleado {

    private String name;
    private int age;
    private double salary;
    private String department;
    private int id;
    private static int nextId= 1;


    public Empleado(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.id = nextId++;
    }
    
    public Empleado() {
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Empleado.nextId = nextId;
    }

    public static void showData(Empleado e) {
        System.out.printf("%-5s %-20s %-10s %-15s %-20s%n", "id", "Name", "Age", "Salary", "Department");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10d %-15.1f %-20s%n",e.id, e.name, e.age, e.salary, e.department);
        System.out.println();
    }

    public static void showData(ArrayList<Empleado> data) {
        System.out.printf("%-5s %-20s %-10s %-15s %-20s%n", "id", "Name", "Age", "Salary", "Department");
        System.out.println("------------------------------------------------------------------");
        for (Empleado e : data) {
            System.out.printf("%-5s %-20s %-10d %-15.1f %-20s%n",e.id, e.name, e.age, e.salary, e.department);
        }
        System.out.println();
    }

    public static ArrayList<Empleado> filterByNameEmployee( ArrayList<Empleado> empleados, String data){
        ArrayList<Empleado> result = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.name.equalsIgnoreCase(data)) {
                result.add(empleado);
            }
        }
        return result;
    }

    public static ArrayList<Empleado> filterByDepartmentEmployee( ArrayList<Empleado> empleados, String data){
        ArrayList<Empleado> result = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.department.equalsIgnoreCase(data)) {
                result.add(empleado);
            }
        }
        return result;
    }

    public static ArrayList<Empleado> filterByAgeEmployee( ArrayList<Empleado> empleados, int min, int max){
        ArrayList<Empleado> result = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.age>=min && empleado.age<=max) {
                result.add(empleado);
            }
        }
        return result;
    }

    public static ArrayList<Empleado> filterBySalaryEmployee( ArrayList<Empleado> empleados, double  min, double max){
        ArrayList<Empleado> result = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.salary>=min && empleado.salary<=max) {
                result.add(empleado);
            }
        }
        return result;
    }

    public static ArrayList<Empleado> sortEmployee(ArrayList<Empleado> empleados, String metodo){
        int quantity = empleados.size();
        switch (metodo.toLowerCase()) {
            case "age"-> {
                for (int i = 0; i < quantity-1; i++) {
                    for (int j = 0; j < quantity-1-i; j++) {
                        if (empleados.get(j).age > empleados.get(j+1).age) {
                            Empleado temp = empleados.get(j);
                            empleados.set(j, empleados.get(j+1));
                            empleados.set(j+1, temp);
                        }
                    }
                }
            }
            case "Salary"-> {
                for (int i = 0; i < quantity-1; i++) {
                    for (int j = 0; j < quantity-1-i; j++) {
                        if (empleados.get(j).salary > empleados.get(j+1).salary) {
                            Empleado temp = empleados.get(j);
                            empleados.set(j, empleados.get(j+1));
                            empleados.set(j+1, temp);
                        }
                    }
                }
            }
            case "name"-> {
                for (int i = 0; i < quantity-1; i++) {
                    for (int j = 0; j < quantity-1-i; j++) {
                        if (empleados.get(j).name.compareTo(empleados.get(j + 1).name) > 0) {
                            Empleado temp = empleados.get(j);
                            empleados.set(j, empleados.get(j+1));
                            empleados.set(j+1, temp);
                        }
                    }
                }
            }
            case "department"-> {
                for (int i = 0; i < quantity-1; i++) {
                    for (int j = 0; j < quantity-1-i; j++) {
                        if (empleados.get(j).department.compareTo(empleados.get(j + 1).department) > 0) {
                            Empleado temp = empleados.get(j);
                            empleados.set(j, empleados.get(j+1));
                            empleados.set(j+1, temp);
                        }
                    }
                }
            }
            default -> System.out.println("Opcion invalida");
        }
        
        return empleados;
    }
    
    public static Empleado searchByName(ArrayList<Empleado> data, String name){
        Empleado result = new Empleado();
        for (Empleado empleado : data) {
            if (empleado.name.equalsIgnoreCase(name)) {
                result = empleado;
                break;
            }
        }
        return result;
    }

    public static Empleado updateSalary(Empleado data, double percent){
        double salary = data.salary;
        data.setSalary((salary+salary*percent));
        return data;
    }
}
