package com.chenlei.elasticsearch.common.enums;

/**
 * 英树代金券流水类型
 * 
 * @author zhangyang
 * @date 2019/04/08
 */
public enum EnumCoinFlowType {

    /**
     * 英树生活转移
     */
    YS_LIFE_CREATE(1, "英树生活转移"),

    /**
     * 采购订单支出
     */
    ORDER_PAYED(2, "采购订单支出"),

    /**
     * 销售订单收入
     */
    SUB_ORDER_PAYED(3, "销售订单收入"),

    /**
     * 采购订单退款
     */
    ORDER_REFUND(4, "采购订单退款"),

    /**
     * 销售订单退款
     */
    SUB_ORDER_REFUND(5, "销售订单退款"),

    /**
     * 过期
     */
    EXPIRED(6, "过期"),

    /**
     * 激活
     */
    FIVE(7, "激活");

    private Integer key;
    private String text;

    private EnumCoinFlowType() {}

    private EnumCoinFlowType(Integer key, String text) {
        this.key = key;
        this.text = text;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static String getText(Integer key) {
        if (key == null) {
            return null;
        }
        for (EnumCoinFlowType e : EnumCoinFlowType.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
