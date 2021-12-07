package io.skai.okta.internshipstreamingserviceparserxml.controllers;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;
import io.skai.okta.internshipstreamingserviceparserxml.services.LostFilmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class ItemController {
    private final LostFilmService lostFilmService;

    @GetMapping("item")
    public List<RssItem> getItem() {
        return lostFilmService.getItems();
    }

}
