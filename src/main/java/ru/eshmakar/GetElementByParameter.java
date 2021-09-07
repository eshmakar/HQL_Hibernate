package ru.eshmakar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class GetElementByParameter {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Query query = session.createQuery("select distinct c.name from Car c");
//        Query query = session.createQuery("select concat(name, 'id') from Car");//добавляем символы в конец: OKAid //KALINAid
//        Query query = session.createQuery("select substring(c.name, 2, 3)  from Car c");//обрезать по кол-во символу //KA //ALI
//        Query query = session.createQuery("select length(c.name) from Car c");// выводит длину значении
//        Query query = session.createQuery("select locate('E', c.name) from Car c");// выводит индекс символа, индекс начинается с 1
//        Query query = session.createQuery("select current_timestamp from Car");//выводит время
//        Query query = session.createQuery("select bit_length(c.name) from Car c");//выводит битовую длину
//        Query query = session.createQuery("select cast(c.name as integer ) from Car c");//переобразовать текст в int и т.д
//        Query query = session.createQuery("select extract (year from current_timestamp) from Car");//получение года или дня(часы, минуты, секунды) из timestamp
        Query query = session.createQuery("select str (current_timestamp) from Car");//переобразуем данные в String




        //получаем список по параметрам и сохраняем все это в List
//        List list = query.list();
//        System.out.println(list);

        //либо получаем только один элемент

        //query.setParameter("name", "BMW");


        List<String> list = query.list();
        list.forEach(System.out::println);


        // Car car = (Car) query.uniqueResult();
        //System.out.println(car.getName());


        session.getTransaction().commit();
        session.close();
    }
}
