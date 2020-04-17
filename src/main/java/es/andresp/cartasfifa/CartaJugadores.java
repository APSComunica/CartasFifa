package es.andresp.cartasfifa;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CartaJugadores {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("es.andresp_CartasFifa_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        Nacionalidad nacionalidadPortugal = new Nacionalidad(1, "Portugal");
        Nacionalidad nacionalidadSuecia = new Nacionalidad(2, "Suecia");
        Nacionalidad nacionalidadHolanda = new Nacionalidad(3, "Holanda");
        Jugadores jugadoresRonaldo = new Jugadores(1,"Cristiano", "Ronaldo", 1, 1985/02/05, 93, 764.5, FALSE);

        em.getTransaction().begin();
        em.persist(nacionalidadPortugal);
        em.persist(nacionalidadSuecia);
        em.persist(nacionalidadHolanda);
        em.persist(jugadoresRonaldo);
        em.getTransaction().commit();
        
        em.close(); 
        emf.close(); 
        try { 
            DriverManager.getConnection("jdbc:derby:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\CartasFifa\\BDCartasFifa;create=true"); 
        } catch (SQLException ex) { 
        }
    }
    
}
