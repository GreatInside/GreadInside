package cn.fighter3.serv.service.impl;

import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.api.model.StockUpdateDTO;
import cn.fighter3.api.rpc.StockApiService;
import cn.fighter3.serv.api.result.CommonResult;
import cn.fighter3.serv.entity.ShopGoods;
import cn.fighter3.serv.mapper.ShopGoodsMapper;
import cn.fighter3.serv.model.dto.GoodsAddDTO;
import cn.fighter3.serv.model.vo.GoodsVO;
import cn.fighter3.serv.service.IShopGoodsService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
public class ShopGoodsServiceImpl extends ServiceImpl<ShopGoodsMapper, ShopGoods> implements IShopGoodsService {

    @org.apache.dubbo.config.annotation.Reference(mock = "cn.fighter3.serv.service.impl.MockStockApiServiceImpl",
            cluster = "failfast")
    StockApiService stockApiService;

    /**
     * 添加商品
     *
     * @param goodsAddDTO
     * @return
     */
    public CommonResult addGoods(GoodsAddDTO goodsAddDTO) {
        ShopGoods shopGoods = new ShopGoods();
        BeanUtils.copyProperties(goodsAddDTO, shopGoods);
        this.baseMapper.insert(shopGoods);
        log.info("添加商品，商品主键：{}", shopGoods.getGoodsId());
        log.info(shopGoods.toString());
        StockAddDTO stockAddDTO = StockAddDTO.builder().goodsId(shopGoods.getGoodsId()).account(goodsAddDTO.getAccount()).build();
        log.info("准备添加库存，参数：{}", stockAddDTO.toString());
        Integer stockId = this.stockApiService.addStock(stockAddDTO);
        log.info("添加库存结束，库存主键:{}", stockId);
        return CommonResult.ok();
    }

    /**
     * 获取商品
     *
     * @param goodsId
     * @return
     */
    public CommonResult<GoodsVO> getGoodsById(Integer goodsId) {
        GoodsVO goodsVO = new GoodsVO();
        //获取商品基本信息
        ShopGoods shopGoods = this.baseMapper.selectById(goodsId);
        if(shopGoods == null){
            return CommonResult.error("商品不存在");
        }
        BeanUtils.copyProperties(shopGoods, goodsVO);
        //获取商品库存数量
        Integer account = this.stockApiService.getAccountById(goodsId);
        log.info("商品数量:{}", account);
        goodsVO.setAccount(account);
        return CommonResult.ok(goodsVO);
    }

    /**
     * 根据ID删除库存
     *
     * @param goodsId
     * @return
     */
    @Override
    public CommonResult deleteById(Integer goodsId) {
        this.baseMapper.deleteById(goodsId);
        this.stockApiService.deleteById(goodsId);
        return CommonResult.ok();
    }



    /**
     * 根据ID修改库存
     *
     * @param stockUpdateDTO
     * @return
     */
    @Override
    public CommonResult updateById(StockUpdateDTO stockUpdateDTO) {
        this.stockApiService.updateById(stockUpdateDTO);
        return CommonResult.ok();
    }

    @Override
    public CommonResult<List<ShopGoods>> get() {
        Page<ShopGoods> stockPage = new Page<>(1, 3);
        Page<ShopGoods> page = this.baseMapper.selectPage(stockPage, null);
        List<ShopGoods> records = page.getRecords();
        return CommonResult.ok(records);
    }

}
