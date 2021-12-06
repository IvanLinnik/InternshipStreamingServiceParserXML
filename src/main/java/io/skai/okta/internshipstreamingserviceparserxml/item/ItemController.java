package io.skai.okta.internshipstreamingserviceparserxml.item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ItemController {

    private final ItemService service = new ItemService();

    @GetMapping("item")
    public Item getItem() {
        return service.getItem();
    }

}
