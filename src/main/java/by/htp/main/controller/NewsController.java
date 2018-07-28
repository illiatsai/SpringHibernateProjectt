package by.htp.main.controller;

import by.htp.main.entity.Customer;
import by.htp.main.entity.News;
import by.htp.main.entity.Tags;
import by.htp.main.service.CustomerService;
import by.htp.main.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/main")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    /*@RequestMapping("/news")
    public String listNews(Model theModel) {

        List<News> theNews = newsService.listNews();

        theModel.addAttribute("news", theNews);

        return "main";*/

    @RequestMapping(value="/news")
    public ModelAndView listNews(@RequestParam(required = false) Integer page) {
       ModelAndView modelAndView = new ModelAndView("main");

        List<News> theNews = newsService.listNews();

        PagedListHolder<News> pagedListHolder = new PagedListHolder<>(theNews);
        pagedListHolder.setPageSize(5);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            modelAndView.addObject("news", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            modelAndView.addObject("news", pagedListHolder.getPageList());
        }

        return modelAndView;
    }


    @GetMapping("/newsDetails")
    public String newsDetails(@RequestParam("newsId") int theId,
                              Model theModel) {

        News newsOne = newsService.getNews(theId);
        String metaTags = "";
        if (newsOne.getTags().size() > 0) {
            List<Tags> tags = newsOne.getTags();
            for (Tags tag : tags) {
                metaTags = metaTags.concat(tag.getTag() + ", ");
            }
            metaTags = metaTags.substring(0, metaTags.lastIndexOf(','));
        }
        theModel.addAttribute("news", newsOne);
        theModel.addAttribute("meta", metaTags);

        return "newsDetails";
    }

    @GetMapping("/formAddNews")
    public String showFormForAdd(Model theModel) {

        News theNews = new News();

        theModel.addAttribute("news", theNews);

        return "add-news";
    }

    @PostMapping("/saveNews")
    public String saveNews(@ModelAttribute("news") News theNews) {

        //сделать таги через дропдаун лист
        /*List<Tags> tagList = new ArrayList<>();
        Tags tag = new Tags();
        tag.setTag("отдых");
        tagList.add(tag);
        theNews.setTags(tagList);*/

        newsService.saveNews(theNews);

        return "redirect:/main/news";
    }

    @GetMapping("/deleteNews")
    public String deleteNews(@RequestParam("newsId") int theId) {

        newsService.deleteNews(theId);

        return "redirect:/main/news";
    }
}
