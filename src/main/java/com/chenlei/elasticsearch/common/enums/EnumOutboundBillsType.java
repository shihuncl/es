package com.chenlei.elasticsearch.common.enums;

/**
 * 出库入库单类型
 * 
 * @author ZY
 * @date 2019/04/22
 */
public enum EnumOutboundBillsType {

    /**
     * 订单
     */
    ORDER(1, "订单"),

    /**
     * 换货
     */
    EXCHANGE(2, "换货"),

    /**
     * 提货
     */
    EXTRACT(3, "提货"),

    /**
     * 退货
     */
    RECALL(4, "退货");

    private Integer key;
    private String text;

    private EnumOutboundBillsType() {}

    private EnumOutboundBillsType(Integer key, String text) {
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
        for (EnumOutboundBillsType e : EnumOutboundBillsType.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
