package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

class Employee_Randomizer extends __MappedEntity_Randomizer<Employee> {

    Employee_Randomizer() {
        super(Employee.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    DataProviderStrategy strategy() {
        return super.strategy();
    }

    @Override
    PodamFactory factory() {
        return super.factory();
    }

    @Override
    Employee get() {
        return super.get();
    }
}