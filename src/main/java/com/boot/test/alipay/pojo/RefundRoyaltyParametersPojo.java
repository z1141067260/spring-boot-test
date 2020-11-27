package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author WangW
 * @date 2020/11/05 14:13
 * @description 退款时分账实体类
 */
public class RefundRoyaltyParametersPojo {

    @JSONField(name = "royalty_type")
    private String royaltyType;

    @JSONField(name = "trans_out")
    private String transOut;

    @JSONField(name = "trans_out_type")
    private String transOutType;

    @JSONField(name = "trans_in_type")
    private String transInType;

    @JSONField(name = "trans_in")
    private String transIn;

    @JSONField(name = "amount")
    private String amount;

    @JSONField(name = "amount_percentage")
    private String amountPercentage;

    @JSONField(name = "desc")
    private String desc;

    public String getRoyaltyType() {
        return royaltyType;
    }

    public void setRoyaltyType(String royaltyType) {
        this.royaltyType = royaltyType;
    }

    public String getTransOut() {
        return transOut;
    }

    public void setTransOut(String transOut) {
        this.transOut = transOut;
    }

    public String getTransOutType() {
        return transOutType;
    }

    public void setTransOutType(String transOutType) {
        this.transOutType = transOutType;
    }

    public String getTransInType() {
        return transInType;
    }

    public void setTransInType(String transInType) {
        this.transInType = transInType;
    }

    public String getTransIn() {
        return transIn;
    }

    public void setTransIn(String transIn) {
        this.transIn = transIn;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountPercentage() {
        return amountPercentage;
    }

    public void setAmountPercentage(String amountPercentage) {
        this.amountPercentage = amountPercentage;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
