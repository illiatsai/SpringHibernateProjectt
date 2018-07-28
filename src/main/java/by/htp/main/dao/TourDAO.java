package by.htp.main.dao;

import by.htp.main.entity.Tour;

import java.util.Date;
import java.util.List;

public interface TourDAO {
    List<Tour> listTours();
    void saveTour(Tour tour);
    public Tour getTour(int theId);
    void deleteTour(int id);
    void editTour(int id);
    List<Tour> getTourByPriceAndDate(int priceMin, int priceMax, Date startDate);
    List<Tour> getTourByDate(Date startDate);
}
