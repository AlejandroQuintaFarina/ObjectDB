package tutorial2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class Tutorial2 {

    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("basePoints.odb");
        
        EntityManager em = emf.createEntityManager();
           

//           em.getTransaction().begin();//crear
//           for(int i = 1; i <11; i ++){
//            Point p = new Point (i,2*i,3*i);
//            em.persist(p);
//           }
//           
//  
//            em.getTransaction().commit();
        TypedQuery<Point> q = em.createQuery("select p from Point p", Point.class);//listar todos los puntos 
        List<Point> r = q.getResultList();
        for(Point p : r){
            long id = p.getId();
            int x = p.getX();
            int y = p.getY();
            
            System.out.println(id +"," + x + ","+ y);
        }
        System.out.println("*****************************");
      
  int j = 5;      
  q = em.createQuery("select p from Point p where id >" + 5 + "", Point.class);//listar todos los puntos 
        List<Point> r4 = q.getResultList();
        for(Point p : r4){
            long id = p.getId();
            int x = p.getX();
            int y = p.getY();
            
            System.out.println(id +"," + x + ","+ y);
        }
        
        
        
        
     int v=6;   
   q = em.createQuery("select p from Point p where id ="+ v+"" , Point.class); //listar un punto
        Point r2 = q.getSingleResult();
         long id = r2.getId();
            int x = r2.getX();
            int y = r2.getY();
            System.out.println(id +"," + x + ","+ y);
 
     int z=5;
     q = em.createQuery("select p from Point p where id ="+ z +"" , Point.class); //actualizar un punto
        Point r3 = q.getSingleResult();
       y = r3.getY();
       y = y+2;
       r3.setY(y);
       
           em.getTransaction().begin();//crear
                  
            em.persist(r3);
           
           
  
            em.getTransaction().commit();
     
        
        em.close();
        emf.close();
        
    }
    
}
