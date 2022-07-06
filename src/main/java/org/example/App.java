package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;


public class App {
    public static void main(String[] args) throws Exception {

        Configuration cfg = new Configuration().configure("META-INF/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);
        SessionFactory factory = cfg.buildSessionFactory();
        //creating session object
        Session session = factory.openSession();
        //creating transaction object
        Transaction t = session.beginTransaction();
        /*Creating the Student table with 20 records*/
//        Random r = new Random();
//        for(int i=1;i<=20;i++)
//        {
//            Student s = new Student();
//            s.setRollNo(i);
//            s.setName("Name"+i);
//            s.setMarks(r.nextInt(100));
//            session.save(s);
//        }
        /*Fetching and printing all the Student records*/
//      Query query = session.createQuery("from Student");
//      List<Student> list =  query.list();
//        for (Student s:list) {
//            System.out.println(s);
//        }
        /*Fetching the Student records where marks > 50*/
//        Query query = session.createQuery("from Student where marks > 50");
//
//        List<Student> list = query.list();
//
//        for (Student s:list) {
//            System.out.println(s);
//        }
        /*Fetching unique result*/
//        Query query = session.createQuery("from Student where rollno=12");
//        Student student = (Student) query.uniqueResult();
//        System.out.println(student);
        /*fetching unique record*/
//        Query query = session.createQuery("select rollNo,name,marks from Student where rollno=12");
//        Object[] student = (Object[]) query.uniqueResult();
//       for(Object o:student) {
//           System.out.println(o);
//       }
        //System.out.println(student[0]+":"+student[1]+":"+student[2]);
        /*fetching records - array of objects*/
//        Query query = session.createQuery("select rollNo,name,marks from Student");
//        List<Object[]> students = (List<Object[]>) query.list();
//         for(Object[] student:students) {
//             System.out.println(student[0]+":"+student[1]+":"+student[2]);
//       }
        /*fetching the sum of marks*/
        int value = 60;
        Query query = session.createQuery("select sum(marks) from Student s where s.marks>:value");
        query.setParameter("value",value);
        Long marks = (Long) query.uniqueResult();
        System.out.println(marks);

        t.commit();
        session.close();
        System.out.println("success");

    }
}
