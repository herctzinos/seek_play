
package Dao;

import Model.CourtReservation;
import Model.Hours;
import Model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class CourtReservationDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public CourtReservation checkCourtReservationByID(int id) {
        CourtReservation courtReservation = em.find(CourtReservation.class, id);
        return courtReservation;
    }

    @Transactional
    public List<CourtReservation> getFreeTimeSlots(String date, String courtID) {

        //Query query = em.createNamedQuery("CourtReservation.findAll", CourtReservation.class);
        //Query query2=em.createNativeQuery("SELECT * FROM court_reservation WHERE date='"+date+"'", CourtReservation.class);
        Query query3 = em.createNativeQuery("SELECT * from hours where hours_id not in (SELECT hours FROM court_reservation WHERE date='" + date + "' AND court_id='" + courtID + "') ", Hours.class);

        //Query query1=em.createQuery("SELECT cr FROM CourtReservation cr WHERE cr.date="+date+"", CourtReservation.class);
        List<CourtReservation> resultList = query3.getResultList();
        return resultList;

        /*
      List<User> result=em.createQuery
       ("SELECT u FROM User u WHERE u.username LIKE :name", User.class)
            .setParameter("name", "%")
            .getResultList();
      return result;
         */
    }

    @Transactional
    public void insert(CourtReservation courtReservation) {

        em.persist(courtReservation);

    }

    public List<CourtReservation> showMyActiveEvents(HttpSession session) {
        User me = (User) session.getAttribute("user");
        int myID = me.getUserId();

       // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
     //   String formattedDate = formatter.format(new Date());
        Query query = em.createNativeQuery("SELECT * FROM court_reservation  WHERE date>current_date() and booker=" + "'" + myID + "'" + ";", CourtReservation.class);

        List<CourtReservation> resultList = query.getResultList();
        return resultList;
    }
    
    @Transactional

    public void deleteCourtReservationByID(String id, int userID) {
        Query query = em.createNativeQuery("DELETE FROM court_reservation WHERE CourtReservationID='" + id + "' and booker='"+userID+"';");
        query.executeUpdate();
    }

}
