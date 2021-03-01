package com.monster.redsun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.mapper.GasMapper;
import com.monster.redsun.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GasServiceImpl implements GasService {

    @Autowired
    GasMapper gasMapper;


    @Override
    public ArrayList<Gas> insertBatch(ArrayList<Gas> gasList) {
        gasMapper.insertBatch(gasList);
        return gasList;
    }

    @Override
    public ArrayList<Gas> selectAll() {
        return gasMapper.selectAll();
    }

    @Override
    public Integer deleteOneById(Long id) {
        if(this.isExistsById(id)){
            gasMapper.deleteOneById(id);
            return 0;
        }
        return 1;
    }

    @Override
    public IPage<Gas> selectPageVo(Page<?> page) {

        return gasMapper.selectPageVo(page);
    }

    @Override
    public ArrayList<Gas> selectAllNullGas() {
        ArrayList<Gas> gases = gasMapper.selectAllNullGas();
        for(Gas gas :gases ){
            gas.gasIdGenerator();

        }
        return gases;
    }

    @Override
    public Boolean isExistsById(Long id) {
        return gasMapper.isExistsById(id) >= 1;
    }

    @Override
    public Boolean updateGas(Gas gas) {
        return gasMapper.updateGas(gas) == 0;
    }

    @Override
    public ArrayList<Gas> selectGasByFilterEq(Gas gas) {
        return gasMapper.selectGasByFilterEq(gas);
    }

    @Override
    public ArrayList<Gas> selectOverGas(Gas gas) {
        return gasMapper.selectOverGas(gas);
    }

    @Override
    public ArrayList<Gas> selectCurrentYearNotOver(Gas gas) {
        return gasMapper.selectCurrentYearNotOver(gas);
    }

    @Override
    public String consoleName() {
        return "Hello World";
    }
}
