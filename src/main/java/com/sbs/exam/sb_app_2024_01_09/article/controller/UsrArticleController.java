package com.sbs.exam.sb_app_2024_01_09.article.controller;

import com.sbs.exam.sb_app_2024_01_09.article.vo.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class UsrArticleController {

  // 인스턴스 변수 시작
  private List<Article> articles;
  int articleLastId;
  // 인스턴스 변수 끝

  // 생성자
  public UsrArticleController() {
    articles = new ArrayList<>();
    articleLastId = 0;

    makeTestData(); 
  }

  //서비스 메소드 시작
  private void makeTestData() {
    for(int i =1; i<=10; i++) {

      String title = "제목" + i;
      String body = "내용" + i;

      writeArticle(title,body);

    }

  }

  private Article getArticle(int id) {
    for (Article article: articles) {
      if (article.getId() == id) {
        return article;
      }
    }
    return null;
  }
  private Article writeArticle(String title, String body) {
    int id = articleLastId +1 ;
    Article article = new Article(id, title, body);


    articles.add(article);
    articleLastId=id;

    return article;
  }
  //서비스 메서드 끝

  //액션 메서드 시작
  @RequestMapping("/usr/article/doAdd")
  @ResponseBody
  public Article doAdd(String title, String body) {
    Article article = writeArticle(title, body);

    return article;

  }
  @RequestMapping("/usr/article/getArticles")
  @ResponseBody
  public List<Article> getArticles() {

    return articles;

  }

  @RequestMapping("/usr/article/doDelete")
  @ResponseBody
  public String doDelete(int id) {
    Article article = getArticle(id);


    if ( article == null) {
      return id + "번 게시물이 없습니다";
    }
    deleteArticle(id);
    return id + "번 게시물을 삭제하였습니다.";
  }

  private void deleteArticle(int id) {
    Article article = getArticle(id);
    articles.remove(article);
  }


//액션 메서드 끝




}
