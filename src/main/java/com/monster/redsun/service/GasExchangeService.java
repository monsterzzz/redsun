package com.monster.redsun.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.GasExchange;
import com.monster.redsun.entity.Guest;
import com.monster.redsun.exception.GuestHasBeenExistException;

import java.util.ArrayList;
import java.util.HashMap;

public interface GasExchangeService {

    HashMap<String, ArrayList<Long>> inRepo(ArrayList<Long> ids);

    Boolean outRepo(GasExchange gasExchange);

    ArrayList<GasExchange> selectAll();

    Integer deleteOneById(Long id);

    IPage<GasExchange> selectPageVo(Page<?> page);

    Integer updateExchange(GasExchange gasExchange);
}
