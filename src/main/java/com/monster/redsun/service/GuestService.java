package com.monster.redsun.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.entity.Guest;
import com.monster.redsun.exception.GuestHasBeenExistException;

import java.util.ArrayList;

public interface GuestService {

    Long insertOne(Guest guest) throws GuestHasBeenExistException;

    ArrayList<Guest> selectAll();

    Integer deleteOneById(Long id);

    IPage<Guest> selectPageVo(Page<?> page);

    Boolean isExistsById(Long id);

    Boolean updateGuest(Guest guest);

    String consoleName();

    Boolean isExistsByPhone(String phone);
}
