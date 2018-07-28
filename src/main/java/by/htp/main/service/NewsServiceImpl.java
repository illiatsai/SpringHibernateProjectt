package by.htp.main.service;


import by.htp.main.dao.NewsDAO;
import by.htp.main.entity.News;
/*import by.htp.main.repo.NewsRepo;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Transactional
    public List<News> listNews() {
        return newsDAO.listNews();
    }

    @Transactional
    public void saveNews(News news) {
        newsDAO.saveNews(news);
    }

    @Transactional
    public News getNews(int theId) {
        return newsDAO.getNews(theId);
    }

    @Transactional
    public void deleteNews(int id) {
        newsDAO.deleteNews(id);
    }

    @Transactional
    public void editNews(int id) {

    }

    /*private static final int PAGE_SIZE = 50;

    @Inject
    private NewsRepo newsRepo;
    @Transactional
    public Page<News> getNewsPagination(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return newsRepo.findAll(request);
    }*/
}
