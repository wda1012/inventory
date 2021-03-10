package com.chemical.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chemical.pojo.Invoice;
import com.chemical.pojo.PageResult;
import com.chemical.service.InvoiceService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(methods = {RequestMethod.GET,RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService InvoiceService;

    //查询所有
    @GetMapping({"/list/{page}/{limit}", "/list"})
    public PageResult list(
            @PathVariable(value = "page", required = false) Integer page,
            @PathVariable(value = "limit", required = false) Integer limit,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cas", required = false) String cas
    ) {

        //初始化分页参数
        page = page == null ? 1 : page;
        limit = limit == null ? 10 : limit;

        //分页插件,获取分页信息以及返回的数据
        Page<Object> pageData = PageHelper.startPage(page, limit);

        QueryWrapper<Invoice> invoiceQueryWrapper = new QueryWrapper<Invoice>();
        if (name != null) {
            invoiceQueryWrapper.eq("name", name);
        }
        if (cas != null) {
            invoiceQueryWrapper.eq("cas", cas);
        }

        //返回结果
        List<Invoice> list = InvoiceService.list(invoiceQueryWrapper);

        PageResult pageResult = new PageResult();
        //设置当前页数
        pageResult.setPage(pageData.getPageNum());
        //设置当前一页几条
        pageResult.setLimit(pageData.getPageSize());
        //设置总条数
        pageResult.setTotal(pageData.getTotal());
        //设置返回的数据
        pageResult.setData(pageData.getResult());
        return pageResult;
    }

    //根据id查询
    @GetMapping("/get/{id}")
    public Invoice get(@PathVariable(value = "id", required = false) Integer id) {
        return InvoiceService.getById(id);
    }

    //添加
    @PostMapping("/add")
    public Boolean add(@RequestBody Invoice Invoice) {
        Invoice.setCreateTime(new Timestamp(new java.util.Date().getTime()));
        return InvoiceService.save(Invoice);
    }

    //修改
    @PutMapping("/update")
    public Boolean update(@RequestBody Invoice Invoice) {
        return InvoiceService.updateById(Invoice);
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable(value = "id", required = false) Integer id) {
        return InvoiceService.removeById(id);
    }
}
