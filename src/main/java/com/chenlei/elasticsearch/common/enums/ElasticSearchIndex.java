package com.chenlei.elasticsearch.common.enums;

/**
 * Created by chenlei on 2019/6/24.
 */
public enum ElasticSearchIndex {
    //基础数据导入
    BASICGOODSINFOINDEX("base","basicinfo"),
    BASICGOODSINFOINDEX_TYPE("base_type","_doc"),

    //数据流转记录
    RECORDGOODSINFOINDEX("record","recordinfo"),
    RECORDGOODSINFOINDEX_TYPE("record_type","_doc"),

    //系统物流码logistics
    LOGISTICSCODEINDEX("logistics","logisticscode"),
    LOGISTICSCODEINDEX_TYPE("logistics_type","_doc"),
    //系统明暗码 Light shade
    LIGHTSHADECODEINDEX("lightshade","lightshadecode"),
    LIGHTSHADECODEINDEX_TYPE("lightshade_type","_doc");

    private String key;
    private String text;

    private ElasticSearchIndex() {}

    private ElasticSearchIndex(String key, String text) {
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
        for (ElasticSearchIndex e : ElasticSearchIndex.values()) {
            if (key.equals(e.getKey())) {
                return e.getText();
            }
        }
        return null;
    }

}
