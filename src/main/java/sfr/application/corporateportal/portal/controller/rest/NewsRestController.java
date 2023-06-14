package sfr.application.corporateportal.portal.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sfr.application.corporateportal.portal.entity.NewsEntity;
import sfr.application.corporateportal.portal.service.NewsService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsRestController {
    private final NewsService newsService;

    @RequestMapping(value = {"/get/all/{page}"}, method = RequestMethod.POST)
    @ResponseBody
    public Page<NewsEntity> GetAllUsers(@PathVariable Integer page) {

        return newsService.getAllNews(PageRequest.of(page, 5, Sort.by("creationDate").descending()));
    }
}
