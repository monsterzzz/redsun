package com.monster.redsun.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;

import java.util.ArrayList;

public interface GasService  {

    Long insertOne(Gas gas);

    ArrayList<Gas> selectAll();

    Integer deleteOneById(Long id);

    IPage<Gas> selectPageVo(Page<?> page);

    Boolean isExistsById(Long id);

    Boolean updateGas(Gas gas);

    String consoleName();

}
