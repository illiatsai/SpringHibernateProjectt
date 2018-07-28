package by.htp.main.service;

import by.htp.main.dao.TourDAO;
import by.htp.main.entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TourServiceImpl implements TourService{

    @Autowired
    private TourDAO tourDAO;

    @Override
    public List<Tour> listTours() {
        return tourDAO.listTours();
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
        return tourDAO.getTourByPriceAndDate(priceMin, priceMax, startDate);
    }

    @Override
    public List<Tour> getTourByDate(Date startDate) {
        return tourDAO.getTourByDate(startDate);
    }


}
