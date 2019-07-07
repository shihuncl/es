package com.chenlei.elasticsearch.common.enums;

/**
 * 结果码枚举类
 * 
 * @author ZY
 * @date 2018/10/09
 */
public enum EnumResult {
    // ----------------------模块间预留100000，模块内预留20-----------------------

    // -------------------------基础结果码-------------------------
    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(20, "系统异常"),

    /**
     * 参数为空
     */
    PARAM_NULL(40, "参数为空"),

    /**
     * 上传文件格式不支持
     */
    PARAM_UPLOAD_FORMAT_UNKOWN(50, "上传的文件格式不支持"),

    /**
     * 参数无效
     */
    PARAM_INVALID(60, "参数无效"),

    DATA_LOSS_OR_ERROR(10010, "数据丢失或错误"),

    SELECT_ERROR(10011, "查询失败"), INSERT_ERROR(10012, "添加失败"), DELETE_ERROR(10013, "删除失败"), UPDATE_ERROR(10014, "修改失败"),
    OPERATION_ERROR(10019, "操作失败"),

    /**
     * 数据为空
     */
    DATA_NULL(60, "数据为空"),

    /**
     * 
     */
    DATA_ABNORMAL(70, "参数异常"),

    /**
     * 数据当前状态，不支持该操作
     */
    DATA_STATUS_NOT_SUPPORT_CURRENT_OPER(75, "数据当前状态，不支持该操作"),

    /**
     * 重复调用
     */
    REQUEST_REPEAT(80, "重复调用"),

    /**
     * 数据限制500条，请分批次导出
     */
    EXPORT_TOO_MANY_LIMITED_2000(10600, "数据限制2000条，请分批次导出"),

    // -----------------------用户相关结果码-------------------------

    /**
     * 校验登录失败
     */
    USER_CHECK_LOGIN_ERROR(100000, "校验登录失败"),

    /**
     * 未登录或登录已过期
     */

    USER_NOT_LOGIN(100001, "未登录或会话已过期"),

    /**
     * 校验访问权限异常
     */
    USER_CHECK_ACCES_PERMISSION_ERROR(100009, "校验访问权限异常"),

    /**
     * 无访问权限
     */
    USER_NO_ACCESS_PERMISSION(100010, "无访问权限"),

    /**
     * 密码错误
     */
    USER_LOGIN_PASSWORD_ERROR(100020, "密码错误"),

    /**
     * 账号已锁
     */
    USER_LOGIN_ACCOUNT_LOCKED(100040, "账号已锁"),

    /**
     * 账号不存在
     */
    USER_DATA_NULL(100060, "账号不存在"),

    /**
     * 账号非开通状态
     */
    USER_ISTATUS_NOT_OK(100070, "账号非开通状态"),

    /**
     * 两次输入密码不一致
     */
    USER_CHANGE_PASSWORD_DIFF(100080, "两次输入密码不一致"),

    /**
     * 用户旧密码错误
     */
    USER_CHANGE_PASSWORD_OLD_ERROR(100100, "用户旧密码错误"),

    /**
     * 创建失败，登录名已存在
     */
    USER_CREATE_FAIL_USERNAME_EXISTS(100110, "创建失败，登录名已存在"),

    /**
     * 创建失败，邮箱已存在
     */
    USER_CREATE_FAIL_EMAIL_EXISTS(100111, "创建失败，邮箱已存在"),

    /**
     * 邀请码不存在
     */
    INVITATION_CODE_DOES_NOT_EXIST(100112, "邀请码不存在"),

    /**
     * 用户不是代理
     */
    USER_IS_NOT_AGENT(100120, "用户不是代理"),

    /**
     * 未知的代理级别
     */
    AGENT_LEVEL_UNKNOW(100300, "未知的代理级别"),

    /**
     * 查找公告失败无此公告
     */
    WITHOUT_THIS_ANNOUNCEMENT(100102, "查找公告失败无此公告"),

    UPLOAD_ERROR(1001001, "图片上传失败"),

    CANNOT_MOVE(1001004, "已是最底层"),

    TOPMOST_MOVE(1001005, "已是最顶层"),

    // -------------------- 订单相关----------------
    /**
     * 当前状态无法执行此操作
     */
    THE_CURRENT_STATE_CANNOT_PERFORM_THIS_OPERATION(1003001, "当前状态无法执行此操作"),

    /**
     * 未查询到物流信息
     */
    LOGISTIC_INFO_NOT_FOUND(1009001, "未查询到物流信息"),

    // 订单收货地址
    NO_RECEIVING_ADDRESS_EXISTS(1003011, "不存在收货地址"),

    /**
     * 商品类目下存在商品，无法删除
     */
    GOODS_CATE_CONTAINS_GOODS_DEL_FAILED(1020000, "商品类目下存在商品，无法删除"),

    /**
     * 商品正在套组活动中，不能下架
     */
    GOODS_IN_BOX_ACTIVITY_OFF_SHELF_FAILED(1021000, "商品正在套组活动中，不能下架"),

    /**
     * 商品正在买赠活动中，不能下架
     */
    GOODS_IN_BUY_GIVE_ACTIVITY_OFF_SHELF_FAILED(1021001, "商品正在买赠活动中，不能下架"),

