/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASM
 */
public class QuanLy {
    ArrayList<Student> listStudent=new ArrayList<>();
    ArrayList<Employee> listEmployee=new ArrayList<>();
    ArrayList<Customer> listCustomer=new ArrayList<>();
    public void Input()
    {
        Student s1=new Student("Trần Văn Thành", "Tân Phú", 6, 7);
        listStudent.add(s1);
        Student s2=new Student("Nguyễn Trọng An", "Tân Bình", 5, 7);
        listStudent.add(s2);
        Student s3=new Student("Phân Huỳnh Phú", "Quận 2", 8.5, 7.25);
        listStudent.add(s3);
        Collections.sort(listStudent,new SortbynameStudent());

        Employee e1=new Employee("Trung Hoàng Thái", "Hà Tây", 1.6);
        listEmployee.add(e1);
        Employee e2=new Employee("Pham Thành Nam", "Củ chi", 0.5);
        listEmployee.add(e2);
        Employee e3=new Employee("Nguyễn Trọng Nhân", "Cần giờ", 2);
        listEmployee.add(e3);
        Collections.sort(listEmployee,new SortbynameEmployee());

        Customer c1=new Customer("Phạm Thanh Thảo", "Tân bình", "Trà sữa", 50000000);
        listCustomer.add(c1);
        Customer c2=new Customer("Trần huyền trang", "Bình Tân", "Vàng bạc", 10000000);
        listCustomer.add(c2);
        Customer c3=new Customer("Trần Thảo Huyền", "Bình thạnh", "Mỳ ăn liền", 100000000);
        listCustomer.add(c3);
        Collections.sort(listCustomer,new SortbynameCustomer());
    }
    public void output()
    {
        System.out.println("Students: ");
        for (Student s:listStudent)
            System.out.println(s.toString());
        System.out.println("Employee");
        for (Employee e: listEmployee)
            System.out.println(e.toString());
        System.out.println("Customer");
        for(Customer c: listCustomer)
            System.out.println(c.toString());
    }
    public void Xoa()
    {
        for (Student s:listStudent)
        {
            if (s.getHoten()=="Trần Văn Thành")
            {
                listStudent.remove(s);
                break;
            }
        }
        
        for (Employee e: listEmployee)
        {
            if(e.getHoten()=="Nguyễn Trọng Nhân")
            {
                listEmployee.remove(e);
                break;
            }
        }
        
        for(Customer c: listCustomer)
        {
            if(c.getHoten()=="Trần huyền trang")
            {
                listCustomer.remove(c);
                break;
            }
        }
        System.out.println("Xau khi xoa: ========================");
    }
}
