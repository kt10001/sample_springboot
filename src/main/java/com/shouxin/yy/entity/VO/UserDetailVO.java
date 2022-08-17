package com.shouxin.yy.entity.VO;

import com.shouxin.yy.entity.DO.UserDO;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @time 2021/4/25 10:29 下午
 * @Author feikong
 */

@Data
public class UserDetailVO extends UserDO {

    private List<Map<String, String>> roleUuidList;
}
