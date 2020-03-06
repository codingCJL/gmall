package com.cjl.gmall.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    @Column
    private String catalog3Id;

    //BaseAttrValue的集合
    @Transient //表示当前字段不是对应表中的字段，而是业务需要使用
    private List<BaseAttrValue> attrValueList;
}
