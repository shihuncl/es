package com.chenlei.elasticsearch.common.constant;

/**
 * 业务常量
 * 
 * @author ZY
 * @date 2018/10/18
 */
public class BizConstant {

    /**
     * 每页显示1条
     */
    public static final Integer PAGE_SIZE_1 = 1;

    /**
     * 每页显示15条
     */
    public static final Integer PAGE_SIZE_15 = 15;

    /**
     * 每页显示20条
     */
    public static final Integer PAGE_SIZE_20 = 20;

    /**
     * 每页显示30条
     */
    public static final Integer PAGE_SIZE_30 = 30;

    /**
     * parentId为0
     */
    public static final Long PARENT_ID_ZERO_LONG = 0L;

    /**
     * parentId为0
     */
    public static final Integer PARENT_ID_ZERO_INTEGER = 0;

    /**
     * 菜单根节点名称
     */
    public static final String ROOT_MENU_NAME = "根目录";

    // ==================================系统参数====================================
    /**
     * 自动关闭订单时间
     */
    public static final String MEMBER_AUTO_CLOSING_TIME = "MEMBER_AUTO_CLOSING_TIME";
    /**
     * 自动确认收货时间
     */
    public static final String MEMBER_AUTO_RECEIPT_TIME = "MEMBER_AUTO_RECEIPT_TIME";
    /**
     * 申请退款时间
     */
    public static final String MEMBER_APPLICATION_TIME_FOR_REFUND = "APPLICATION_TIME_FOR_REFUND";
    /**
     * 退款审核时间
     */
    public static final String MEMBER_REFUND_AUDIT_TIME = "MEMBER_REFUND_AUDIT_TIME";
    /**
     * 买家退货时间
     */
    public static final String MEMBER_BUYER_RETURN_TIME = "MEMBER_BUYER_RETURN_TIME";
    /**
     * 自动关闭订单时间-代理
     */
    public static final String AGENT_AUTO_CLOSING_TIME = "AGENT_AUTO_CLOSING_TIME";

    // ==================================系统参数====================================

    /**
     * 前台接口-培训费退款
     */
    public static final String YS_API_TRAIN_REFUND = "refund/agent_caution_money_refund";

    /**
     * 英树提现银行卡
     */
    public static final String YS_WITHDRAW_BANK_NUMBER = "384470082021";

}
