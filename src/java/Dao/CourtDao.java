
package Dao;

import Model.Court;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class CourtDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insert(Court court) {

        em.persist(court);

    }

    public List<Court> listAllCourts() {
        Query query = em.createNamedQuery("Court.findAll", Court.class);
        List<Court> resultList = query.getResultList();
        return resultList;
    }
    
    
  

}
