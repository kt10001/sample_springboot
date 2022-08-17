package com.shouxin.yy.entity.DTO.admin.product;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @time 2022/5/16 7:31 下午
 * @Author feikong
 */
@Data
public class AddRuleDTO {

    @NotNull(message = "产品uuid 参数错误")
    private String productUuid;

    @NotEmpty(message = "产品规则 参数错误")
    @Valid
    private List<RuleDTO> rules;

    @Data
    public static class RuleDTO {
        @NotNull(message = "name参数错误")
        private String name;
        @NotNull(message = "code参数错误")
        private String code;
        @NotNull(message = "symbol参数错误")
        private String symbol;
        @NotEmpty(message = "value参数错误")
        private List<String> value;
        @NotNull(message = "type参数错误")
        private String type;
        @NotNull(message = "dataType 参数错误")
        private String dataType;
        private List<String> defaultValue;
    }
}
