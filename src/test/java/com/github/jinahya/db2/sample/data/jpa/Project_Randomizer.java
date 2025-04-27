package com.github.jinahya.db2.sample.data.jpa;

import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamFactory;

class Project_Randomizer extends __MappedEntity_Randomizer<Project> {

    Project_Randomizer() {
        super(Project.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    DataProviderStrategy strategy() {
        return super.strategy()
                .addOrReplaceAttributeStrategy(MappedProject.class, "prstaff", (t, a) -> null);
    }

    @Override
    PodamFactory factory() {
        return super.factory();
    }

    @Override
    Project get() {
        return super.get();
    }
}