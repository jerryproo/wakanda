import cn.hutool.core.lang.Console;
import com.jerrypro.SysApplication;
import com.jerrypro.enums.MyAnniversaryEnum;
import com.jerrypro.service.MyAnniversaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author jerrypro
 * @date 2021/7/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysApplication.class)
public class BaseTest {
    @Resource
    private MyAnniversaryService myAnniversaryService;

    @Test
    public void test() {
        Console.log(myAnniversaryService.getByCode(MyAnniversaryEnum.FIRST_DAY.getCode()));
    }
}
