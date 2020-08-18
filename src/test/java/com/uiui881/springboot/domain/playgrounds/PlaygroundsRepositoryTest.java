package com.uiui881.springboot.domain.playgrounds;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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
        double minLatitude =1.0;
        double maxLatitude =3.0;
        double minLongitude =1.0;
        double maxLongitude =3.0;
        int congestion = 7;
        String writer ="김소림";

        playgroundsRepository.save(Playgrounds.builder().name(name)
                .minLatitude(minLatitude).maxLatitude(maxLatitude)
                .minLongitude(minLongitude).maxLongitude(maxLongitude)
                        .congestion(congestion).writer(writer).build());

        List<Playgrounds> playgroundsList = playgroundsRepository.findAll();

        Playgrounds playgrounds = playgroundsList.get(0);
        assertThat(playgrounds.getName()).isEqualTo(name);
        assertThat(playgrounds.getMinLatitude()).isEqualTo(minLatitude);
        assertThat(playgrounds.getMaxLatitude()).isEqualTo(maxLatitude);
        assertThat(playgrounds.getMinLongitude()).isEqualTo(minLongitude);
        assertThat(playgrounds.getMaxLongitude()).isEqualTo(maxLongitude);
        assertThat(playgrounds.getCongestion()).isEqualTo(congestion);
        assertThat(playgrounds.getWriter()).isEqualTo(writer);

    }

    @Test
    public void BaseTimeEntity_등록() {
        String name ="놀이터1 이름";
        double minLatitude =1.0;
        double maxLatitude =3.0;
        double minLongitude =1.0;
        double maxLongitude =3.0;
        int congestion = 7;
        String writer ="김소림";

        LocalDateTime now = LocalDateTime.of(2020, 8, 13, 0, 0, 0);
        playgroundsRepository.save(Playgrounds.builder().name(name)
                .minLatitude(minLatitude).maxLatitude(maxLatitude)
                .minLongitude(minLongitude).maxLongitude(maxLongitude)
                .congestion(congestion).writer(writer).build());

        List<Playgrounds> playgroundsList = playgroundsRepository.findAll();

        Playgrounds playgrounds = playgroundsList.get(0);
        //System.out.println(">>>>>>>>> createdDate=" + playgrounds.getCreatedDate() + ", modifiedDate=" + playgrounds.getModifiedDate());

        ///assertThat(playgrounds.getCreatedDate()).isAfter(now);
        //assertThat(playgrounds.getModifiedDate()).isAfter(now);
    }
}
