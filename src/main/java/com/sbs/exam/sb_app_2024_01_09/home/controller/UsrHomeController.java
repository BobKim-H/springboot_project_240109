package com.sbs.exam.sb_app_2024_01_09.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
  int count;
  public UsrHomeController() {
    count = -1;
  }

  @RequestMapping("/usr/home/getCount")
  @ResponseBody
  public int getCount() {
     return count;
  }
  @RequestMapping("/usr/home/doSetCount")
  @ResponseBody
  public String doSetCount(@RequestParam("count") int count) {
    //3.2 스프링 부트부터 파라미터 이름 적용해줘야 함. ITJ는 설정에 저거 그냥 해주는 옵션이 있어서 일단 둘다 해놓음
    this.count=0;
    return "count 값이 " + this.count + "으로 초기화 되었습니다";
  }
}
