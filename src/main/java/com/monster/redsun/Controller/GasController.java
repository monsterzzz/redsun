package com.monster.redsun.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.service.GasService;
import com.monster.redsun.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gas")

public class GasController {

    @Autowired
    GasService gasService;

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse gasAdd(@RequestBody  Gas gas){
        BaseResponse response = new BaseResponse();
        gasService.insertOne(gas);
        response.setData(gas);
        return response;
    }

    @GetMapping("/page/{pageNumber}")
    @ResponseBody
    public BaseResponse gasQuery(@PathVariable String pageNumber){
        int pageSize = 10;
        BaseResponse baseResponse = new BaseResponse();
        if(pageNumber.equals("all")){
            baseResponse.setData(gasService.selectAll());
            return baseResponse;
        }
        IPage<Gas> gasPage;
        try {
            Integer number = new Integer(pageNumber);
            gasPage = gasService.selectPageVo(new Page<>(number,pageSize));
        }catch (NumberFormatException e){
            System.out.println(e);
            baseResponse.setErrorCode(301);
            gasPage = null;
        }
        baseResponse.setData(gasPage);
        return baseResponse;
    }

    @GetMapping ("/delete/{id}")
    @ResponseBody
    public BaseResponse gasDelete(@PathVariable Long id){
        BaseResponse response = new BaseResponse();
        response.setData(gasService.deleteOneById(id));
        return response;
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResponse gasUpdate(@RequestBody Gas gas){
        BaseResponse response = new BaseResponse();
        if(!gasService.updateGas(gas)){
            response.setData("修改成功!");
        }else {
            response.setData("修改失败");
            response.setErrorCode(331);
        }
        return response;
    }


}
