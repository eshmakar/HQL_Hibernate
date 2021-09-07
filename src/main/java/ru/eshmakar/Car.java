package ru.eshmakar;

import javax.persistence.*;

@Entity
//@NamedQueries(@NamedQuery(name = "getById", query = "from Car c where c.id = :id")) //это готовый запрос hql для дальнейшего использования
//при использования в методе main после открытия сессии пишем например так:
/*
*  Query getById = session.createNamedQuery("getById");
        getById.setParameter("id", 7);

        List list = getById.getResultList();
        list.forEach(System.out::println);
* */

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
