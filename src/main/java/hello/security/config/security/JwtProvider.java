package hello.security.config.security;

import hello.security.config.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties properties;

    private Key key;

    @PostConstruct
    public void init() {
        byte[] keyBytes = properties.getSecretKey().getBytes();
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(Authentication authentication) {
        String authorities = authentication.getAuthorities().stream().
                map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiredDate = now.plusSeconds(properties.getExpiredSecond());
        return Jwts.builder()
                .setSubject("auth")
                .

    }
}
