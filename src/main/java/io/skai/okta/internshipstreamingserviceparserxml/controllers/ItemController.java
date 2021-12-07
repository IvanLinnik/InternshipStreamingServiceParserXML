package io.skai.okta.internshipstreamingserviceparserxml.controllers;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Item;
import io.skai.okta.internshipstreamingserviceparserxml.services.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("item")
    public List<Item> getItem() {
        return itemService.getItem();
    }

}
