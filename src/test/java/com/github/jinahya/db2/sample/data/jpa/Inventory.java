package com.github.jinahya.db2.sample.data.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serial;
import java.util.Optional;

@Entity
@Table(name = MappedInventory.TABLE_NAME)
public class Inventory extends MappedInventory<Inventory> {

    @Serial
    private static final long serialVersionUID = -371501059474165509L;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    protected Inventory() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns current value of {@link Inventory_#product product} attribute.
     *
     * @return current value of the {@link Inventory_#product product} attribute.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Replaces current value of {@link Inventory_#product prpduct} attribute with specified value.
     *
     * @param product new value for the {@link Inventory_#product product} attribute.
     * @apiNote This method also replaces current value of {@link MappedInventory_#pid pid} attribute with
     * {@code product?.pid}.
     */
    public void setProduct(final Product product) {
        this.product = product;
        setPid(
                Optional.ofNullable(this.product).map(__MappedEntity::_id_).orElse(null)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Valid
    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_PID, nullable = false, insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;
}