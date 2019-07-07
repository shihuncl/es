package com.chenlei.elasticsearch.common.enums;

/**
 * 换货商品类型
 * 
 * @author zhangyi
 * @date 2018/12/28
 */
public enum EnumExchangeGoodsType {

    /**
     * 换出商品
     */
    OUTGOODS(1, "换出商品"),

    /**
     * 换入商品
     */
    INGOODS(2, "换入商品");

    private Integer key;
    private String text;

    private EnumExchangeGoodsType() {}

    private EnumExchangeGoodsType(Integer key, String text) {
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
        for (EnumExchangeGoodsType e : EnumExchangeGoodsType.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }
}
