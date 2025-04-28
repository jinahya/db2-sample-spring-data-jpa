package com.github.jinahya.db2.sample.data.jpa.repository;

import com.github.jinahya.db2.sample.data.jpa.Product;
import com.github.jinahya.db2.sample.data.jpa.ProductSupplier;
import com.github.jinahya.db2.sample.data.jpa.ProductSupplierId;
import com.github.jinahya.db2.sample.data.jpa.__MappedEntity_Persister_Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ProductSupplierRepository_DataJpaTest
        extends __MappedEntityRepository_DataJpaTest<ProductSupplierRepository, ProductSupplier, ProductSupplierId> {

    ProductSupplierRepository_DataJpaTest() {
        super(ProductSupplierRepository.class);
    }

    @DisplayName("findAllByPid(pid, pageable)page")
    @Nested
    class FindAllByPid_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            // --------------------------------------------------------------------------------------------------- given
            final var pid = "";
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByPid(pid, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]")
        @Test
        void __Known() {
            // --------------------------------------------------------------------------------------------------- given
            final var persisted = newPersistedEntityInstance();
            final var pid = persisted.getPid();
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByPid(pid, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).contains(persisted);
        }
    }

    @DisplayName("findAllByProduct(product, pageable)page")
    @Nested
    class FindAllByProduct_Test {

        @DisplayName("(unknown, )empty")
        @Test
        void _Empty_Unknown() {
            // --------------------------------------------------------------------------------------------------- given
            final var product = __MappedEntity_Persister_Utils.newPersistedInstanceOf(Product.class, entityManager());
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByProduct(product, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).isEmpty();
        }

        @DisplayName("(persisted., )[persisted]")
        @Test
        void __Known() {
            // --------------------------------------------------------------------------------------------------- given
            final var persisted = newPersistedEntityInstance();
            final var product = persisted.getProduct();
            log.debug("persisted: {}", persisted);
            log.debug("product: {}", product);
            // ---------------------------------------------------------------------------------------------------- when
            final var found = repositoryInstance().findAllByProduct(product, Pageable.unpaged());
            // ---------------------------------------------------------------------------------------------------- then
            assertThat(found).contains(persisted);
        }
    }
}