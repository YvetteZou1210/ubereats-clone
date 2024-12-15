package com.takeout.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.takeout.common.Result;
import com.takeout.pojo.Dish;
import com.takeout.pojo.OrderDetail;
import com.takeout.pojo.Orders;
import com.takeout.service.OrderDetailService;
import com.takeout.service.OrdersService;
import com.takeout.utils.BaseContext;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单明细表 前端控制器
 * </p>
 *
 * @author cc
 * @since 2022-05-30
 */
@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户下单
     *
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public Result<String> submit(@RequestBody Orders orders) {
        Long currentId = BaseContext.getCurrentId();
        ordersService.submit(orders);
        redisTemplate.delete(String.valueOf(currentId));
        return Result.success("下单成功");
    }


    /**
     * 用户端展示自己的订单分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public Result<Page> page(int page, int pageSize) {

        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();

        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Orders::getOrderTime);
        ordersService.page(pageInfo, queryWrapper);

        return Result.success(pageInfo);
    }


    @GetMapping("/allDish")
    public Result<List<Dish>> allDish(String id) {
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId, id);
        List allDish = orderDetailService.list(queryWrapper);
        return Result.success(allDish);
    }


}
