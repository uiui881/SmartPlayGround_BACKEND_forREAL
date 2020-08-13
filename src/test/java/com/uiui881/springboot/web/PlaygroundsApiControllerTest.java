package com.uiui881.springboot.web;


import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.playgrounds.PlaygroundsRepository;
import com.uiui881.springboot.web.dto.PlaygroundsSaveRequestDto;
import com.uiui881.springboot.web.dto.PlaygroundsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlaygroundsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PlaygroundsRepository playgroundsRepository;

    @After
    public void tearDown() throws Exception{
        playgroundsRepository.deleteAll();
    }

    @Test
    public void Playgrounds_등록된다() throws Exception{
        String name ="놀이터1 이름";
        double minLatitude =1.0;
        double maxLatitude =3.0;
        double minLongitude =1.0;
        double maxLongitude =3.0;
        int congestion = 7;
        String writer ="김소림";

        PlaygroundsSaveRequestDto requestDto = PlaygroundsSaveRequestDto.builder()
                .name(name).minLatitude(minLatitude).maxLatitude(maxLatitude)
                .minLongitude(minLongitude).maxLongitude(maxLongitude).congestion(congestion)
                .writer(writer).build();

        String url ="http://localhost:"+port+"/api/v1/playgrounds";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Playgrounds> all = playgroundsRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getMinLatitude()).isEqualTo(minLatitude);
        assertThat(all.get(0).getMaxLatitude()).isEqualTo(maxLatitude);
        assertThat(all.get(0).getMinLongitude()).isEqualTo(minLongitude);
        assertThat(all.get(0).getMaxLongitude()).isEqualTo(maxLongitude);
        assertThat(all.get(0).getCongestion()).isEqualTo(congestion);
        assertThat(all.get(0).getWriter()).isEqualTo(writer);

    }

    @Test
    public void Playgrounds_수정된다() throws Exception{
        Playgrounds savedPlaygrounds = playgroundsRepository.save(Playgrounds.builder().name("놀이터1 이름")
        .minLatitude(1).maxLatitude(3).minLongitude(1).maxLongitude(3).congestion(3).writer("김소림").build());

        Long updateId = savedPlaygrounds.getPlaygroundId();
        double expectedMinLatitude =2;
        double expectedMaxLatitude =4;
        double expectedMinLongitude =2;
        double expectedMaxLongitude =4;
        int expectedCongestion = 19;

        PlaygroundsUpdateRequestDto requestDto = PlaygroundsUpdateRequestDto.builder()
                .minLatitude(expectedMinLatitude).maxLatitude(expectedMaxLatitude)
                .minLongitude(expectedMinLongitude).maxLongitude(expectedMaxLongitude)
                .congestion(expectedCongestion)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        //when
        HttpEntity<PlaygroundsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Playgrounds> all = playgroundsRepository.findAll();
        assertThat(all.get(0).getMinLatitude()).isEqualTo(expectedMinLatitude);
        assertThat(all.get(0).getMaxLatitude()).isEqualTo(expectedMaxLatitude);
        assertThat(all.get(0).getMinLongitude()).isEqualTo(expectedMinLongitude);
        assertThat(all.get(0).getMaxLongitude()).isEqualTo(expectedMaxLongitude);
        assertThat(all.get(0).getCongestion()).isEqualTo(expectedCongestion);
    }
}
