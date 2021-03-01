package com.monster.redsun.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.DTO.Gas.GasNewDTO;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.service.GasService;
import com.monster.redsun.util.GasTool;
import com.monster.redsun.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/gas")

public class GasController {

    @Autowired
    GasService gasService;

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse gasAdd(@RequestBody GasNewDTO gasNewDTO){
        System.out.println(gasNewDTO);
        BaseResponse response = new BaseResponse();
        ArrayList<Gas> gasList = new ArrayList<>();
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(int i = 0; i<gasNewDTO.getNumber();i++){
            Gas gas = gasNewDTO.getGas();
            gas.setStatus(0);
            gas.setCreateTime(sdf.format(dt));
            gas.setModifyTime(sdf.format(dt));
            gasList.add(gas);
        }
        System.out.println(gasList);
        gasList = gasService.insertBatch(gasList);
        List<String> idList = new ArrayList();
        for(Gas gas : gasList){
            String s = "LD%04d%02d%05d";
            s = String.format(s, gas.getYear(),gas.getMonth(),gas.getId());
            idList.add(s);
        }
        response.setData(idList);
        return response;
    }

    @GetMapping("/baseView")
    @ResponseBody
    public BaseResponse gasBaseView(){
        BaseResponse response = new BaseResponse();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        map1.put("#","满罐");
        map1.put("other",0);
        map2.put("#","空罐");
        map2.put("other",0);
        map3.put("#","租借");
        map3.put("other",0);
        for(int i = 0;i<5;i++){
            map1.put(String.valueOf(i+2021),0);
            map2.put(String.valueOf(i+2021),0);
            map3.put(String.valueOf(i+2021),0);
        }

        for(Gas gas : gasService.selectAll()){
            if(gas.getStatus() == 1){
                GasTool.updateMap(gas,map3);
            }else{
                System.out.println(gas);
                if(gas.getIsNull() == 0){
                    GasTool.updateMap(gas,map1);
                }else{
                    GasTool.updateMap(gas,map2);
                }
            }
        }
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        maps.add(map1);
        maps.add(map2);
        maps.add(map3);
        response.setData(maps);
        return  response;
    }

    @GetMapping("/filter")
    @ResponseBody
    public BaseResponse gasFilter(@RequestParam Map<String, Object> params){
        BaseResponse baseResponse = new BaseResponse();
        ArrayList<Gas> data;

        Gas gas = new Gas();
        int status = Integer.parseInt((String)params.get("status"));
        switch(status){
            case 0:
                gas.setStatus(0);
                gas.setIsNull(0);
                break;
            case 1:
                gas.setStatus(0);
                gas.setIsNull(1);
                break;
            case 2:
                gas.setStatus(1);
                break;
        }

        int year = Integer.parseInt((String) params.get("year"));
        Calendar calendar = Calendar.getInstance();
        if(year == 13){
            gas.setYear(calendar.get(Calendar.YEAR));
            gas.setMonth(calendar.get(Calendar.MONTH) + 1);
            System.out.println(gas);
            System.out.println("11");
            data = gasService.selectOverGas(gas);
        }else{
            gas.setYear(year);
            if(year == 2021){
                gas.setMonth(calendar.get(Calendar.MONTH) + 1);
                data = gasService.selectCurrentYearNotOver(gas);
            }else {
                data = gasService.selectGasByFilterEq(gas);
            }

            System.out.println(gas);
            System.out.println("22");

        }
        for(Gas tmp: data){
            tmp.gasIdGenerator();
        }
       // System.out.println(data);
        baseResponse.setData(data);
        return baseResponse;
    }

    @GetMapping("/page/{pageNumber}")
    @ResponseBody
    public BaseResponse gasQuery(@PathVariable String pageNumber){
        int pageSize = 10;
        BaseResponse baseResponse = new BaseResponse();
        if(pageNumber.equals("all")){
            ArrayList<Gas> gases = gasService.selectAll();

            for(Gas gas : gases){
                gas.gasIdGenerator();
            }

            baseResponse.setData(gases);
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

    @GetMapping("/null")
    @ResponseBody
    public BaseResponse gasIsNull(){
        BaseResponse baseResponse = new BaseResponse();
        ArrayList<Gas> gases = gasService.selectAllNullGas();
        System.out.println(gases);
        baseResponse.setData(gases);
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
