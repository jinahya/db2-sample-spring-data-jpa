package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

import java.math.BigDecimal;

@Slf4j
class Employee_Randomizer extends __MappedEntity_Randomizer<Employee> {

    Employee_Randomizer() {
        super(Employee.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    DataProviderStrategy strategy() {
        return super.strategy()
                .addOrReplaceAttributeStrategy(MappedDepartment.class, "workdept", (t, a) -> {
                    log.debug("type: {}, annotations: {}", t, a);
                    return null;
                })
                .addOrReplaceAttributeStrategy(BigDecimal.class, "salary", (t, a) -> {
                    return null;
                })
                .addOrReplaceAttributeStrategy(BigDecimal.class, "bonus", (t, a) -> {
                    return null;
                })
                .addOrReplaceAttributeStrategy(BigDecimal.class, "comm", (t, a) -> {
                    return null;
                })
                ;
    }

    @Override
    PodamFactory factory() {
        return super.factory();
    }

    @Override
    Employee get() {
        final var value = super.get();
        value.setSalary(null);
        value.setBonus(null);
        value.setComm(null);
        return value;
    }
}