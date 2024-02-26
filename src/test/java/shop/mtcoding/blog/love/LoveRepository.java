package shop.mtcoding.blog.love;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(LoveRepository.class)
@DataJpaTest
public class LoveRepository {
    @Autowired
    private LoveRepository loveRepository;
    @Test
    public void findLove_test(){
        //
        int boardId = 9;
        int sessionUserId = 1;
        //
    }
}
