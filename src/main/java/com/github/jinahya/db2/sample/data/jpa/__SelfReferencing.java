package com.github.jinahya.db2.sample.data.jpa;

/**
 * An interface for self-referencing entities.
 *
 * @param <SELF> self type parameter
 * @author Jin Kwon &lt;jin.kwon_at_meshkorea.net&gt;
 */
interface __SelfReferencing<SELF extends __SelfReferencing<SELF>> {

    /**
     * Returns current value of parent, of {@link SELF}, of this entity.
     *
     * @return current value of the parent, of {@link SELF}, of this entity.
     */
    @org.springframework.lang.Nullable
    @jakarta.annotation.Nullable
    SELF ___parent();

    /**
     * Replace current value of parent, of {@link SELF}, of this entity with specified value.
     *
     * @param ___parent new value for the parent, of {@link SELF}, of this entity.
     */
    void ___parent(@org.springframework.lang.Nullable
                   @jakarta.annotation.Nullable
                   SELF ___parent);
}
