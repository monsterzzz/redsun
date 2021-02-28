package com.monster.redsun.DTO.Gas;

import com.monster.redsun.entity.Gas;
import lombok.Data;

@Data
public class GasNewDTO {
    private Integer number;
    private Gas gas;

    public Gas getGas(){
        Gas gas = new Gas();
        gas.setYear(this.gas.getYear());
        gas.setMonth(this.gas.getMonth());
        gas.setIsNull(this.gas.getIsNull());
        return gas;
    }

}
