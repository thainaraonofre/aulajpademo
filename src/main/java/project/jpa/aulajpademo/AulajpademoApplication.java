package project.jpa.aulajpademo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.jpa.aulajpademo.dominio.Pessoa;


@SpringBootApplication
public class AulajpademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AulajpademoApplication.class, args);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        Pessoa p = em.find(Pessoa.class, 6);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto");

        em.close();
        emf.close();
    }
}
