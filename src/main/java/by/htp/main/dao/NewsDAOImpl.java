package by.htp.main.dao;

import by.htp.main.entity.News;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<News> listNews() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<News> theQuery =
                currentSession.createQuery("FROM News ORDER BY date DESC",
                        News.class);

        List<News> news = theQuery.getResultList();

        /*int pageSize = 3;
        Criteria criteria = currentSession.createCriteria(News.class);
        criteria.setFirstResult(0);
        criteria.setMaxResults(pageSize);
        List<News> firstPage = criteria.list();

        return firstPage;*/

        return news;
    }

    public void saveNews(News news) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(news);
    }

    public News getNews(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        News theNews = currentSession.get(News.class, theId);

        return theNews;
    }

    public void deleteNews(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery =
                currentSession.createQuery("delete from News where id_news=:newsId");
        theQuery.setParameter("newsId", id);

        theQuery.executeUpdate();

    }

    public void editNews(int id) {

    }
}
