package com.chenlei.elasticsearch.common.enums;

/**
 * 菜单类型
 * 
 * @author ZY
 * @date 2018/10/16
 */
public enum EnumMenuType {

    /**
     * 目录
     */
    NAV(0, "目录"),

    /**
     * 菜单
     */
    MENU(1, "菜单"),

    /**
     * 按钮
     */
    BUTTON(2, "按钮");

    private Integer key;
    private String text;

    private EnumMenuType() {}

    private EnumMenuType(Integer key, String text) {
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

    public String getText(Integer key) {
        if (key == null) {
            return null;
        }
        for (EnumMenuType e : EnumMenuType.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
