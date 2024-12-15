package com.takeout.service.impl;

import com.takeout.pojo.ShoppingCart;
import com.takeout.mapper.ShoppingCartMapper;
import com.takeout.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author cc
 * @since 2022-05-30
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
