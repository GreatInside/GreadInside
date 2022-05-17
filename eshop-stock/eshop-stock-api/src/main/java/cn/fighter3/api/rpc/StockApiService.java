package cn.fighter3.api.rpc;


import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.api.model.StockUpdateDTO;

/**
 * @Author 三分恶
 * @Date 2021/11/14
 * @Description 对外RPC接口定义
 */
public interface StockApiService {

    /**
     * 添加库存
     *
     * @param stockAddDTO
     * @return
     */
    Integer addStock(StockAddDTO stockAddDTO);

    /**
     * 根据商品ID获取库存量
     *
     * @param goodsId
     * @return
     */
    Integer getAccountById(Integer goodsId);

    /**
     * 根据商品ID删除库存量
     *
     * @param goodsId
     * @return
     */
    Integer deleteById(Integer goodsId);

    /**
     * 根据ID修改库存
     *
     * @param stockUpdateDTO
     * @return
     */
    Integer updateById(StockUpdateDTO stockUpdateDTO);
}
