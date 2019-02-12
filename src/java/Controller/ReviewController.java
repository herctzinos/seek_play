
package Controller;

import Dao.ReviewDao;
import Dao.CourtReservationDao;
import Dao.GameRequestDao;
import Dao.RatingDao;

import Dao.UserDao;
import Model.GameRequest;
import Model.Ratings;
import Model.Review;
import Model.Stats;
import Model.User;
import Validation.ReviewValidator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReviewController {

    @Autowired
    private RatingDao ratingDAO;
    @Autowired
    ServletContext servletContext;

    @Autowired
    private UserDao userDao;

    @Autowired
    private GameRequestDao gameRequestDao;

    @Autowired
    private CourtReservationDao courtReservationDao;

    @Autowired
    private ReviewDao reviewDao;

    @Autowired
    private ReviewValidator reviewValidator;

    @RequestMapping(value = "/goToReviewForm.htm", method = RequestMethod.GET)
    public String createReviewForm(ModelMap model, HttpSession session) {
        User me = (User) session.getAttribute("user");
        List<GameRequest> pendingReviewList = reviewDao.listUsersForReview(me.getUserId());
        model.addAttribute("users", me);

        if (!pendingReviewList.isEmpty()) {
            model.addAttribute("pendingReviewList", pendingReviewList);
            Review review = new Review();
            List<String> Grades = new ArrayList<>();
            Grades.add("1");
            Grades.add("2");
            Grades.add("3");
            Grades.add("4");
            Grades.add("5");
            Grades.add("6");
            Grades.add("7");
            Grades.add("8");
            Grades.add("9");
            Grades.add("10");

            servletContext.setAttribute("Grades", Grades);
            model.addAttribute("review", review);

            return "reviews";
        } else {
            model.addAttribute("review1", "No users to review!");
        }

        return "reviews";
    }

    @RequestMapping(value = "/reviewFormHandling.htm", method = RequestMethod.POST)
    public String reviewFormHandler(@ModelAttribute Review review, HttpSession session, ModelMap model, @RequestParam String gameRequestId, BindingResult bindingResult) {
        if (gameRequestId.equals("")) {
            String errorMessage = "You did not choose a player for evaluation.";

            model.addAttribute("review", review);
            model.addAttribute("gameRequestIDError", errorMessage);
            return "reviews";
        }
        GameRequest gameRequest = gameRequestDao.getGameRequestById(gameRequestId);

        review.setMatch(gameRequest.getMatch());

        User me = (User) session.getAttribute("user");
        review.setReviewer(me);
        User reviewed = gameRequest.getRequestReceiver();
        review.setReviewed(reviewed);

        reviewValidator.validate(review, bindingResult);

        if (bindingResult.hasErrors()) {
            List<GameRequest> pendingReviewList = reviewDao.listUsersForReview(me.getUserId());
            model.addAttribute("pendingReviewList", pendingReviewList);
            model.addAttribute("review", review);
            return "reviews";
        }

        reviewDao.insert(review);
        //check how redirect works
//        review = new Review();
//        model.addAttribute("review", review);
//
//        List<GameRequest> pendingReviewList = reviewDao.listUsersForReview(reviewer.getUserId());
//        model.addAttribute("pendingReviewList", pendingReviewList);

        return "redirect:/goToReviewForm.htm";
    }

    @RequestMapping(value = "/star.htm", method = RequestMethod.GET)
    public String starnew(ModelMap model, User u, HttpSession session) throws IOException {
        User user = (User) session.getAttribute("user");
        Ratings r = new Ratings();
        r.setPlayer(user.getUserId());
        int id = r.getPlayer();

        model.addAttribute("users", user);

        List<Stats> stats = ratingDAO.Status(id);
        BigDecimal teamwork = new BigDecimal(0);
        BigDecimal technique = new BigDecimal(0);
        BigDecimal athletism = new BigDecimal(0);
        BigDecimal overall = new BigDecimal(0);
        BigDecimal grade = new BigDecimal(0);
        if (!stats.isEmpty()) {
            teamwork = stats.get(0).getTeamwork().multiply(new BigDecimal(10));
            technique = stats.get(0).getTechnique().multiply(new BigDecimal(10));
            athletism = stats.get(0).getAthletism().multiply(new BigDecimal(10));
            overall = ((athletism.add(technique).add(teamwork)).divide(new BigDecimal(3), 2, RoundingMode.HALF_UP));
            grade = (overall.divide(new BigDecimal(20))).setScale(2, RoundingMode.CEILING);
            servletContext.setAttribute("team", teamwork);
            servletContext.setAttribute("athlet", athletism);
            servletContext.setAttribute("tech", technique);
            servletContext.setAttribute("star", grade);
            servletContext.setAttribute("overall", overall);
        } else {
            model.addAttribute("myReviewsEmpty", "You have never been reviewed!");
        }

        return "starpage";
    }

    @RequestMapping(value = "/myreviews.htm", method = RequestMethod.GET)
    public String myreviewnew(ModelMap model, HttpSession session) throws IOException {

        User me = (User) session.getAttribute("user");
        model.addAttribute("users", me);

        List<Review> myReviewsList = reviewDao.listMyReviews(me);
        if (!myReviewsList.isEmpty()) {
            model.addAttribute("myReviews", myReviewsList);
        } else {
            model.addAttribute("myReviewsEmpty", "You have never been reviewed!");
        }

        return "myreviewspage";
    }

    @RequestMapping(value = "/others.htm", method = RequestMethod.GET)
    public String othersnew(ModelMap model, HttpSession session) throws IOException {
        User me = (User) session.getAttribute("user");
        model.addAttribute("users", me);

        List<Review> OthersReviewsList = reviewDao.listOthersReviews(me);
        if (!OthersReviewsList.isEmpty()) {
            model.addAttribute("othersReviews", OthersReviewsList);

        } else {
            model.addAttribute("othersReviewsEmpty", "You have never made any review!");
        }
        return "othersreviewpage";
    }

}
