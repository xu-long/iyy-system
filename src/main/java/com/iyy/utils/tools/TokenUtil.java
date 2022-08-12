package com.iyy.utils.tools;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.iyy.entity.User;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/8 3:23 下午
 */
public class TokenUtil {

    //设置过期时间
    private static final long EXPIRE_DATE = 1000 * 60 * 60 * 12;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCEQIUBFKSJBFJH2020BQWE";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String createToken(User user){
        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("userId",user.getUserId())
                    .withClaim("userName",user.getUserName())
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken token字符串
     * @return 如果token有效返回true，否则返回false
     */
    public static boolean checkToken(String jwtToken) {
        if(StrUtil.isEmpty(jwtToken)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request Http请求对象
     * @return 如果token有效返回true，否则返回false
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            // 从http请求头中获取token字符串
            String jwtToken = request.getHeader("Access-Token");
            if(StrUtil.isEmpty(jwtToken)){
                return false;
            }
            Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
