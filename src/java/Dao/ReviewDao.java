
package Dao;

import Model.GameRequest;
import Model.Review;
import Model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class ReviewDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insert(Review review) {

        String sql = "INSERT INTO review (`match`, reviewer, reviewed, teamwork, athletism, technique, comments)"
                + " VALUES(" + review.getMatch().getCourtReservationID() + ", "
                + "" + review.getReviewer().getUserId() + ", "
                + "" + review.getReviewed().getUserId() + ", "
                + "" + review.getTeamwork() + ", "
                + "" + review.getAthletism() + ", "
                + "" + review.getTechnique() + ", "
                + "'" + review.getComments() + "')";
        Query query = em.createNativeQuery(sql);

        query.executeUpdate();

        // em.persist(review);
    }

    public List<GameRequest> listUsersForReview(int userId) {
        String SQL = "SELECT * FROM game_request  inner join court_reservation on game_request.match=court_reservation.CourtReservationID where  game_request.request_receiver not in(Select reviewed from review where review.match=court_reservation.CourtReservationID and review.reviewer=" + userId + ") and game_request.status='yes' and court_reservation.booker=" + userId + " and court_reservation.date<current_date();";
        Query query = em.createNativeQuery(SQL, GameRequest.class);
        List<GameRequest> resultList = query.getResultList();
        return resultList;
    }

    public List<Review> listMyReviews(User me) {

        String SQL = "SELECT * FROM review WHERE reviewed='" + me.getUserId() + "';";
        Query query = em.createNativeQuery(SQL, Review.class);
        List<Review> resultList = query.getResultList();
        return resultList;

    }

    public List<Review> listOthersReviews(User me) {
        String SQL = "SELECT * FROM review WHERE reviewer='" + me.getUserId() + "';";
        Query query = em.createNativeQuery(SQL, Review.class);
        List<Review> resultList = query.getResultList();
        return resultList;

    }

}
