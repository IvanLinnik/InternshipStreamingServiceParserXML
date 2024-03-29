package io.skai.okta.internshipstreamingserviceparserxml.quartz;

import io.skai.okta.internshipstreamingserviceparserxml.services.DataParser;
import io.skai.okta.internshipstreamingserviceparserxml.services.VideoService;
import io.skai.okta.internshipstreamingserviceparserxml.services.converter.EpisodeConverter;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckUpdateJob implements Job {
    private final VideoService videoService;
    private final DataParser dataParser;
    private final EpisodeConverter episodeConverter;

    @Override
    public void execute(JobExecutionContext context) {
        dataParser.getNewItems()
                  .stream()
                  .map(episodeConverter::convert)
                  .forEach(videoService::saveEpisode);
    }
}
