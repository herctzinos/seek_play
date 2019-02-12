
package Filter;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        
        String loginURI = request.getContextPath() + "/index.htm";
        String logingURI = request.getContextPath() + "/loginFormHandling.htm";
        String registerURI = request.getContextPath() + "/goToRegisterForm.htm";
        String registeringURI = request.getContextPath() + "/registerFormHandling.htm";
        String loginKarouselPictureURI = request.getContextPath() + "/resources/banner.jpg";
        String loginKarouselPictureURI1 = request.getContextPath() + "/resources/soccer.jpg";
        String loginKarouselPictureURI2 = request.getContextPath() + "/resources/logo.jpg";
        String loginKarouselPictureURI3 = request.getContextPath() + "/resources/tennis.jpg";
        String loginKarouselPictureURI4 = request.getContextPath() + "/resources/giannis.jpg";
        String javascriptFile = request.getContextPath() + "/resources/newjavascript.js";
        String cssFile = request.getContextPath() + "/resources/newcss2.css";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean logingRequest = request.getRequestURI().equals(logingURI);
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean registerRequest = request.getRequestURI().equals(registerURI);
        boolean registeringRequest = request.getRequestURI().equals(registeringURI);
        boolean loginKarouselPictureURIRequest = request.getRequestURI().equals(loginKarouselPictureURI);
        boolean loginKarouselPictureURI1Request = request.getRequestURI().equals(loginKarouselPictureURI1);
        boolean loginKarouselPictureURI2Request = request.getRequestURI().equals(loginKarouselPictureURI2);
        boolean loginKarouselPictureURI3Request = request.getRequestURI().equals(loginKarouselPictureURI3);
        boolean loginKarouselPictureURI4Request = request.getRequestURI().equals(loginKarouselPictureURI4);
        boolean javascriptFileRequest = request.getRequestURI().equals(javascriptFile);
        boolean cssFileRequest = request.getRequestURI().equals(cssFile);
        System.out.println(new Date() + "URI:" + request.getRequestURI());

        if (loggedIn || loginRequest || logingRequest || registerRequest || registeringRequest || loginKarouselPictureURIRequest || loginKarouselPictureURI1Request || loginKarouselPictureURI2Request || loginKarouselPictureURI3Request || loginKarouselPictureURI4Request || javascriptFileRequest || cssFileRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }

}
