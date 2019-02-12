
package Dao;

import Model.Ratings;
import Model.Stats;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class RatingDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Stats> Status(int id) {
        //em.find(Ratings.class, id);
        Ratings r = new Ratings();
        List<Stats> stats = em.createQuery("SELECT s FROM Stats s WHERE Player = :id", Stats.class).setParameter("id", id)
                .getResultList();
             return stats;
    }
}
