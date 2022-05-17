package cn.fighter3.serv.controller;

import cn.fighter3.api.model.StockAddDTO;
import cn.fighter3.api.model.StockUpdateDTO;
import cn.fighter3.serv.api.result.CommonResult;
import cn.fighter3.serv.model.dto.GoodsAddDTO;
import cn.fighter3.serv.model.vo.GoodsVO;
import cn.fighter3.serv.service.IShopGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 三分恶
 * @since 2021-05-18
 */
@RestController
@RequestMapping("/shop-goods")
@Api(value = "商品管理接口", tags = "商品接口")
@Slf4j
public class ShopGoodsController {

    @Autowired
    private IShopGoodsService goodsService;

    @PostMapping(value = "/add")
    @ApiOperation(value = "添加商品")
    public CommonResult addGoods(@RequestBody GoodsAddDTO goodsAddDTO) {
        return this.goodsService.addGoods(goodsAddDTO);
    }

    @GetMapping(value = "/get/by-id")
    @ApiOperation(value = "根据ID获取商品")
    public CommonResult<GoodsVO> getGoodsById(@RequestParam Integer goodsId) {
        return this.goodsService.getGoodsById(goodsId);
    }

    @GetMapping(value = "/get/by_gId")
    @ApiOperation(value = "根据ID删除商品")
    public CommonResult deleteById(@RequestParam Integer goodsId){
        return this.goodsService.deleteById(goodsId);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "根据ID修改库存")
    public CommonResult updateById(@RequestBody StockUpdateDTO stockUpdateDTO){
        return this.goodsService.updateById(stockUpdateDTO);
    }

}

