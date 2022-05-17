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
@Builder
@EqualsAndHashCode(callSuper = false)
public class StockAddDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Tolerate
    public StockAddDTO() {
    }

    /**
     * 商品主键
     */
    private Integer goodsId;

    /**
     * 数量
     */
    private Integer account;
}
