package com.takeout.service.impl;

import com.takeout.pojo.AddressBook;
import com.takeout.mapper.AddressBookMapper;
import com.takeout.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址管理 服务实现类
 * </p>
 *
 * @author cc
 * @since 2022-05-30
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
