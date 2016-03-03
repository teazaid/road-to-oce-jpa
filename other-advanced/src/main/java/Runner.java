import guru.zaidel.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 * Created by alexanderz on 02.03.16.
 */
public class Runner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("other-advanced-orm-unit");
        EntityManager em = emf.createEntityManager();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFactory.getValidator().validate(new Employee());

        em.close();
        emf.close();
    }
}
