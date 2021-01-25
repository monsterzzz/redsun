package com.monster.redsun.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.entity.Guest;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;


@Mapper
public interface GuestMapper {

    Long insertOne(Guest guest);

    ArrayList<Guest> selectAll();

    Integer deleteOneById(Long id);

    IPage<Guest> selectPageVo(Page<?> page);

    Integer updateGas(Guest guest);

    Integer isExistsById(Long id);

    Integer isExistsByPhone(String phone);


}
