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
        Jugadores jugadorRonaldo = new Jugadores(1,"Cristiano", "Ronaldo");
        jugadorRonaldo.setRetirado(Boolean.FALSE);
        jugadorRonaldo.setNacionalidad(nacionalidadPortugal);
        jugadorRonaldo.setLiga("Serie A");
        jugadorRonaldo.setFoto("fotoRonaldo");
        

        em.getTransaction().begin();
        em.persist(nacionalidadPortugal);
        em.persist(nacionalidadSuecia);
        em.persist(nacionalidadHolanda);
        em.persist(jugadorRonaldo);
        em.getTransaction().commit();
        
        em.close(); 
        emf.close(); 
        try { 
            DriverManager.getConnection("jdbc:derby:BDCartasFifa;shutdown=true"); 
        } catch (SQLException ex) { 
        }
    }
    
}
