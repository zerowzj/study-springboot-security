package study.springboot.security.auth.session;

import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomInvalidSessionStrategy implements InvalidSessionStrategy {

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request,
                                         HttpServletResponse response) throws IOException, ServletException {

    }
}
