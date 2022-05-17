package cn.fighter3.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @Author: 三分恶
 * @Date: 2021/5/26
 * @Description:
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class StockUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;



    /**
     * 商品主键
     */
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer inventory;
}
