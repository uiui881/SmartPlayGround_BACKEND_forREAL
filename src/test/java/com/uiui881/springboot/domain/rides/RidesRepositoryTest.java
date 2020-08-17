package com.uiui881.springboot.domain.rides;


import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import com.uiui881.springboot.domain.playgrounds.PlaygroundsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RidesRepositoryTest {

    @Autowired
    RidesRepository ridesRepository;

    @Autowired
    PlaygroundsRepository playgroundsRepository;

    @After
    public void cleanup(){
        ridesRepository.deleteAll();
    }

    @Test
    public void 놀이기구상태저장_불러오기(){
        String rideName ="그네";
        int rideCongestion = 19;

        String name = "놀이터 이름1";
        double minLatitude = 11.0;
        double maxLatitude = 13.0;
        double minLongitude = 11.0;
        double maxLongitude = 13.0;
        int congestion = 19;
        String writer = "놀이터 작성자1";

        playgroundsRepository.save(Playgrounds.builder().name(name).minLatitude(minLatitude).maxLatitude(maxLatitude)
        .minLongitude(minLongitude).maxLongitude(maxLongitude).congestion(congestion).writer(writer).build());

        List<Playgrounds> playgroundsList = playgroundsRepository.findAll();

        Playgrounds playground = playgroundsList.get(0);

        ridesRepository.save(Rides.builder().rideName(rideName).playground(playground).rideCongestion(rideCongestion).build());

        List<Rides> ridesList = ridesRepository.findAll();

        Rides rides = ridesList.get(0);
        assertThat(rides.getRideName()).isEqualTo(rideName);
        assertThat(rides.getRideCongestion()).isEqualTo(rideCongestion);
        assertThat(rides.getPlayground().getName()).isEqualTo(playground.getName());
        assertThat(rides.getPlayground().getMinLatitude()).isEqualTo(playground.getMinLatitude());
        assertThat(rides.getPlayground().getMaxLatitude()).isEqualTo(playground.getMaxLatitude());
        assertThat(rides.getPlayground().getMinLongitude()).isEqualTo(playground.getMinLongitude());
        assertThat(rides.getPlayground().getMaxLongitude()).isEqualTo(playground.getMaxLongitude());
        assertThat(rides.getPlayground().getWriter()).isEqualTo(playground.getWriter());
        assertThat(rides.getPlayground().getCongestion()).isEqualTo(playground.getCongestion());

        // assertThat(rides.getPlayground()).isEqualTo(playground); 하면 오류 뜸

    }

}
