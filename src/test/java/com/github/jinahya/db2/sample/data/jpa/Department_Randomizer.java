package com.github.jinahya.db2.sample.data.jpa;

import lombok.extern.slf4j.Slf4j;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

@Slf4j
class Department_Randomizer extends __MappedEntity_Randomizer<Department> {

    Department_Randomizer() {
        super(Department.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    DataProviderStrategy strategy() {
        return super.strategy()
                .addOrReplaceAttributeStrategy(String.class, "mgrno", (t, a) -> {
                    log.debug("type: {}, annotations: {}", t, a);
                    return null;
                })
                .addOrReplaceAttributeStrategy(MappedEmployee.class, "mgr", (t, a) -> {
                    log.debug("type: {}, annotations: {}", t, a);
                    return null;
                })
                .addOrReplaceAttributeStrategy(MappedDepartment.class, "admrdept", (t, a) -> {
                    log.debug("type: {}, annotations: {}", t, a);
                    return null;
                })
                ;
    }

    @Override
    PodamFactory factory() {
        return super.factory();
    }

    @Override
    Department get() {
        final var value = super.get();
        value.setAdmrdept(null);
        return value;
    }
}