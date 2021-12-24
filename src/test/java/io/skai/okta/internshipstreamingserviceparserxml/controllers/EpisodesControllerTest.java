package io.skai.okta.internshipstreamingserviceparserxml.controllers;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Episode;
import io.skai.okta.internshipstreamingserviceparserxml.services.impl.LostFilmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EpisodesControllerTest {

    @InjectMocks
    private EpisodesController controller;

    @Mock
    LostFilmService service;

    @Test
    void testGetAllSuccessful() {
        controller.getEpisodes();
        verify(service).getAll();
    }

    @Test
    void testGetEpisodeSuccessful() {
        controller.getEpisode("link");
        verify(service).get("link");
    }

    @Test
    void testGetEpisodeThrowException() {
        assertThrows(NullPointerException.class,
                () -> controller.getEpisode(Episode.builder().build().getLink()));
    }

}