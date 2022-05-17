//package cn.fighter3.serv.controller;
//
//
//import cn.fighter3.api.model.StockAddDTO;
//import cn.fighter3.serv.api.result.CommonResult;
//
//
//import cn.fighter3.serv.service.IShopStockService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * <p>
// * 前端控制器
// * </p>
// *
// * @author 三分恶
// * @since 2021-05-18
// */
//@RestController
//@RequestMapping("/shop-stock")
//@Slf4j
//public class ShopStockController {
//
//    @Autowired
//    private IShopStockService shopStockService;
//
//    @PostMapping(value = "/add")
//    public CommonResult addStock(@RequestBody StockAddDTO stockAddDTO) {
//        log.info("client call add stock interface,param:{}", stockAddDTO);
//        return this.shopStockService.addStock(stockAddDTO);
//    }
//
//}
//
