package com.uiui881.springboot.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.playgrounds.PlaygroundsRepository;
import com.uiui881.springboot.domain.rides.Rides;
import com.uiui881.springboot.domain.rides.RidesRepository;
import com.uiui881.springboot.web.rides.dto.RidesSaveRequestDto;
import com.uiui881.springboot.web.rides.dto.RidesUpdateRequestDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RidesApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RidesRepository ridesRepository;

    @Autowired
    private PlaygroundsRepository playgroundsRepository;

    @Autowired
    private WebApplicationContext context;//

    private MockMvc mvc;//

    @Before //
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }


    @After
    public void tearDown() throws Exception{
        ridesRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="CHILD")
    public void Rides_등록된다() throws Exception{
        String rideName = "그네";
        int rideCongestion =19;

        playgroundsRepository.save(Playgrounds.builder().name("놀이터1").minLatitude(15.0).maxLatitude(20.0)
        .minLongitude(15.0).maxLongitude(20.0).congestion(21).writer("놀이터1작성자").build());

        List<Playgrounds> playgroundsList = playgroundsRepository.findAll();

        Playgrounds playground = playgroundsList.get(0);

        RidesSaveRequestDto requestDto = RidesSaveRequestDto.builder().rideName(rideName)
                .id_p(id_p).rideCongestion(rideCongestion).build();

        String url ="http://localhost:" + port + "/api/v1/rides";

        mvc.perform(post(url)
               .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto))).andExpect(status().isOk()); ///


      //  ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

      //  assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
       // assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Rides> all = ridesRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
        assertThat(all.get(0).getRideName()).isEqualTo(rideName);
        assertThat(all.get(0).getRideCongestion()).isEqualTo(rideCongestion);
        assertThat(all.get(0).getPlayground().getName()).isEqualTo("놀이터1");
        assertThat(all.get(0).getPlayground().getMinLatitude()).isEqualTo(15);
        assertThat(all.get(0).getPlayground().getMaxLatitude()).isEqualTo(20);
        assertThat(all.get(0).getPlayground().getCongestion()).isEqualTo(21);
    }

    @Test
    @WithMockUser(roles="CHILD")
    public void Rides_수정된다() throws Exception{
        playgroundsRepository.save(Playgrounds.builder().name("놀이터1").minLatitude(15.0).maxLatitude(20.0)
                .minLongitude(15.0).maxLongitude(20.0).congestion(21).writer("놀이터1작성자").build());

        List<Playgrounds> playgroundsList = playgroundsRepository.findAll();

        Playgrounds playground = playgroundsList.get(0);

       Rides savedRides = ridesRepository.save(Rides.builder().rideName("그네").playground(playground)
       .rideCongestion(19).build());

      Long updateId = savedRides.getId_r();
      int expectedRideCongestion = 200;

        RidesUpdateRequestDto requestDto = RidesUpdateRequestDto.builder().rideCongestion(expectedRideCongestion)
                .build();

        String url ="http://localhost:"+port+"/api/v1/rides/"+updateId;

        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto))).andExpect(status().isOk());

        List<Rides> all = ridesRepository.findAll();
        assertThat(all.get(0).getRideCongestion()).isEqualTo(expectedRideCongestion);


    }
}
