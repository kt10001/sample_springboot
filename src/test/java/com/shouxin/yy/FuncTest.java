package com.shouxin.yy;

import org.junit.Test;

/**
 * @time 2022/8/17 5:34 下午
 * @Author feikong
 */
public class FuncTest {
    @Test
    public void test() {
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int dp0 =0, dp1 = 0, dpi = 0;
        for (int i=2; i<=cost.length; i++) {
            dpi = Math.min(dp1 + cost[i-1], dp0 + cost[i-2]);
            dp0 = dp1;
            dp1 = dpi;
        }
        return dpi;

    }

//    public int climbStairs(int n) {
//        int p = 0, q = 0, r = 1;
//        for (int i = 1; i <= n; ++i) {
//            p = q;
//            q = r;
//            r = p + q;
//        }
//        return r;
//    }


}
