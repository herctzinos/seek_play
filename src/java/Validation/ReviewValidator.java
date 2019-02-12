
package Validation;

import Dao.ReviewDao;
import Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ReviewValidator implements Validator {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public boolean supports(Class<?> type) {
        return Review.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Review review = (Review) o;
      
        
        if (review.getTeamwork() == null) {

            errors.rejectValue("teamwork", "teamwork.Null");
        }
       
        if (review.getAthletism() == null) {

            errors.rejectValue("athletism", "athletism.Null");
        }
         if (review.getTechnique() == null) {

            errors.rejectValue("technique", "technique.Null");
        }
         
    }
}
