package by.htp.main.service;

import by.htp.main.entity.News;

import java.util.List;

public interface NewsService {
    List<News> listNews();
    void saveNews(News news);
    public News getNews(int theId);
    void deleteNews(int id);
    void editNews(int id);
    /*public Page<News> getNewsPagination(Integer pageNumber);*/
}

