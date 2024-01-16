package com.sbs.exam.sb_app_2024_01_09.article.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //setter getter 자동 적용
@NoArgsConstructor //파라미터 안받는 생성자를 만듬
@AllArgsConstructor //변수를 모두 파라미터로 받는 생성자를 만듬
public class Article {

    public int id;
    public String title;
    public String body;

}
