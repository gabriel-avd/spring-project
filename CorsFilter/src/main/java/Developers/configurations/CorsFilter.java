package Developers.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    @Value("${access.server.url}")
    private String accessControlAllowOriginValue;
    private String accessControlAllowMethodsValue = "POST,GET,PUT,DELETE,OPTIONS";
    private String accessControlMaxAgeValue = "3600";
    private String accessControlAllowCredentialsValue = "true";
    private String accessControlAllowHeadersValue = "Origin,Accept,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,Access-Control-Allow-Headers, x-requested-with, X-Custom-Header";

    public String getAccessControlAllowOriginValue() {
        return accessControlAllowOriginValue;
    }

    public void setAccessControlAllowOriginValue(String accessControlAllowOriginValue) {
        this.accessControlAllowOriginValue = accessControlAllowOriginValue;
    }

    public String getAccessControlAllowMethodsValue() {
        return accessControlAllowMethodsValue;
    }

    public void setAccessControlAllowMethodsValue(String accessControlAllowMethodsValue) {
        this.accessControlAllowMethodsValue = accessControlAllowMethodsValue;
    }

    public String getAccessControlMaxAgeValue() {
        return accessControlMaxAgeValue;
    }

    public void setAccessControlMaxAgeValue(String accessControlMaxAgeValue) {
        this.accessControlMaxAgeValue = accessControlMaxAgeValue;
    }

    public String getAccessControlAllowCredentialsValue() {
        return accessControlAllowCredentialsValue;
    }

    public void setAccessControlAllowCredentialsValue(String accessControlAllowCredentialsValue) {
        this.accessControlAllowCredentialsValue = accessControlAllowCredentialsValue;
    }

    public String getAccessControlAllowHeadersValue() {
        return accessControlAllowHeadersValue;
    }

    public void setAccessControlAllowHeadersValue(String accessControlAllowHeadersValue) {
        this.accessControlAllowHeadersValue = accessControlAllowHeadersValue;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String method = request.getMethod();

        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, getAccessControlAllowOriginValue());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, getAccessControlAllowMethodsValue());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, getAccessControlMaxAgeValue());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, getAccessControlAllowCredentialsValue());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, getAccessControlAllowHeadersValue());

        String uri = ((HttpServletRequest)request).getServletPath();
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (HttpMethod.OPTIONS.toString().equals(method)||(uri.equals("/")&& session!= null && !session.isNew())) {
            response.setStatus(HttpStatus.OK.value());
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
