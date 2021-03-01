package com.monster.redsun.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;


@Mapper
public interface GasMapper {

    int insertBatch(@Param("list") ArrayList<Gas> gasList);

    ArrayList<Gas> selectAll();

    Integer selectAllCount();

    Integer selectWillCount();

    ArrayList<Gas> selectWillGas(Gas gas);

    Integer selectOverCount(Gas gas);

    ArrayList<Gas> selectOverGas(Gas gas);

    Integer selectColdCount();

    ArrayList<Gas> selectCold();

    ArrayList<Gas> selectGasByFilterEq(Gas gas);

    ArrayList<Gas> selectCurrentYearNotOver(Gas gas);

    Integer deleteOneById(Long id);

    IPage<Gas> selectPageVo(Page<?> page);

    Integer updateGas(Gas gas);

    ArrayList<Gas> selectAllNullGas();

    Integer isExistsById(Long id);

}
