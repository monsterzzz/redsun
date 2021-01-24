package com.monster.redsun.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public Long insertOne(Gas gas) {
        return gasMapper.insertOne(gas);
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
    public Boolean isExistsById(Long id) {
        return gasMapper.isExistsById(id) >= 1;
    }

    @Override
    public Boolean updateGas(Gas gas) {
        return gasMapper.updateGas(gas) == 0;
    }

    @Override
    public String consoleName() {
        return "Hello World";
    }
}
