package org.example.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 扩展token获取方式
 * <p>支持获取请求url上的token，实例http://localhost/a?access_token=xxxxxxxxxxx</p>
 * @see BearerTokenExtractor
 * @see com/hrt/uaac/config/Oauth2ResourceServerConfig
 */
public class MyBearerTokenExtractor implements TokenExtractor {
    private static final Log logger = LogFactory.getLog(BearerTokenExtractor.class);

    public MyBearerTokenExtractor() {
    }

    public Authentication extract(HttpServletRequest request) {
        String tokenValue = this.extractToken(request);
        if (tokenValue != null) {
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(tokenValue, "");
            return authentication;
        } else {
            return null;
        }
    }

    protected String extractToken(HttpServletRequest request) {
        String token = this.extractHeaderToken(request);
        if (token == null) {
            token = this.extractRequestToken(request);
        }
        if (token == null) {
            logger.debug("Token not found in headers. Trying request parameters.");
            token = request.getParameter("access_token");
            if (token == null) {
                logger.debug("Token not found in request parameters.  Not an OAuth2 request.");
            } else {
                request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, "Bearer");
            }
        }

        return token;
    }

    protected String extractHeaderToken(HttpServletRequest request) {
        Enumeration headers = request.getHeaders("Authorization");

        String value;
        do {
            if (!headers.hasMoreElements()) {
                return null;
            }

            value = (String) headers.nextElement();
        } while (!value.toLowerCase().startsWith("Bearer".toLowerCase()));

        String authHeaderValue = value.substring("Bearer".length()).trim();
        request.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE, value.substring(0, "Bearer".length()).trim());
        int commaIndex = authHeaderValue.indexOf(44);
        if (commaIndex > 0) {
            authHeaderValue = authHeaderValue.substring(0, commaIndex);
        }

        return authHeaderValue;
    }

    protected String extractRequestToken(HttpServletRequest request) {
        return request.getParameter(SecurityConstants.DEFAULT_TOKEN_REQUEST_PARAM);
    }
}
