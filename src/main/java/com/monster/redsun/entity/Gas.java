package com.monster.redsun.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class Gas {

  @JsonIgnore
  private long id;
  private String gasId;
  private Integer year;
  private Integer month;
  private Integer isNull;
  private Integer status;
  private String modifyTime;
  private String createTime;

  public void gasIdGenerater() {
    this.setGasId(String.format("LD%04d%02d%06d", this.year,this.month,this.id));
  }
}
