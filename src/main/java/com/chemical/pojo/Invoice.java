package com.chemical.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("invoice")
public class Invoice {

  @TableId(type = IdType.AUTO)
  private Long sid;
  private String name;
  private String cas;
  private Double number;
  private Double price;
  private java.sql.Timestamp createTime;
  private String unit;
}
