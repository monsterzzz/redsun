package com.monster.redsun.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.vo.GasQueryVo;

import java.util.ArrayList;
import java.util.List;

public interface GasService  {

    ArrayList<Gas> insertBatch(ArrayList<Gas> gasList);

    ArrayList<Gas> selectAll();

    Integer deleteOneById(Long id);

    IPage<Gas> selectPageVo(Page<?> page);

    ArrayList<Gas> selectAllNullGas();

    Boolean isExistsById(Long id);

    Boolean updateGas(Gas gas);

    ArrayList<Gas> selectGasByFilterEq(Gas gas);

    ArrayList<Gas> selectOverGas(Gas gas);

    ArrayList<Gas> selectCurrentYearNotOver(Gas gas);

    String consoleName();

}
