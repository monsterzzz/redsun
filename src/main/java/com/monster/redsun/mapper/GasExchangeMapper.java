package com.monster.redsun.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.GasExchange;
import com.monster.redsun.entity.Guest;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;


@Mapper
public interface GasExchangeMapper {

    Long inRepo(String inTime,Long id);

    Long outRepo(GasExchange gasExchange);

    ArrayList<GasExchange> selectAll();

    Integer deleteOneById(Long id);

    IPage<GasExchange> selectPageVo(Page<?> page);

    Integer updateExchange(GasExchange gasExchange);

    Integer isExistInRepo(Long id);


}
