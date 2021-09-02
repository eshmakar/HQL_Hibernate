package ru.eshmakar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.eshmakar.Car;

import java.util.List;

public class GetAllElements {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //получаем список всех элементов и сохраняем все это в List
        List<Car> cars = session.createQuery("from Car").list();
        System.out.println(cars);


        session.getTransaction().commit();
        session.close();
    }
}
