package io.skai.okta.internshipstreamingserviceparserxml.services;

import io.skai.okta.internshipstreamingserviceparserxml.dto.Item;
import io.skai.okta.internshipstreamingserviceparserxml.dto.Video;

public interface VideoMapper {

    Video map(Item item);

}
