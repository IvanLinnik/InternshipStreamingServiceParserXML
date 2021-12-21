package io.skai.okta.internshipstreamingserviceparserxml.controllers;

import io.skai.okta.internshipstreamingserviceparserxml.dto.ImdbJsonItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ombdFeignClient", url = "https://www.omdbapi.com/")
public interface OmdbController {

    @GetMapping()
    ImdbJsonItem getAdditionalInfo(@RequestParam("apikey") String apiKey,
                                   @RequestParam("t") String title,
                                   @RequestParam("Season") int seasonNumber,
                                   @RequestParam("Episode") int episodeNumber);

}
