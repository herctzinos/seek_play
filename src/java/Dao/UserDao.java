
package Dao;

import Model.GameRequest;
import Model.User;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void insert(User user) {

        // em.persist(user); gia kapoio logo to default tou image de leitourgei me persist
        em.createNativeQuery("INSERT INTO `seek_play`.`user` (`username`, `firstname`, `lastname`, `image`, `password`) VALUES ('" + user.getUsername() + "', '" + user.getFirstname() + "', '" + user.getLastname() + "', DEFAULT, '" + user.getPassword() + "');", User.class).executeUpdate();

    }

    @Transactional
    public void updatepic(int user_id, String file) throws IOException {
        em.createNativeQuery("Update user SET image='" + file + "'WHERE user_id='" + user_id + "';").executeUpdate();
    }

    @Transactional
    public void updateinfos(String us, String n, String ln) throws IOException {
        //  em.find(User.class,us);
        em.createNativeQuery("Update user SET firstname='" + n + "',lastname='" + ln + "' WHERE username='" + us + "';").executeUpdate();
    }

    @Transactional
    public List<User> check(String s) {
        User u = new User();
        List<User> usr = em.createQuery("SELECT u FROM User u WHERE u.username LIKE CONCAT(:username,'%')", User.class).setParameter("username", s).getResultList();

        return usr;
    }

    @Transactional
    public User profile(String s) {
        User u = new User();
        List<User> usr = em.createQuery("SELECT u from User u WHERE u.username = :username", User.class).setParameter("username", s).getResultList();
        u.setUserId(usr.get(0).getUserId());
        u.setUsername(usr.get(0).getUsername());
        u.setImage(usr.get(0).getImage());
        return u;
    }

    @Transactional
    public int change(String s) {
        int y = Integer.parseInt(s);

        return y;
    }

    @Transactional
    public List<GameRequest> fetchincomingrequests(User request_receiver) {
        List<GameRequest> Conversation;
        String sql = ("sELECT * FROM seek_play.game_request\n"
                + " join court_reservation on `match`=CourtReservationID\n"
                + " join hours h on court_reservation.hours = h.hours_id\n"
                + "join user on game_request.request_receiver = user.user_id\n"
                + "  where request_receiver=(select user_id from user where username='" + request_receiver.getUsername() + "')\n"
                + "and status = 'pending' order by date;");
        Query q = em.createNativeQuery(sql, GameRequest.class);
        Conversation = q.getResultList();

        return Conversation;
    }

    @Transactional
    public List<GameRequest> fetchoutgoingrequests(User requester) {
        List<GameRequest> Conversation;
        Query q = em.createNativeQuery("sELECT * FROM seek_play.game_request\n"
                + " join court_reservation on `match`=CourtReservationID\n"
                + " join hours h on court_reservation.hours = h.hours_id\n"
                + "join user on game_request.request_receiver = user.user_id\n"
                + "  where booker=(select user_id from user where username='" + requester.getUsername() + "') order by date;", GameRequest.class);
    
    
        Conversation = q.getResultList();

        return Conversation;
    }

    @Transactional
    public List<GameRequest> fetchansweredrequests(User request_receiver) {
        List<GameRequest> Conversation;
        Query q = em.createNativeQuery("sELECT * FROM seek_play.game_request\n"
                + " join court_reservation on `match`=CourtReservationID\n"
                + " join hours h on court_reservation.hours = h.hours_id\n"
                + "join user on game_request.request_receiver = user.user_id\n"
                + "  where request_receiver=(select user_id from user where username='" + request_receiver.getUsername() + "')\n"
                + "and not status = 'pending' order by date;", GameRequest.class);
        Conversation = q.getResultList();

        return Conversation;
    }

    @Transactional
    public void submitaccept(String id) {

        String sql = "UPDATE `seek_play`.`game_request` t SET t.`status` = 'yes' WHERE t.`id` =" + id + ";";
        int q1 = em.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public void submitdeny(String id) {

        String sql = "UPDATE `seek_play`.`game_request` t SET t.`status` = 'no' WHERE t.`id` =" + id + ";";
        int q1 = em.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public User checkUserByUsername(String username) {
        List<User> userList = em.createQuery(
                "SELECT u from User u WHERE u.username = :username", User.class).
                setParameter("username", username).getResultList();
        if (userList.size() == 1) {
            User user = userList.get(0);
            return user;
        } else {
            return null;
        }

    }

    public List<User> listAllUsers() {
        Query query = em.createNamedQuery("User.findAll", User.class);
        List<User> resultList = query.getResultList();
        return resultList;
    }

}
