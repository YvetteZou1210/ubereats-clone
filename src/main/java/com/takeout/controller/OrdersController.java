package com.takeout.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.takeout.common.Result;
import com.takeout.pojo.Orders;
import com.takeout.service.OrdersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author cc
 * @since 2022-05-30
 */
@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @PostMapping("/submit")
    public Result<String> submit(@RequestBody Orders orders){
        //比较繁琐，在service实现
        ordersService.submit(orders);
        return Result.success("下单成功");
    }


    /**
     * 后台查询订单明细
     *
     * @param page
     * @param pageSize
     * @param number
     * @param beginTime
     * @param endTime
     * @return
     */
    @GetMapping("/page")
    public Result<Page> page(int page, int pageSize, String number, String beginTime, String endTime) {
        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();

        //添加查询条件
        queryWrapper.like(number != null, Orders::getNumber, number).gt(StringUtils.isNotEmpty(beginTime), Orders::getOrderTime, beginTime).lt(StringUtils.isNotEmpty(endTime), Orders::getOrderTime, endTime);

        ordersService.page(pageInfo, queryWrapper);
        return Result.success(pageInfo);
    }


}