    /**
     * 商品正在加价换购活动中，不能下架
     */
    GOODS_IN_BUY_GIVE_MONEY_ACTIVITY_OFF_SHELF_FAILED(1021002, "商品正在加价换购活动中，不能下架"),

    /**
     * 商品正在全场加价换购活动中，不能下架
     */
    GOODS_IN_QC_BUY_GIVE_MONEY_ACTIVITY_OFF_SHELF_FAILED(1021003, "商品正在全场加价换购活动中，不能下架"),

    /**
     * 商品正在单品优惠活动中，不能下架
     */
    GOODS_IN_SALE_ACTIVITY_OFF_SHELF_FAILED(1021004, "商品正在单品优惠活动中，不能下架"),

    /**
     * 商品回购价为空
     * 
     */
    GOODS_RECALL_PRICE_IS_NULL(1021100, "商品回购价为空"),

    // ------运费模板--------
    FREIGHT_TEMPLATE_DOES_NOT_EXIST_OR_HAS_BEEN_DELETED(90001, "运费模板不存在或已被删除"),
    DEFAULT_FREIGHT_TEMPLATE_CANNOT_BE_ADD_REPEATEDLY(90002, "默认运费模板不能重复添加"),
    NO_DEFAULT_FREIGHT_TEMPLATE(90003, "尚无默认运费模板,请先添加默认运费模版"),
    FREIGHT_TEMPLATE_HAS_PROVINCE(90004, "该运费模版下，已存在相同省份，请勿重复添加"),
    FREIGHT_TEMPLATE_HAS_CITY(90005, "该运费模版下，已存在相同城市，请勿重复添加"),
    DEFAULT_FREIGHT_TEMPLATE_CANNOT_REMOVE(90006, "不能删除默认运费模板"),
    APPOINT_CONDITIONS_PACKAGE_IS_EXIST_ALL(90007, "指定条件下已存在全国地区"),
    APPOINT_CONDITIONS_PACKAGE_ERROR(90008, "运费计算失败，请稍后重试"),

    /**
     * 指定条件包邮,1.金额 2.件数 3.件数+金额 只能三选一
     */
    APPOINT_CONDITIONS_PACKAGE_PIECE_ERROR(90009, "指定条件包邮，1.金额 2.件数 3.件数+金额 只能三选一"),

    /**
     * 指定条件包邮,1.重量 2.件数 3.件数+重量 只能三选一
     */
    APPOINT_CONDITIONS_PACKAGE_WEIGHT_ERROR(90010, "指定条件包邮，1.重量 2.件数 3.件数+重量 只能三选一"),

    /**
     * 指定条件包邮,全国包邮条件重复
     */
    APPOINT_CONDITIONS_PACKAGE_ENTIRE_COUNTRY_DUPLICATE(90020, "指定条件包邮，全国包邮条件重复"),

    // ------------------------------------换货活动--------------------------------------------
    /**
     * 换货活动已有人参与，不能修改
     */
    EXCHANGE_ACTIVITY_HAS_USER_CANNOT_EDIT(1031004, "换货活动已有人参与，不能修改"),

    /**
     * 已存在启用中的换货活动
     */
    EXCHANGE_ACTIVITY_ENABLED_EXSITS(1031010, "已存在启用的换货活动"),
    /**
     * 单规格商品时，商品和sku上的T+编码需一致
     */
    GOODS_SINGLE_SKU_TSN_NEED_SAME(1021005, "单规格商品时，商品和sku上的T+编码需一致"),

    /**
     * 赠品库存大于商品库存
     */
    GIFT_GOODS_IS_BIG(1021006, "赠品设置的库存大于主商品的库存"),

    /**
     * 课程报名时间需大于课程开始时间
     */
    TRAIN_APPLY_TIME_NEED_BEFORE_START_TIME(1040000, "课程报名时间需大于课程开始时间"),

    /**
     * 课程指定用户时，用户不能为空
     */
    TRAIN_ALLOW_USER_IDS_NEED_NOT_NULL(1040005, "课程指定用户时，用户不能为空"),

    /**
     * 课程报名时间需大于课程开始时间
     */
    TRAIN_EDIT_FAIL_HAS_TRAIN_APPLY(1040010, "课程已有人报名，不可修改"),

    /**
     * 课程结束后，才能退款
     */
    TRAIN_ACC_RECORD_REFUND_NEED_TRAIN_END(1040020, "课程结束后，才能退款"),

    /**
     * 云仓强制提货时间，不能小于下单时间
     */
    CLOUD_STORAGE_FORCE_EXTRACT_TIME_NEED_AFTER_ORDER_ADD_TIME(1200000, "云仓强制提货时间，不能小于下单时间"),

    /**
     * 云仓强制提货时间，不能小于下单时间
     */
    NO_APPROVE_TEN_MINUTES_ID(1400000, "提交审核10分钟内不允许对统一id进行重复操作");

    private Integer code;
    private String msg;

    private EnumResult() {}

    private EnumResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsg(Integer code) {
        if (code == null) {
            return null;
        }
        for (EnumResult r : EnumResult.values()) {
            if (code.equals(r.getCode())) {
                return r.getMsg();
            }
        }
        return null;
    }

}
