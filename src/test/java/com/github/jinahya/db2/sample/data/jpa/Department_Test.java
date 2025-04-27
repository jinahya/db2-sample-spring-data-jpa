package com.github.jinahya.db2.sample.data.jpa;

import nl.jqno.equalsverifier.api.SingleTypeEqualsVerifierApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class Department_Test extends __MappedEntity_Test<Department, String> {

    Department_Test() {
        super(Department.class, String.class);
    }

    @Override
    protected SingleTypeEqualsVerifierApi<Department> equalsVerifier() {
        return super.equalsVerifier()
                .withPrefabValues(
                        MappedEmployee.class,
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "1"),
                        (MappedEmployee<?, ?>) __MappedEntity.of_id_(Employee::new, "2")
                )
                .withPrefabValues(
                        MappedDepartment.class,
                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "1"),
                        (MappedDepartment<?, ?>) __MappedEntity.of_id_(Department::new, "2")
                )
                ;
    }

    @DisplayName("getAdmrdeptEffective()optional")
    @Nested
    class GetAdmrdeptTest {

        @DisplayName("()empty <- getAdmrdept()null")
        @Test
        void _Empty_Null() {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newEntitySpy();
            given(instance.getAdmrdept()).willReturn(null);
            // ---------------------------------------------------------------------------------------------------- when
            final var admrdeptEffective = instance.getAdmrdeptEffective();
            // ---------------------------------------------------------------------------------------------------- then
            verify(instance, times(1)).getAdmrdept();
            assertThat(admrdeptEffective).isEmpty();
        }

        @DisplayName("()[admrdept] <- getAdmrdept()!null")
        @Test
        void __NotNull() {
            // --------------------------------------------------------------------------------------------------- given
            final var instance = newEntitySpy();
            final var admrdept = spy(Department.class);
            given(instance.getAdmrdept()).willReturn(admrdept);
            // ---------------------------------------------------------------------------------------------------- when
            final var admrdeptEffective = instance.getAdmrdeptEffective();
            // ---------------------------------------------------------------------------------------------------- then
            verify(instance, times(1)).getAdmrdept();
            assertThat(admrdeptEffective).hasValue(admrdept);
        }
    }
}