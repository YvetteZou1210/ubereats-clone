package com.takeout.service;

import com.takeout.dto.SetmealDto;
import com.takeout.pojo.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 套餐 服务类
 * </p>
 *
 * @author cc
 * @since 2022-05-30
 */
public interface SetmealService extends IService<Setmeal> {

    public void saveWithDish(SetmealDto setmealDto);

    public SetmealDto getSetmealData(Long id);

    public void removeWithDish(List<Long> ids);
}
