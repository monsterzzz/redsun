package com.monster.redsun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.entity.Guest;
import com.monster.redsun.exception.GuestHasBeenExistException;
import com.monster.redsun.mapper.GasMapper;
import com.monster.redsun.mapper.GuestMapper;
import com.monster.redsun.service.GasService;
import com.monster.redsun.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestMapper guestMapper;


    @Override
    public Long insertOne (Guest guest) throws GuestHasBeenExistException {
        if(this.isExistsByPhone(guest.getPhone())){
            throw new GuestHasBeenExistException();
        }
        return guestMapper.insertOne(guest);
    }

    @Override
    public ArrayList<Guest> selectAll() {
        return guestMapper.selectAll();
    }

    @Override
    public Integer deleteOneById(Long id) {
        if(this.isExistsById(id)){
            guestMapper.deleteOneById(id);
            return 0;
        }
        return 1;
    }

    @Override
    public IPage<Guest> selectPageVo(Page<?> page) {
        return guestMapper.selectPageVo(page);
    }

    @Override
    public Boolean isExistsById(Long id) {
        return guestMapper.isExistsById(id) >= 1;
    }

    @Override
    public Boolean updateGuest(Guest guest) {
        return guestMapper.updateGas(guest) == 0;
    }

    @Override
    public String consoleName() {
        return "Hello World";
    }

    @Override
    public Boolean isExistsByPhone(String phone) {
        return guestMapper.isExistsByPhone(phone) >= 1;
    }
}
