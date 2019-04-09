package at.nacs.duchman.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;


@SpringBootTest(webEnvironment = NONE)
class DeadMansChestTest {


    @Autowired
    DeadMansChest deadMansChest;

    @Test
    void Item() {
        deadMansChest.setItem("Yellow Diamond");
        String item = deadMansChest.getItem();

        Assertions.assertThat(item).isEqualTo("Yellow Diamond");

    }

}