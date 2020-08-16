package com.uiui881.springboot.domain.rides;


import com.uiui881.springboot.domain.playgrounds.Playgrounds;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RidesRepositoryTest {

    @Autowired
    RidesRepository ridesRepository;

    @After
    public void cleanup(){
        ridesRepository.deleteAll();
    }

    @Test
    public void 놀이기구상태저장_불러오기(){
        String rideName ="그네";
        int rideCongestion = 19;
        Playgrounds playground = new Playgrounds();

        ridesRepository.save(Rides.builder().rideName(rideName).playground(playground).rideCongestion(rideCongestion).build());

        List<Rides> ridesList = ridesRepository.findAll();

        Rides rides = ridesList.get(0);
        assertThat(rides.getRideName()).isEqualTo(rideName);
        assertThat(rides.getRideCongestion()).isEqualTo(rideCongestion);
        assertThat(rides.getPlayground()).isEqualTo(playground);


    }

}
