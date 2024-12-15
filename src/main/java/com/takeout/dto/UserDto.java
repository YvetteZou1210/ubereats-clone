package com.takeout.dto;

import com.takeout.pojo.User;
import lombok.Data;

@Data
public class UserDto extends User {
    private String code;
}
