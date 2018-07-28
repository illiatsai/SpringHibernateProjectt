package by.htp.main.dao;

import by.htp.main.entity.News;

import java.util.List;

public interface NewsDAO {
    List<News> listNews();
    void saveNews(News news);
    public News getNews(int theId);
    void deleteNews(int id);
    void editNews(int id);
}
