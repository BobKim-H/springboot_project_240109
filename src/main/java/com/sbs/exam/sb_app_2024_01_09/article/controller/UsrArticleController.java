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

  private List<Article> articles;
  int articleLastId;

  public UsrArticleController() {
    articles = new ArrayList<>();
    articleLastId = 0;

    makeTestData(); 
  }

  private void makeTestData() {
    for(int i =1; i<=10; i++) {

      String title = "제목" + i;
      String body = "내용" + i;

      writeArticle(title,body);

    }

  }

  @RequestMapping("/usr/article/getArticles")
  @ResponseBody
  public List<Article> getArticles() {

    return articles;

  }

  @RequestMapping("/usr/article/doAdd")
  @ResponseBody
  public Article doAdd(String title, String body) {
    Article article = writeArticle(title, body);

    return article;

  }

  private Article writeArticle(String title, String body) {
    int id = articleLastId +1 ;
    Article article = new Article(id, title, body);


    articles.add(article);
    articleLastId=id;

    return article;
  }

}
