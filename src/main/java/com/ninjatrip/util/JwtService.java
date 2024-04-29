package com.ninjatrip.util;

import com.ninjatrip.user.dto.Token;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

import static com.ninjatrip.config.secret.Secret.JWT_SECRET_KEY;

@Service
public class JwtService {
    public String createJwt(int userIdx, long option) {
        Date now = new Date();
        // HS256 : HMAC SHA256 해싱 알고리즘 사용 - key : JWT_SECRET_KEY
        // base64 로 인코딩
        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .claim("userIdx", userIdx)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + option))
                .signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY)
                .compact();
    }

    public String createAccessToken(int userIdx) {
        long tokenInValidTime = 1000L * 60 * 60 * 12;  // 12 hour
        return this.createJwt(userIdx, tokenInValidTime);
    }

    public String getJwt(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("X-ACCESS-TOKEN");
    }

    public int getUserIdx() {
        // header에서 "X-ACCESS-TOKEN"을 통해 토큰을 가져옴
        String accessToken = getJwt();

        if(accessToken == null || accessToken.length() == 0){
            return 0;
        }

        Token token = new Token();
        token.setAccessToken(accessToken);

        // 토큰 유효성 검사
        if(validateAccessToken(token)) {
            Jws<Claims> claims;
            try{
                claims = Jwts.parser()
                        .setSigningKey(JWT_SECRET_KEY)
                        .parseClaimsJws(accessToken);
            } catch (Exception e) {
                return 0;
            }
            token.setUserIdx(claims.getBody().get("userIdx",Integer.class)); // jwt 에서 userIdx를 추출
        } else if(!validateAccessToken(token)) {
            return 0;
        }

        return token.getUserIdx();
    }

    // 토큰 만료 : 로그아웃 구현 시 사용할 것
    public Long getExpiration(String accessToken) {
        Date expiration = Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(accessToken)
                .getBody()
                .getExpiration();
        Long now = new Date().getTime();
        return (expiration.getTime() - now);
    }

    // refresh token을 사용할 때 사용
    public String reIssueAccessToken(Token token) {
        return createAccessToken(token.getUserIdx());
    }

    public boolean validateAccessToken(Token token) {
        try {
            // jwt parsing (access token)
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(JWT_SECRET_KEY)
                    .parseClaimsJws(token.getAccessToken());
            return !claims.getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            return false;
        }
    }

}
