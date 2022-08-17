package com.shouxin.yy.entity.VO.h5;

import com.alibaba.fastjson.JSONArray;
import com.shouxin.yy.entity.DO.ProductMsgDO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @time 2022/5/18 10:54 上午
 * @Author feikong
 */
@Data
public class H5ProductDetailVO {

    private String uuid;
    private String name;
    private String logo;
    private Integer amount;
    private Integer status;
    /**
     * 出师奖
     */
    private BigDecimal levelARate;
    /**
     * 越级奖
     */
    private BigDecimal levelBRate;
    private List<String> rate;
    private List<String> loanMonth;
    private List<String> repayType;
    private List<ProductMsgDO> msg;
    private JSONArray content;
    private List<String> area;
    private Boolean isAreaAgree;
    private List<ProductVipVO> vips;

    /**
     * 是否收藏
     */
    private Boolean isCollect;

    private BigDecimal quanM;
}
