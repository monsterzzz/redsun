package com.monster.redsun.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monster.redsun.entity.Gas;
import com.monster.redsun.entity.Guest;
import com.monster.redsun.exception.GuestHasBeenExistException;
import com.monster.redsun.service.GuestService;
import com.monster.redsun.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    GuestService guestService;

    @PostMapping("/add")
    @ResponseBody
    public BaseResponse addGuest(@RequestBody Guest guest){
        BaseResponse response = new BaseResponse();
        try {
            Long id = guestService.insertOne(guest);
            System.out.println(guest);
            guest.setId(id);
            System.out.println(guest);
            response.setData(guest);
        } catch (GuestHasBeenExistException e) {
            e.printStackTrace();
            response.setErrorCode(100);
        }
        return response;

    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public BaseResponse deleteGuest(@PathVariable Long id){
        BaseResponse response = new BaseResponse();
        if(guestService.deleteOneById(id) == 0){
            response.setData("删除成功!");
        }else {
            response.setData("删除失败!");
        }
        return response;
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResponse updateGuest(@RequestBody Guest guest){
        BaseResponse response = new BaseResponse();
        if(!guestService.updateGuest(guest)){
            response.setData("修改成功!");
        }else {
            response.setData("修改失败!");
        }

        return response;

    }

    @GetMapping("/page/{pageNumber}")
    @ResponseBody
    public BaseResponse guestQuery(@PathVariable String pageNumber){
        int pageSize = 10;
        BaseResponse baseResponse = new BaseResponse();
        if(pageNumber.equals("all")){
            baseResponse.setData(guestService.selectAll());
            return baseResponse;
        }
        IPage<Guest> guestPage;
        try {
            Integer number = new Integer(pageNumber);
            guestPage = guestService.selectPageVo(new Page<>(number,pageSize));
        }catch (NumberFormatException e){
            System.out.println(e);
            baseResponse.setErrorCode(311);
            guestPage = null;
        }
        baseResponse.setData(guestPage);
        return baseResponse;
    }

}
