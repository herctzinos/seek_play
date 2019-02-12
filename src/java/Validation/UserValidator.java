
package Validation;

import Dao.UserDao;
import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean supports(Class<?> type) {
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User u = (User) o;
        String username = u.getUsername().trim();

        if (userDao.checkUserByUsername(username) != null) {
            errors.rejectValue("username", "username.Exists");
        }

        String password = u.getPassword();
        if (password.length() < 4) {
            errors.rejectValue("password", "pwd.Short");
        }
        String password_confirmation = u.getPassword_confirmation();
        if (!password.equals(password_confirmation)) {
            errors.rejectValue("password_confirmation", "pwds.NotMatch");
        }

        char[] chars = u.getUsername().toCharArray();
        for (char ch : chars) {

            if (Character.isWhitespace(ch)) {
                errors.rejectValue("username", "username.WhiteSpace");
            }

            if (ch == '\\') {
                errors.rejectValue("username", "username.SpecChar1");
            }
            //if we have time, better sanitarization. maybe using regex.

        }

    }

}
