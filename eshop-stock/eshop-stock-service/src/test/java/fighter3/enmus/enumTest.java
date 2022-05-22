package fighter3.enmus;

import cn.fighter3.serv.enums.Sex;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class enumTest {
    @Test
    public void test(){
        Sex male = Sex.MALE;
        System.out.println(male);
    }
}
