package com.shouxin.yy.entity.VO.h5;

import com.shouxin.yy.entity.DO.ProductCreditDO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/26 7:14 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class SearchProductVO {

    private List<ProductListVO> loanProducts;

    private List<ProductCreditDO> creditProducts;
}
