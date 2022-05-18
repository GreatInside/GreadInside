package fighter3;


import cn.fighter3.serv.entity.ShopStock;
import cn.fighter3.serv.mapper.ShopStockMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    ShopStockMapper shopStockMapper;

    @Test
    public List<ShopStock> getPage() {
        Page<ShopStock> stockPage = new Page<>(1, 3);
        Page<ShopStock> stockPage1 = shopStockMapper.selectPage(stockPage, null);
        List<ShopStock> records = stockPage1.getRecords();
        return records;
    }
}
