package shop.mtcoding.blog._core.util;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class BCrpytTest {
    @Test
    public void gensalt_test(){
        String salt = BCrypt.gensalt();
        System.out.println(salt);
        //1. $2a$10$U0j5FeurvgHddzahQt7cBu
        //2. $2a$10$hJVFHp7bRZ2lYn6/EPHlAu
        //3. $2a$10$aLFuodzsUXCZiF1WsppBve
    }
    @Test
    public void hashpw_test(){
        String rawPassword = "1234";
        String encPassword = BCrypt.hashpw(rawPassword, BCrypt.gensalt());
        System.out.println(encPassword);
    }
}
