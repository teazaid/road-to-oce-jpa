import guru.zaidel.model.Person;
import guru.zaidel.model.Phone;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by alexanderz on 04.02.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("query-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Person person = new Person();
        Phone ph1 = new Phone();
        ph1.setNumber("1");

        Phone ph2 = new Phone();
        ph1.setNumber("1");

        ph1.setPerson(person);
        ph2.setPerson(person);

        person.setPhones(Arrays.asList(ph1, ph2));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        entityManager.persist(ph1);
        entityManager.persist(ph2);
        transaction.commit();

        entityManager.clear();

        transaction = entityManager.getTransaction();
        transaction.begin();

        //Query query = entityManager.createQuery("select p.phones from Person p");
        /*
        * select phones2_.id as id1_1_, phones2_.number as number2_1_, phones2_.person_id as person_i3_1_ from
            Person person0_ inner join Phone phones2_ on person0_.id=phones2_.person_id cross
                join Phone phone1_
            where
                person0_.id=phone1_.person_id
                and phone1_.number='1'
        *
        * */

        //Query query = entityManager.createQuery("select p.phones from Person p, Phone ph where p = ph.person and ph.number = '1'");
        //Query query = entityManager.createQuery("select ph.number from Person p join p.phones ph where ph.number = '1'");
        Query query = entityManager.createQuery("select count(*) from Person p join p.phones ph where ph.number = '1' group by p");
        List resultList = query.getResultList();

        Query parNumQuery = entityManager.createQuery("select count(*) from Person p join p.phones ph where ph.number = ?1 group by p");
        parNumQuery.setParameter(1, "1");
        //parNumQuery.setParameter(1, new Date(), TemporalType.DATE);

        Query parNameQuery = entityManager.createQuery("select count(*) from Person p join p.phones ph where ph.number = :number group by p");
        parNameQuery.setParameter("number", "1");

        entityManagerFactory.addNamedQuery("MyNamedOfNamedQuery", parNameQuery);
//        entityManager.setFlushMode(FlushModeType.COMMIT);

        TypedQuery<Person> personFromSimpleSelect = entityManager.createQuery("select p from Person p", Person.class);

        personFromSimpleSelect.getResultList();

        TypedQuery<Person> personFromObjectSelect = entityManager.createQuery("select OBJECT(p) from Person p", Person.class);
        personFromObjectSelect.getResultList();

//        java.lang.IllegalArgumentException: org.hibernate.hql.internal.ast.QuerySyntaxException: expecting CLOSE, found '.' near line 1, column 16 [select OBJECT(p.phones) from guru.zaidel.model.Person p]
//        at org.hibernate.jpa.spi.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1679)
//        at org.hibernate.jpa.spi.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1602)
//        at org.hibernate.jpa.spi.AbstractEntityManagerImpl.convert(AbstractEntityManagerImpl.java:1608)
//        at org.hibernate.jpa.spi.AbstractEntityManagerImpl.createQuery(AbstractEntityManagerImpl.java:313)
//        TypedQuery<Person> personFromObjectWrongSelect = entityManager.createQuery("select OBJECT(p.phones) from Person p", Person.class);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
