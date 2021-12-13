package io.skai.okta.internshipstreamingserviceparserxml.controllers;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
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
    public void createEpisode(@RequestBody Episode episode) {
        lostFilmService.createEpisode(episode);
    }

    @GetMapping()
    public List<Episode> getEpisodes() {
        return lostFilmService.getEpisodes();
    }

    @GetMapping("/{id}")
    public Episode getEpisode(@PathVariable Long id) {
        return lostFilmService.getEpisode(id);
    }

    @PostMapping("/{id}")
    public void updateEpisode(@PathVariable Long id, @RequestBody Episode episode) {
        lostFilmService.updateEpisode(id, episode);
    }

    @DeleteMapping("/{id}")
    public void deleteEpisode(@PathVariable Long id) {
        lostFilmService.deleteEpisode(id);
    }

}
