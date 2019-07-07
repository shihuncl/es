package com.chenlei.elasticsearch.common.enums;

/**
 * 菜单类型
 * 
 * @date 2018/10/16
 */
public enum EnumAgentLevel {

    /**
     * 会员
     */
    ZERO(0, "会员"),

    /**
     * 总代
     */
    ONE(1, "总代"),

    /**
     * 区代
     */
    TWO(2, "区代"),

    /**
     * 一级
     */
    THREE(3, "一级"),

    /**
     * 二级
     */
    FOUR(4, "二级"),

    /**
     * 特约
     */
    FIVE(5, "特约");

    private Integer key;
    private String text;

    private EnumAgentLevel() {}

    private EnumAgentLevel(Integer key, String text) {
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
        for (EnumAgentLevel e : EnumAgentLevel.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
