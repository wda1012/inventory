package com.chemical.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    //当前页数
    private Integer page;
    //一页几条
    private Integer limit;
    //总条数
    private Long total;
    //查询的数据
    private Object data;
}
