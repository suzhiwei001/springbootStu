package com.szw.springbootdemosu.config.redis_config;

import java.util.Random;

/**
 Desc:
 <p>
 * Created by zhouxingbin on 2019/7/9.
 */
public class LuaInvConsts {

    /**
     * redis中key过期时间最小区间，单位"天"
     */
    private final static int default_expire_time_day_min = 35;
    /**
     * redis中key过期时间最大区间，单位"天"
     */
    private final static int default_expire_time_day_max = 45;

    public static int randExpireDay() {
        Random random = new Random();
        return random.nextInt(default_expire_time_day_max - default_expire_time_day_min + 1) + default_expire_time_day_min;
    }

    /**
     public final static String stock_not_exsit = "1";

     public final static String amount_not_exsit = "2";

     public final static String lotnum_stock_not_exsit = "3";

     public final static String lotnum_amount_not_exsit = "4";

     public final static String stock_not_enough = "5";

     public final static String lotnum_stock_not_enough = "6";

     public final static String sucess = "9";
     **/

    public final static String not_exsit = "not exists";

    public final static String inventory_not_exists = "inventory not exists";
    public final static String lotnum_not_exists_inventory_exists = "lotnum not exists,inventory exists";

    public final static String not_enough = "not enough";
    public final static String lotnumber_not_enough = "lotnumber not enough";

    public final static String base_ver_redis_bigger = "base_ver_redis_bigger";


}
