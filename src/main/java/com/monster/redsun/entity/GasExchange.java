package com.monster.redsun.entity;


import lombok.Data;

@Data
public class GasExchange {

  private long id;
  private String exTime;
  private String inTime;
  private long inputId;
  private long outputId;
  private long guestId;
  private double money;
  private String remark;

}
