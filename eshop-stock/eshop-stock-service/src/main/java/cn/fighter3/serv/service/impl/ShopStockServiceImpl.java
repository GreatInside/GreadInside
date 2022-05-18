package cn.fighter3.serv.service.impl;

import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.serv.entity.ShopStock;
import cn.fighter3.serv.mapper.ShopStockMapper;
import cn.fighter3.serv.api.result.CommonResult;

import cn.fighter3.serv.service.IShopStockService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 三分恶
 * @since 2021-05-18
 */
@Service
@Slf4j
public class ShopStockServiceImpl extends ServiceImpl<ShopStockMapper, ShopStock> implements IShopStockService {

    /**
     * 添加库存-返回统一结果集
     *
     * @param stockAddDTO
     * @return
     */
    public CommonResult addStock(StockAddDTO stockAddDTO) {
        ShopStock stock = new ShopStock();
        stock.setGoodsId(stockAddDTO.getGoodsId());
        stock.setInventory(stockAddDTO.getAccount());
        log.info("prepare add stock,param:{}", stock.toString());
        Integer stockId = this.baseMapper.insert(stock);
        log.info("add stock successfully,stockId:{}", stockId);
        return CommonResult.ok(stockId);
    }

    /**
     * 分页获取所以库存量
     *
     * @return
     */
    @Override
    public List<ShopStock> getPage() {
        Page<ShopStock> stockPage = new Page<>(1, 3);
        Page<ShopStock> stockPage1 = this.baseMapper.selectPage(stockPage, null);
        List<ShopStock> records = stockPage1.getRecords();
        return records;
    }
}
