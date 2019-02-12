
package Dao;

import Model.GameRequest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class GameRequestDao {

    @PersistenceContext
    private EntityManager em;

    public GameRequest getGameRequestById(String gameRequestId) {

        GameRequest gameRequest = em.find(GameRequest.class, Integer.parseInt(gameRequestId));
        return gameRequest;
    }
    
    @Transactional
    public void sendRequest(int senderid, String receiver, String game) {

//        String sql = "";
//        Query query = em.createNativeQuery(sql);
//
//  Query q=em.createNativeQuery("Select CourtReservationID from court_reservation where court_id='"+Court+"' and hours='"+hour+"' and  date='"+date+"'");
//  int id=(int) q.getSingleResult();
        String sql = ("INSERT INTO `seek_play`.`game_request` (`match`, `request_id`, `request_receiver`, `status`, `text`) VALUES ("+game+", '1', "+receiver+", DEFAULT, 'NULL');");
        em.createNativeQuery(sql, GameRequest.class).executeUpdate();

    }

}
