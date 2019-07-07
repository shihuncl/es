package com.chenlei.elasticsearch.common.enums;

/**
 * 商品是否有条形码
 * 
 * @author ZY
 * @date 2018/11/03
 */
public enum EnumIsGoodsBarCode {
    /**
     * 正常
     */
    YES(0, "无条码"),

    /**
     * 冻结
     */
    NO(1, "有条码");

    private Integer key;
    private String text;

    private EnumIsGoodsBarCode() {}

    private EnumIsGoodsBarCode(Integer key, String text) {
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
        for (EnumIsGoodsBarCode e : EnumIsGoodsBarCode.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
