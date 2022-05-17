package cn.fighter3.serv.service;

import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.api.model.StockUpdateDTO;
import cn.fighter3.serv.api.result.CommonResult;
import cn.fighter3.serv.entity.ShopGoods;
import cn.fighter3.serv.model.dto.GoodsAddDTO;
import cn.fighter3.serv.model.vo.GoodsVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 三分恶
 * @since 2021-05-18
 */
public interface IShopGoodsService extends IService<ShopGoods> {

    CommonResult addGoods(GoodsAddDTO goodsAddDTO);

    CommonResult<GoodsVO> getGoodsById(Integer goodsId);

    CommonResult deleteById(Integer goodsId);

    CommonResult updateById(StockUpdateDTO stockUpdateDTO);
}
