package by.htp.main.controller;

import by.htp.main.entity.Tour;
import by.htp.main.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/main/tours")
@SessionAttributes(types = Tour.class)
public class    TourController {

    @Autowired
    private TourService tourService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/searchTour")
    public String listNews(Model theModel) {

        List<Tour> tours = tourService.listTours();

        theModel.addAttribute("tours", tours);

        return "search-tour";
    }

    @RequestMapping(value="/searchTourByCriteria")
    public String searchTourByCriteria(@RequestParam("startDate") Date startDate,
                             @RequestParam("priceMin") int priceMin,
                             @RequestParam("priceMax") int priceMax,
                             Model theModel) {

        /*if(startDate.toString().trim().compareTo("") == 0){
            startDate = null;
        }

        if(priceMin == 0){
            startDate = null;
        }

        if(priceMax == 0){
            startDate = null;
        }
*/


            List<Tour> tours =  tourService.getTourByPriceAndDate(priceMin, priceMax, startDate);

        theModel.addAttribute("tours", tours);
        theModel.addAttribute("priceMin", priceMin);
        theModel.addAttribute("priceMax", priceMax);
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        theModel.addAttribute("startDate", df.format(startDate));


        return "search-tour";
    }
}
