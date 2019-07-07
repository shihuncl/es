package com.chenlei.elasticsearch.common.enums;

/**
 * 快递公司
 * 
 * @author ZY
 * @date 2018/11/03
 */
public enum EnumLogisticCompany {

    /**
     * 顺丰速运
     */
    SF("SF", "顺丰速运"),
    /**
     * 百世快递
     */
    HTKY("HTKY", "百世快递"),
    /**
     * 中通快递
     */
    ZTO("ZTO", "中通快递"),
    /**
     * 申通快递
     */
    STO("STO", "申通快递"),
    /**
     * 圆通速递
     */
    YTO("YTO", "圆通速递"),
    /**
     * 韵达速递
     */
    YD("YD", "韵达速递"),
    /**
     * 邮政快递包裹
     */
    YZPY("YZPY", "邮政快递包裹"),
    /**
     * EMS
     */
    EMS("EMS", "EMS"),
    /**
     * 天天快递
     */
    HHTT("HHTT", "天天快递"),
    /**
     * 京东快递
     */
    JD("JD", "京东快递"),
    /**
     * 优速快递
     */
    UC("UC", "优速快递"),
    /**
     * 德邦快递
     */
    DBL("DBL", "德邦快递"),
    /**
     * 宅急送
     */
    ZJS("ZJS", "宅急送"),
    /**
     * TNT快递
     */
    TNT("TNT", "TNT快递"),
    /**
     * UPS
     */
    UPS("UPS", "UPS"),
    /**
     * DHL
     */
    DHL("DHL", "DHL"),
    /**
     * FEDEX联邦(国内件)
     */
    FEDEX("FEDEX", "FEDEX联邦(国内件)"),
    /**
     * FEDEX联邦(国际件)
     */
    FEDEX_GJ("FEDEX_GJ", "FEDEX联邦(国际件)"),

    /**
     * 其它
     */
    OTHER("OTHER", "其它");

    private String key;
    private String text;

    private EnumLogisticCompany() {}

    private EnumLogisticCompany(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static String getText(String key) {
        if (key == null) {
            return null;
        }
        for (EnumLogisticCompany e : EnumLogisticCompany.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
