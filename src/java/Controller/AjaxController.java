
package Controller;

import Dao.RatingsDao;
import Dao.UserDao;
import Model.Stats;
import Model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class AjaxController {

    @Autowired
    private UserDao usrd;

    @Autowired
    private RatingsDao ratingDao;

    @RequestMapping(value = "/find.htm", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String filterusers(ModelMap model, @RequestParam(value = "texts") String name) throws JsonProcessingException {
        List<User> us = usrd.check(name);
        ObjectMapper mapper = new ObjectMapper();
        System.out.print(mapper.writeValueAsString(us));
        return mapper.writeValueAsString(us);
    }

    @RequestMapping(value = "/findAvaliablePlayersForThisGameByRest.htm", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String findAvaliablePlayersForThisGame(@RequestParam(value = "courtReservationId") int courtReservationID) throws JsonProcessingException {

        List<Stats> getAvailablePlayersForGame = ratingDao.getAvalialbePlayersForGame(courtReservationID);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(getAvailablePlayersForGame);

    }
    @RequestMapping(value = "/findplayersalreadyinvited.htm", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String findplayersalreadyinvited (@RequestParam(value = "courtReservationId") int courtReservationID) throws JsonProcessingException {

        List<Stats> getInvitedPlayersforGame = ratingDao.getInvitedPlayersforGame(courtReservationID);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(getInvitedPlayersforGame);

    }
    
    @RequestMapping(value = "/findPlayersnotyetReviewed.htm", method = RequestMethod.GET, headers = "Accept=*/*", produces = "application/json")
    public @ResponseBody
    String playersnotyetreviewed (@RequestParam(value = "courtReservationId") int courtReservationID)throws JsonProcessingException {

        List<User> getPlayersnotyetReviewed = ratingDao.getPlayersnotyetReviewed( courtReservationID);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(getPlayersnotyetReviewed);

    }
    
    
    

    @RequestMapping(value = "/fileUpload.htm", method = RequestMethod.POST)
    public ResponseEntity<String> fileUpload(@RequestParam("img") MultipartFile file, String filename, HttpSession session)
            throws IOException {
        // Save file on system
        User user = (User) session.getAttribute("user");
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(new File("C:\\Tomcat 8.5\\webapps\\images", user.getUsername()+".jpg"))); //(path,name)
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
        } else {
            return new ResponseEntity<>("Invalid file.", HttpStatus.BAD_REQUEST);
        }
usrd.updatepic(user.getUserId(), user.getUsername());
        return new ResponseEntity<>("File Uploaded Successfully.", HttpStatus.OK);
    }
}
