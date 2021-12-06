package io.skai.okta.internshipstreamingserviceparserxml.item;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public Item getItem() {
        return new Item(
                "Великая (The Great). Животные позывы. (S02E05)",
                "<![CDATA[ <img src=\"//static.lostfilm.top/Images/509/Posters/image.jpg\" alt=\"\" /><br /> ]]>",
                "Sun, 05 Dec 2021 20:57:00 +0000",
                "https://www.lostfilmtv1.site/mr/series/The_Great/season_2/episode_5/"
        );
    }

}
