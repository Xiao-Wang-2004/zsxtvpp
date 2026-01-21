package com.wang.zsxt.tool;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 */
public class JwtUtil {

    // JWT签名密钥，实际项目中应该从配置文件读取
    public static final String JWT_KEY = "ZSXT_JWT_SECRET_KEY_2024_FOR_TOKEN_GENERATION";

    /**
     * 生成JWT Token
     *
     * @param subject 用户信息（如用户名）
     * @param ttlMillis 过期时间（毫秒）
     * @return JWT Token
     */
    public static String createToken(String subject, Long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        
        // 使用Base64编码密钥
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(JWT_KEY.getBytes());
        SecretKey signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setId(UUID.randomUUID().toString()) // 设置唯一ID
                .setSubject(subject) // 设置用户信息
                .setIssuedAt(now) // 设置签发时间
                .signWith(signatureAlgorithm, signingKey); // 设置签名算法和密钥

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp); // 设置过期时间
        }

        return builder.compact();
    }

    /**
     * 生成默认过期时间的Token（2小时）
     *
     * @param subject 用户信息
     * @return JWT Token
     */
    public static String createToken(String subject) {
        return createToken(subject, 20000 * 60 * 60 * 1000L); // 默认2小时过期
    }

    /**
     * 解析JWT Token
     *
     * @param token JWT Token
     * @return Claims对象
     */
    public static Claims parseToken(String token) {
        // 使用Base64编码密钥
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(JWT_KEY.getBytes());
        SecretKey signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

        return Jwts.parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 验证JWT Token是否有效
     *
     * @param token JWT Token
     * @return 是否有效
     */
    public static boolean validateToken(String token) {
        try {
            // 使用Base64编码密钥
            byte[] apiKeySecretBytes = Base64.getEncoder().encode(JWT_KEY.getBytes());
            SecretKey signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

            Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | IllegalArgumentException e) {
            return false;
        }
    }
}