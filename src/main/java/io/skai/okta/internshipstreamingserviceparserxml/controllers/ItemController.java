package io.skai.okta.internshipstreamingserviceparserxml.controllers;

import io.skai.okta.internshipstreamingserviceparserxml.dto.RssItem;
import io.skai.okta.internshipstreamingserviceparserxml.services.LostFilmService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
@Slf4j
public class ItemController {
    private final LostFilmService lostFilmService;

    @PostMapping("/new")
    public void createItem(@RequestBody RssItem rssItem) {
        lostFilmService.createItem(rssItem);
    }

    @GetMapping()
    public List<RssItem> getItems() {
        return lostFilmService.getItems();
    }

    @GetMapping("/{id}")
    public RssItem getItem(@PathVariable Long id) {
        return lostFilmService.getItem(id);
    }

//    @GetMapping("/lostfilm")
//    public List<RssItem> getItemsFromURL() {
//        return lostFilmService.getNewItems();
//    }

    @PostMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody RssItem rssItem) {
        lostFilmService.update(id, rssItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        lostFilmService.delete(id);
    }

}
