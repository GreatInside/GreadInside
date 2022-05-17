package cn.fighter3.serv.service.impl;

import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.api.model.StockUpdateDTO;
import cn.fighter3.api.rpc.StockApiService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 三分恶
 * @Date 2021/11/14
 * @Description 库存服务降级兜底类
 */
@Slf4j
public class MockStockApiServiceImpl implements StockApiService {

    @Override
    public Integer addStock(StockAddDTO stockAddDTO) {
        log.error("库存服务添加库存接口调用失败！");
        return 0;
    }

    @Override
    public Integer getAccountById(Integer goodsId) {
        log.error("库存服务获取库存接口调用失败！");
        return 0;
    }

    @Override
    public Integer deleteById(Integer goodsId) {
        log.error("库存服务获取库存接口调用失败！");
        return 0;
    }

    @Override
    public Integer updateById(StockUpdateDTO stockUpdateDTO) {
        log.error("库存服务获取库存接口调用失败！");
        return 0;
    }
}
