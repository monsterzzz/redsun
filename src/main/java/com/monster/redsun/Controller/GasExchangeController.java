package com.monster.redsun.Controller;

import com.monster.redsun.DTO.GasExchangeInDTO;
import com.monster.redsun.entity.GasExchange;
import com.monster.redsun.service.GasExchangeService;
import com.monster.redsun.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/gas_exchange")
public class GasExchangeController {

    @Autowired
    GasExchangeService exchangeService;

    @PostMapping("/in")
    @ResponseBody
    public BaseResponse inRepo(@RequestBody GasExchangeInDTO exchangeInDTO){
        BaseResponse response = new BaseResponse();
        System.out.println(exchangeInDTO);
        HashMap<String, ArrayList<Long>> map = exchangeService.inRepo(exchangeInDTO.getIds());
        response.setData(map);
        return response;
    }

    @PostMapping("/out")
    @ResponseBody
    public BaseResponse outRepo(@RequestBody GasExchange gasExchange){
        BaseResponse response = new BaseResponse();
        System.out.println(gasExchange);
        if(exchangeService.outRepo(gasExchange)){
            response.setData("出库成功!");
        }else {
            response.setData("出库失败!");
        };
        return response;
    }


}
