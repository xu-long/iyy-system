package com.iyy.constant;

/**
 * 库存常量
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/27 3:52 下午
 */
public class StockConstant {
    /**
     * 按量购买
     */
    public final static String SALES_METHOD_WEIGHT = "10";

    /**
     * 按件购买
     */
    public final static String SALESMETHOD_QUANTITY = "20";

    /**
     * 整体购买
     */
    public final static String SALESMETHOD_ALL = "30";

    /*
     * 标准金额保留小数位数-2位小数
     */
    public static final int STANDARD_AMOUNT_SCALE = 2;

    /*
     * 标准单价保留小数位数-2位小数
     */
    public static final int STANDARD_PRICE_SCALE = 5;
}
