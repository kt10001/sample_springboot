package com.shouxin.yy.entity.VO.bg;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @time 2022/5/17 1:53 下午
 * @Author feikong
 */
@Data
@AllArgsConstructor
public class ProductRuleVO {

    private String productUuid;

    private List<Rule> rules;

    @Data
    public static class Rule {
        private String name;
        private String code;
        private String symbol;
        private List<String> value;
        private List<String> defaultValue;
        private String type;
        private String dataType;

    }
}
