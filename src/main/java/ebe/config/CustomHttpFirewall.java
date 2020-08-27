package ebe.config;

import org.springframework.security.web.firewall.DefaultHttpFirewall;

public class CustomHttpFirewall extends DefaultHttpFirewall {
    CustomHttpFirewall() {
        setAllowUrlEncodedSlash(true);
    }
}

