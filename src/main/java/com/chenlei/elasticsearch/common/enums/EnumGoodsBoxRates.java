package com.chenlei.elasticsearch.common.enums;

/**
 * 盒数比例
 * 
 * @author ZY
 * @date 2018/11/03
 */
public enum EnumGoodsBoxRates {

    /**
     * 1:1
     */
    ONE(1, "1:1"),

    /**
     * 1:2
     */
    TWO(2, "1:2"),

    /**
     * 1:3
     */
    THREE(3, "1:3"),

    /**
     * 1:4
     */
    FOUR(4, "1:4"),

    /**
     * 1:5
     */
    FIVE(5, "1:5"),

    /**
     * 1:6
     */
    SIX(6, "1:6");

    private Integer key;
    private String text;

    private EnumGoodsBoxRates() {}

    private EnumGoodsBoxRates(Integer key, String text) {
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
        for (EnumGoodsBoxRates e : EnumGoodsBoxRates.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }
}
