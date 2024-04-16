package com.roulette.roulette.myPage;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LoginCheckInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("인증 체크 인터셈터 실행 {}", requestURI);

        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("loginMember") == null){  //loginMember->세션에 저장되어 있는 사용자 정보를 가리키는 속성의미
            // 세션은 사용자가 로그인할때 사용자 정보를 세션에 자동으로 저장한다.
            log.info("미인증 사용자 요청");
            //로그인으로 redirect
            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;    //false는 여기서 그만 하겠다는 말
        }
        return true;
    }
}
