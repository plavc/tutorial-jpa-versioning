package net.plavcak.tutorial.tutorial.jpa.versioning.envers;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import net.plavcak.tutorial.tutorial.jpa.versioning.envers.model.Product;
import net.plavcak.tutorial.tutorial.jpa.versioning.envers.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"postgres", "sql-log"})
@SpringBootTest(properties = "org.hibernate.envers.audit_strategy=org.hibernate.envers.strategy.DefaultAuditStrategy")
class UpdateDefaultAuditStrategyTest {

    @Autowired
    private ShopService shopService;

    private Product product;

    @BeforeEach
    void setup() {
        product = shopService.product("Keyboard", 95.00);
    }

    @Test
    void updateSingleEntity() {
        product.setPrice(BigDecimal.valueOf(66.00));
        product = shopService.updateProduct(product);
        assertThat(product).isNotNull();
    }
}
