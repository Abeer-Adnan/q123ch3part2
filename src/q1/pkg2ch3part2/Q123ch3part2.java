/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1.pkg2ch3part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author rant
 */
public class Q123ch3part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* Qustion 1
         value -> System.out.printf("%d ", value);
         String::toUpperCase;
         () ->"Welcome to lambadas !";
         value -> value*value*value;
         */
        //qustion 2 
        try {
            Map<String, Long> chNumber
                    = Files
                       .lines(
                        Paths.get("C:\\Users\\rant\\Documents\\NetBeansProjects\\Q1,2ch3part2\\src\\q1\\pkg2ch3part2\\newFile.txt"))
                        .flatMap(ch -> Arrays.stream(ch.split("")))
                        .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
            chNumber.forEach((character, Number) -> System.out.println(character + "  >>>  " + Number));
        } catch (IOException e) {
        }
         /*
         qustion 3 
         Q3  Assuming that list is a List<Employee> in Slide 60, explain in detail the stream pipeline:
Pipeline begins with a data source, performs various intermediate operations on the data source’s elements and ends with a terminal operation. 
In this example ::
The  Data source  >>> 
** listEmployees .stream()
The Intermediate operations >>>
** .filter(e-> e.getSalary() >=800 && e.getSalary() <1200)
Stream method filter used to filter the element that satisfy a condition "using the get salary method" and checkup the result that should be greater than or equal 800 and less than 1200
** .map(e-> new Employee (e.getId(), e.getName(), e.getDepartment(), getSalary()*1.02))
The same element after filtering will mapped to create employee object and put on the constructor the value that returned from the getter methods But the returned value from get salary method  will be multiplied by 1.02.
The Terminal operation >>>
**.collect(Collectors. groupingBy(Employee::getDepartment, Collectors.counting()))
The same element will go to Stream method collect that  used to group Employees by department and number of employee in each department .. Now it will create a Tree Map , its key " Department "
 and its value " Number of Employee".
**.forEach((d, c) -> System.out.println("Dept: "+ d + ", Count: " + c));
loop will round over all the stream and print the key-value as department and its number of employee in this department respectively.. The result will appear as the form in the print statement . 


         */
    }
    
}
