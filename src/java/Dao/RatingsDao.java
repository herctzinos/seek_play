
package Dao;

import Model.CourtReservation;
import Model.Stats;
import Model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class RatingsDao {

    @PersistenceContext
    private EntityManager em;

    public List<Stats> getAvalialbePlayersForGame(int id) {

        List<CourtReservation> reservation = em.createQuery("SELECT c FROM CourtReservation c WHERE c.courtReservationID = :courtReservationID", CourtReservation.class).setParameter("courtReservationID", id).getResultList();

        String sql1 = "SELECT * FROM Stats where player not in (select game_request.request_receiver from game_request  where\n"
                + "game_request.match \n"
                + " in(Select court_reservation.CourtReservationID from court_reservation where court_reservation.date='" + reservation.get(0).getDate() + "' and court_reservation.hours='" + reservation.get(0).getHours().getHoursId() + "' and booker='" + reservation.get(0).getBooker().getUserId() + "')) \n"
                + " and player not in (Select booker from court_reservation where  court_reservation.date='" + reservation.get(0).getDate() + "' and court_reservation.hours='" + reservation.get(0).getHours().getHoursId() + "' )  \n"
                + " and player not in(select game_request.request_receiver from game_request where game_request.status='yes' and\n"
                + "game_request.match in(Select court_reservation.CourtReservationID from court_reservation where !court_reservation.date='" + reservation.get(0).getDate() + "' and !court_reservation.hours='" + reservation.get(0).getHours().getHoursId() + "'))";

        Query q2 = em.createNativeQuery(sql1, Stats.class);
        List<Stats> players = q2.getResultList();
        return players;
    }

    public List<User> getPlayersnotyetReviewed(int id) {

        List<CourtReservation> reservation = em.createQuery("SELECT c FROM CourtReservation c WHERE c.courtReservationID = :courtReservationID", CourtReservation.class).setParameter("courtReservationID", id).getResultList();
        String sql2 = "SELECT * FROM user where user_id not in (select game_request.request_receiver from game_request  where\n"
                + "game_request.match\n"
                + "in(Select court_reservation.CourtReservationID from court_reservation where court_reservation.date='" + reservation.get(0).getDate() + "' and court_reservation.hours='" + reservation.get(0).getHours().getHoursId() + "' and booker='" + reservation.get(0).getBooker().getUserId() + "'))\n"
                + "and user_id not in (Select booker from court_reservation where  court_reservation.date='" + reservation.get(0).getDate() + "' and court_reservation.hours='" + reservation.get(0).getHours().getHoursId() + "' )\n"
                + "and user_id not in(select game_request.request_receiver from game_request where game_request.status='yes' and\n"
                + "game_request.match in(Select court_reservation.CourtReservationID from court_reservation where !court_reservation.date='" + reservation.get(0).getDate() + "' and !court_reservation.hours='" + reservation.get(0).getBooker().getUserId() + "'))\n"
                + "and user_id not in (Select Player from Stats);";

        Query q1 = em.createNativeQuery(sql2, User.class);
        List<User> players = q1.getResultList();
        return players;

    }

    public List<Stats> getInvitedPlayersforGame(int id) {

        List<CourtReservation> reservation = em.createQuery("SELECT c FROM CourtReservation c WHERE c.courtReservationID = :courtReservationID", CourtReservation.class).setParameter("courtReservationID", id).getResultList();

        String sql2 = "SELECT * from Stats where Player in\n"
                + "(select game_request.request_receiver from game_request inner join court_reservation on CourtReservationID=game_request.match \n"
                + "where (court_reservation.date='" + reservation.get(0).getDate() + "' and court_reservation.hours='" + reservation.get(0).getHours().getHoursId()
                + "' AND court_reservation.booker='" + reservation.get(0).getBooker().getUserId() + "'));";

        Query q1 = em.createNativeQuery(sql2, Stats.class);
        List<Stats> players = q1.getResultList();
        return players;

    }

}
