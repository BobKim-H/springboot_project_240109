package com.sbs.exam.sb_app_2024_01_09.home.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  @RequestMapping("/usr/home/getString")
  @ResponseBody
  public String getString() {
    return "HI";
  }
  @RequestMapping("/usr/home/getInt")
  @ResponseBody
  public int getInt() {
    return 10;
  }

  @RequestMapping("/usr/home/getFloat")
  @ResponseBody
  public float getFloat() {
    return 10.5f;
  }

  @RequestMapping("/usr/home/getDouble")
  @ResponseBody
  public Double getDouble() {
    return 10.5;
  }

  @RequestMapping("/usr/home/getBoolean")
  @ResponseBody
  public boolean getBoolean() {
    return true;
  }

  @RequestMapping("/usr/home/getCharacter")
  @ResponseBody
  public char getCharacter() {
    return 'a';
  }
  @RequestMapping("/usr/home/getMap")
  @ResponseBody
  public Map<String, Object> getMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("철수나이", 22);
    map.put("영희나이", 18);
    return map;
  }
  @RequestMapping("/usr/home/getList")
  @ResponseBody
  public List<String> getList() {
    List<String> list = new ArrayList<>();
    list.add("철수");
    list.add("영희");
    return list;
  }
  @RequestMapping("/usr/home/getArticle")
  @ResponseBody
  public Article getArticle() {
    Article article = new Article(1, "제목");
    return article;
  }

  @RequestMapping("/usr/home/getArticles")
  @ResponseBody
  public List<Article> getArticles() {
    Article article1 = new Article(1, "제목1");
    Article article2 = new Article(2, "제목2");

    List<Article> list = new ArrayList<>();
    list.add(article1);
    list.add(article2);
    return list;
    //객체, Map = {} 으로 표현 됨
    //array, list = [] 으로 표현 됨
  }

  @Data //setter getter 자동 적용
  @NoArgsConstructor //파라미터 안받는 생성자를 만듬
  @AllArgsConstructor //변수를 모두 파라미터로 받는 생성자를 만듬
  class Article {

    public int id;
    public String title;

  }

  @RequestMapping("/usr/home/doSetCount")
  @ResponseBody
  public String doSetCount(@RequestParam("count") int count) {
    //3.2 스프링 부트부터 파라미터 이름 적용해줘야 함. ITJ는 설정에 저거 그냥 해주는 옵션이 있어서 일단 둘다 해놓음
    this.count=count;
    return "count 값이 " + this.count + "으로 초기화 되었습니다";
  }
}
