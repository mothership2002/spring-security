package hello.security.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

@Configuration
@Setter
@Getter
@ConfigurationProperties("jwt")
public class JwtProperties {

    private String header;
    private String secretKey;
    private int expiredDate;

    private long expiredSecond;

    @PostConstruct
    public void init() {
        expiredSecond = toSecond(expiredDate);
    }

    private int toSecond(int expiredDate) {
        return expiredDate * 24 * 60 * 60;
    }

}
