package io.skai.okta.internshipstreamingserviceparserxml.controllers;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.services.VideoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
@AllArgsConstructor
@Slf4j
public class EpisodesController {
    private final VideoService videoService;

//    @PostMapping("/new")
//    public void createEpisode(@RequestBody LostFilmRssItem lostFilmRssItem) {
//        videoService.create(lostFilmRssItem);
//    }

    @GetMapping()
    public List<Episode> getEpisodes() {
        return videoService.getAll();
    }

    @GetMapping("/{link}")
    public Episode getEpisode(@PathVariable String link) {
        return videoService.get(link);
    }

//    @PostMapping("/{id}")
//    public void updateEpisode(@PathVariable Long id, @RequestBody Episode episode) {
//        videoService.update(id, episode);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteEpisode(@PathVariable Long id) {
//        videoService.delete(id);
//    }

}
