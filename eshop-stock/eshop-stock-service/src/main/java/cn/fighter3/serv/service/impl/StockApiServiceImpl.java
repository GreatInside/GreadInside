package cn.fighter3.serv.service.impl;

import cn.fighter3.api.model.StockUpdateDTO;
import cn.fighter3.api.rpc.StockApiService;
import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.serv.mapper.ShopStockMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import cn.fighter3.serv.entity.ShopStock;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 三分恶
 * @Date 2021/11/14
 * @Description 库存服务提供RPC接口实现类
 */
@org.apache.dubbo.config.annotation.Service
//(cluster = "failfast",loadbalance = "roundrobin")
@Slf4j
public class StockApiServiceImpl implements StockApiService {
    @Autowired
    private ShopStockMapper stockMapper;

    /**
     * 添加库存
     *
     * @param stockAddDTO
     * @return
     */
    @Override
    public Integer addStock(StockAddDTO stockAddDTO) {
        ShopStock stock = new ShopStock();
        stock.setGoodsId(stockAddDTO.getGoodsId());
        stock.setInventory(stockAddDTO.getAccount());
        log.info("准备添加库存,参数:{}", stock.toString());
        this.stockMapper.insert(stock);
        Integer stockId = stock.getStockId();
        log.info("添加库存成功,stockId:{}", stockId);
        return stockId;
    }

    /**
     * 获取库存数量
     *
     * @param goodsId
     * @return
     */
    @Override
    public Integer getAccountById(Integer goodsId) {
        //QueryWrapper<ShopStock> queryWrapper = new QueryWrapper();
        //queryWrapper.select("inventory").eq("goods_id", goodsId);
        //ShopStock stock = this.stockMapper.selectOne(Wrappers.<ShopStock>lambdaQuery().eq(ShopStock::getGoodsId, goodsId));

        LambdaQueryWrapper<ShopStock> eq = Wrappers.<ShopStock>lambdaQuery().eq(ShopStock::getGoodsId, goodsId);
        ShopStock stock = this.stockMapper.selectOne(eq);
        return stock.getInventory();
    }

    /**
     * 删除库存
     *
     * @param goodsId
     * @return
     */
    @Override
    public Integer deleteById(Integer goodsId) {
        Map<String, Object> map = new HashMap<>();
        map.put("goods_id", goodsId);
        return stockMapper.deleteByMap(map);
    }

    /**
     * 修改库存量
     *
     * @param stockUpdateDTO
     * @return
     */
    @Override
    public Integer updateById(StockUpdateDTO stockUpdateDTO) {
        ShopStock shopStock = new ShopStock();
        BeanUtils.copyProperties(stockUpdateDTO, shopStock);
        log.info("准备修改库存,参数:{}", shopStock.toString());
        LambdaQueryWrapper<ShopStock> eq = Wrappers.<ShopStock>lambdaQuery().eq(ShopStock::getGoodsId, shopStock.getGoodsId());
        return stockMapper.update(shopStock, eq);
    }
}
