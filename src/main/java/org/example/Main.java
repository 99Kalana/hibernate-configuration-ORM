package org.example;


import org.example.config.FactoryConfiguaration;
import org.example.embed.FullName;
import org.example.entity.Student;
import org.example.entity.Teachers;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguaration.getInstance().getSession();

        FullName fullName = new FullName("Sheldon","Cooper");

        Student student = new Student();

        student.setId(3);
        /*student.setName("Sheldon");*/
        student.setFullName(fullName);
        student.setAddress("Galle-LK");

        Transaction transaction= session.beginTransaction();

        /*Save*/
        /*session.save(student);*/

        /*Update*/
        /*session.update(student);*/

        /*Delete*/
        /*session.delete(student);*/

        /*Get All*/
        List<Student> students = session.createQuery("FROM org.example.entity.Student", Student.class).list();

        for (Student s : students) {
            System.out.println("---------------------------------");
            System.out.println("ID: " + s.getId());
            System.out.println("Full Name: " + s.getFullName().getFirstName() + " " + s.getFullName().getLastName());
            System.out.println("Address: " + s.getAddress());
            System.out.println("---------------------------------");
        }

        transaction.commit();

        session.close();

        /*-------------------------------------------------------------------------------------*/


        /*Another table*/
        Session teacherSession = FactoryConfiguaration.getInstance().getSession();
        Transaction teacherTransaction = teacherSession.beginTransaction();

        Teachers teachers = new Teachers();

        teachers.setTid(3);
        teachers.setTname("Mr.Hawking");
        teachers.setLecmodule("Physics Universe.");

        /*Save*/
        /*teacherSession.save(teachers);*/

        /*Update*/
       /* teacherSession.update(teachers);*/

        /*Delete*/
        /*teacherSession.delete(teachers);*/

        /*Get All*/

        List<Teachers> teacher1 = teacherSession.createQuery("FROM org.example.entity.Teachers", Teachers.class).list();

        for (Teachers t : teacher1){
            System.out.println("---------------------------------");
            System.out.println("TID: " + t.getTid());
            System.out.println("TName: " + t.getTname());
            System.out.println("LecModule: " + t.getLecmodule());
            System.out.println("---------------------------------");
        }

        teacherTransaction.commit();
        teacherSession.close();

    }
}