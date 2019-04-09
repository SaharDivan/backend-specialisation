package coffee.controller;

import org.junit.jupiter.api.Test;

class PublisherTest {

    @Test
    void publish() {
        Publisher.publishFinalStatistics(1);
    }
}