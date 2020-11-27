package com.boot.test;

import lombok.Setter;
import lombok.Getter;

/**
 * @author : WangW
 * @Date : 2020/10/21 15:17
 * @description :
 */
@Getter
@Setter
public class entity {

    private Integer id;

    private String name;

    private String age;

    public String getName() {
        return name.replace(" ", "")+"传统优先  ";
    }
}
