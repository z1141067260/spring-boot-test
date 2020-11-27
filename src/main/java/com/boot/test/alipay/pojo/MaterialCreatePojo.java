package com.boot.test.alipay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author WangW
 * @date 2020/11/10 16:23
 * @description 素材类
 */
public class MaterialCreatePojo {
    /**
     * 素材类型
     */
    @JSONField(name = "type")
    private String type;

    /**
     * 素材内容（素材地址或素材KEY）
     */
    @JSONField(name = "content")
    private String content;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
