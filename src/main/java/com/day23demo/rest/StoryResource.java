package com.day23demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.day23demo.domain.Asset;
import com.day23demo.domain.Story;
import com.day23demo.domain.StoryVo;
import com.day23demo.domain.Timeline;
import com.day23demo.repository.StoryRepository;

@Controller
@RequestMapping("/stories")
public class StoryResource {

    private StoryRepository storyRepository;

    @Autowired
    public StoryResource(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> submitStory(@RequestBody Story story) {
        Story storyWithExtractedInformation = decorateWithInformation(story);
        storyRepository.save(storyWithExtractedInformation);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Timeline timeline() {
        List<Story> stories = storyRepository.findAll();
        return new Timeline("30 Technologies in 30 Days -- By Shekhar Gulati", "Learn 30 Technologies in 30 Days",
                "2013,10,29", stories);
    }


    private Story decorateWithInformation(Story story) {
        String url = story.getUrl();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StoryVo> forEntity = restTemplate.getForEntity(
                "http://gooseextractor-t20.rhcloud.com/api/v1/extract?url=" + url, StoryVo.class);
        if (forEntity.hasBody()) {
            StoryVo storyVo = forEntity.getBody();
            return new Story(url,storyVo.getTitle(),storyVo.getText(),story.getStartDate(),new Asset(storyVo.getImage()));
        }
        return story;

    }

}
