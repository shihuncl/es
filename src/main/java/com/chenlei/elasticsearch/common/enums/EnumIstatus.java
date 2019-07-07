package com.chenlei.elasticsearch.common.enums;

/**
 * 用户状态
 * 
 * @author ZY
 * @date 2018/10/10
 */
public enum EnumIstatus {
    /**
     * 正常
     */
    OK(0, "正常"),

    /**
     * 冻结
     */
    FOZEN(1, "冻结"),

    /**
     * 删除
     */
    DELETED(2, "删除");
    private Integer key;
    private String text;

    private EnumIstatus() {}

    private EnumIstatus(Integer key, String text) {
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
        for (EnumIstatus e : EnumIstatus.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
