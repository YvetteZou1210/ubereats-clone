package com.takeout.dto;


import com.takeout.pojo.Setmeal;
import com.takeout.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
