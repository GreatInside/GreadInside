package cn.fighter3.serv.service;

import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.serv.entity.ShopStock;
import cn.fighter3.serv.api.result.CommonResult;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 三分恶
 * @since 2021-05-18
 */
public interface IShopStockService extends IService<ShopStock> {

    /**
     * 添加
     *
     * @param stockAddDTO
     * @return
     */
    CommonResult addStock(StockAddDTO stockAddDTO);

}
