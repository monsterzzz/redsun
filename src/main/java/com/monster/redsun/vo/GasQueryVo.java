package com.monster.redsun.vo;

import com.monster.redsun.entity.Gas;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data()
public class GasQueryVo extends Gas {

    String gasId;

}
