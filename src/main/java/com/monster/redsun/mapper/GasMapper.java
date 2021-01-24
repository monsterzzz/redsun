package com.monster.redsun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;


@Mapper
public interface GasMapper {

    Long insertOne(Gas gas);

    ArrayList<Gas> selectAll();

    Integer deleteOneById(Long id);

    IPage<Gas> selectPageVo(Page<?> page);

    Integer updateGas(Gas gas);

    Integer isExistsById(Long id);


}
