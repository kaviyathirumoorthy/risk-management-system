package org.kaviya.riskmanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "external-api.alpha-vantage.api-key=test-api-key",
        "app.bootstrap-admin.enabled=false"
})
class RiskManagementSystemApplicationTests {

    @Test
    void contextLoads() {
    }

}