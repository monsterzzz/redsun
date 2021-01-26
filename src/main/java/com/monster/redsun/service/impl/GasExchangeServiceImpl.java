package com.monster.redsun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.GasExchange;
import com.monster.redsun.entity.Guest;
import com.monster.redsun.exception.GuestHasBeenExistException;
import com.monster.redsun.mapper.GasExchangeMapper;
import com.monster.redsun.mapper.GuestMapper;
import com.monster.redsun.service.GasExchangeService;
import com.monster.redsun.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.SimpleFormatter;

@Service
public class GasExchangeServiceImpl implements GasExchangeService {

    @Autowired
    GasExchangeMapper gasExchangeMapper;

    @Override
    public HashMap<String, ArrayList<Long>> inRepo(ArrayList<Long> ids) {
        HashMap<String, ArrayList<Long>> map = new HashMap();
        ArrayList<Long> passList = new ArrayList();
        ArrayList<Long> errorList = new ArrayList();
        ArrayList<Long> existList = new ArrayList();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Long id : ids) {
            try {
                if(gasExchangeMapper.isExistInRepo(id) >= 1){
                    existList.add(id);
                }else{
                    gasExchangeMapper.inRepo(formatter.format(date), id);
                    passList.add(id);
                }
            } catch (Exception e) {
                System.out.println(e);
                errorList.add(id);
            }
        }
        map.put("pass",passList);
        map.put("error",errorList);
        map.put("exist",existList);
        return map;
    }

    @Override
    public Boolean outRepo(GasExchange gasExchange) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gasExchange.setExTime(formatter.format(date));
        Long flag;
        flag = gasExchangeMapper.outRepo(gasExchange);
        return flag >= 1;
    }

    @Override
    public ArrayList<GasExchange> selectAll() {
        return gasExchangeMapper.selectAll();
    }

    @Override
    public Integer deleteOneById(Long id) {
        return gasExchangeMapper.deleteOneById(id);
    }

    @Override
    public IPage<GasExchange> selectPageVo(Page<?> page) {
        return gasExchangeMapper.selectPageVo(page);
    }

    @Override
    public Integer updateExchange(GasExchange gasExchange) {
        return gasExchangeMapper.updateExchange(gasExchange);
    }
}
