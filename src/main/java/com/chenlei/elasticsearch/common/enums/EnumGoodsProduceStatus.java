package com.chenlei.elasticsearch.common.enums;

/**
 * 商品生产状态
 * 
 * @author ZY
 * @date 2018/11/03
 */
public enum EnumGoodsProduceStatus {
    /**
     * 销售中
     */
    ON_SALE(0, "销售中"),

    /**
     * 停产
     */
    STOP_PRODUCE(1, "停产");

    private Integer key;
    private String text;

    private EnumGoodsProduceStatus() {}

    private EnumGoodsProduceStatus(Integer key, String text) {
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
        for (EnumGoodsProduceStatus e : EnumGoodsProduceStatus.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
