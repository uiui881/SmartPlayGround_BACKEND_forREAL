package com.uiui881.springboot.domain.playgrounds;


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
public class PlaygroundsRepositoryTest {

    @Autowired
    PlaygroundsRepository playgroundsRepository;

    @After
    public void cleanup(){
        playgroundsRepository.deleteAll();
    }

    @Test
    public void 놀이터저장및불러오기(){
        String name ="놀이터1 이름";
        String address ="놀이터1 주소";
        int congestion = 7;

        playgroundsRepository.save(Playgrounds.builder().name(name)
                .address(address).congestion(congestion).build());

        List<Playgrounds> playgroundsList = playgroundsRepository.findAll();

        Playgrounds playgrounds = playgroundsList.get(0);
        assertThat(playgrounds.getName()).isEqualTo(name);
        assertThat(playgrounds.getAddress()).isEqualTo(address);
        assertThat(playgrounds.getCongestion()).isEqualTo(congestion);

    }
}
