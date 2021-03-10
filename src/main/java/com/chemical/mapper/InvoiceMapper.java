package com.chemical.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chemical.pojo.Invoice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InvoiceMapper extends BaseMapper<Invoice> {
}
