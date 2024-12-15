package com.takeout.mapper;

import com.takeout.dto.SetmealDto;
import com.takeout.pojo.Setmeal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.takeout.pojo.SetmealDish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 套餐 Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2022-05-30
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {

    List<SetmealDish> listSetmeal(int page, int pageSize, String name);

    SetmealDto getSetmealData(Long id);
}
