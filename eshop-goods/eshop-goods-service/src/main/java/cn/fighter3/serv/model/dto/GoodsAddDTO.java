package cn.fighter3.serv.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: 三分恶
 * @Date: 2021/5/26
 * @Description: 商品添加DTO
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "商品添加", description = "")
public class GoodsAddDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品介绍")
    private String description;

    @ApiModelProperty(value = "数量")
    private Integer account;

}
