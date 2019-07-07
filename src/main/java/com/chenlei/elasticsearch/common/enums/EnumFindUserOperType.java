package com.chenlei.elasticsearch.common.enums;

/**
 * 发现用户操作类型
 * 
 * @author ZY
 * @date 2018/10/16
 */
public enum EnumFindUserOperType {

    /**
     * 复制发现
     */
    COPY(1, "复制发现"),

    /**
     * 保存发现图片
     */
    SAVE_PIC(2, "保存发现图片"),
    
    /**
     * 保存发现视频
     */
    SAVE_VIDEO(3,"保存发现视频"),
    
    /**
     * 分享发现
     */
    SHARE(4,"分享发现");


    private Integer key;
    private String text;

    private EnumFindUserOperType() {}

    private EnumFindUserOperType(Integer key, String text) {
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
        for (EnumFindUserOperType e : EnumFindUserOperType.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
