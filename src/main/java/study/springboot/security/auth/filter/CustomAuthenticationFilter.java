package study.springboot.security.auth.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private String captchaParameter = "authCode";

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //获取验证码
        String inputCaptcha = this.obtainCaptcha(request);
        //验证
        String captchaKey = this.getCaptchaKey(request);
        /*boolean flag = imageCaptchaService.validateResponseForID(captchaKey, inputCaptcha);
        if (!flag){
            throw new CaptchaException("验证码错误");
        }*/
        //
        return super.attemptAuthentication(request, response);
    }

    protected String obtainCaptcha(HttpServletRequest request) {
        return request.getParameter(this.captchaParameter);
    }

    private String getCaptchaKey(HttpServletRequest request){
        Cookie[]  cookies = request.getCookies();
        String value = null;
        for(Cookie cookie : cookies){
            String cookieName = cookie.getName();
            if ("captcha_key".equals(cookieName)){
                value = cookie.getValue();
                break;
            }
        }
        return value;
    }
}
