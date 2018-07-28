package by.htp.main.dao;

import by.htp.main.entity.Tour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TourDAOImpl implements TourDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tour> listTours() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Tour> theQuery =
                currentSession.createQuery("FROM Tour ORDER BY start_date DESC",
                        Tour.class);

        List<Tour> news = theQuery.getResultList();

        return news;
    }

    @Override
    public void saveTour(Tour tour) {

    }

    @Override
    public Tour getTour(int theId) {
        return null;
    }

    @Override
    public void deleteTour(int id) {

    }

    @Override
    public void editTour(int id) {

    }

    @Override
    public List<Tour> getTourByPriceAndDate(int priceMin, int priceMax, Date startDate) {
        Session currentSession = sessionFactory.getCurrentSession();

        /*Query theQuery =
        currentSession.createQuery("FROM Tour where price>=:priceMin AND price<=:priceMax AND start_date=:startDate ORDER BY start_date ASC");*/

        Query theQuery;

        if (startDate != null) {
            if (priceMin != 0 && priceMax != 0) {
                theQuery =
                        currentSession.createQuery("FROM Tour where price>=:priceMin AND price<=:priceMax AND start_date=:startDate ORDER BY start_date ASC");
                theQuery.setParameter("priceMin", priceMin);
                theQuery.setParameter("priceMax", priceMax);
                theQuery.setParameter("startDate", startDate);
            } else if (priceMin == 0 && priceMax != 0) {
                theQuery =
                        currentSession.createQuery("FROM Tour where price<=:priceMax AND start_date=:startDate ORDER BY start_date ASC");
                theQuery.setParameter("priceMax", priceMax);
                theQuery.setParameter("startDate", startDate);
            } else if (priceMin != 0 && priceMax == 0) {
                theQuery =
                        currentSession.createQuery("FROM Tour where price>=:priceMin AND start_date=:startDate ORDER BY start_date ASC");
                theQuery.setParameter("priceMin", priceMin);
                theQuery.setParameter("startDate", startDate);
            } else {
                theQuery =
                        currentSession.createQuery("FROM Tour where start_date=:startDate ORDER BY start_date ASC");
                theQuery.setParameter("startDate", startDate);
            }
        } else {
            if (priceMin != 0 && priceMax != 0) {
                theQuery =
                        currentSession.createQuery("FROM Tour where price>=:priceMin AND price<=:priceMax ORDER BY start_date ASC");
                theQuery.setParameter("priceMin", priceMin);
                theQuery.setParameter("priceMax", priceMax);
            } else if (priceMin == 0 && priceMax != 0) {
                theQuery =
                        currentSession.createQuery("FROM Tour where price<=:priceMax ORDER BY price ASC");
                theQuery.setParameter("priceMax", priceMax);
            } else if (priceMin != 0 && priceMax == 0) {
                theQuery =
                        currentSession.createQuery("FROM Tour where price>=:priceMin ORDER BY price ASC");
                theQuery.setParameter("priceMin", priceMin);
            } else {
                theQuery =
                        currentSession.createQuery("FROM Tour ORDER BY start_date ASC",
                                Tour.class);
            }
        }
        List<Tour> news = theQuery.getResultList();

        return news;
    }

    @Override
    public List<Tour> getTourByDate(Date startDate) {
        return null;
    }
}
