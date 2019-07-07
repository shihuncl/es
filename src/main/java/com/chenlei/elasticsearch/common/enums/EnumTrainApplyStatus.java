package com.chenlei.elasticsearch.common.enums;

/**
 * 培训报名状态
 */
public enum EnumTrainApplyStatus {

    /**
     * 待付款
     */
    WAIT_PAY(0, "待付款"),

    /**
     * 已付款
     */
    PAYED(1, "已付款"),

    /**
     * 已结束-超时未付款
     */
    CANCELD_PAY_TIME_OUT(2, "已关闭"),

    /**
     * 已关闭
     */
    CANCELD(3, "已关闭"),

    /**
     * 部分退款
     */
    REFUND_PART(4, "部分退款"),

    /**
     * 全部退款
     */
    REFUND_ALL(5, "全部退款");

    private Integer key;
    private String text;

    private EnumTrainApplyStatus() {}

    private EnumTrainApplyStatus(Integer key, String text) {
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
        for (EnumTrainApplyStatus e : EnumTrainApplyStatus.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
