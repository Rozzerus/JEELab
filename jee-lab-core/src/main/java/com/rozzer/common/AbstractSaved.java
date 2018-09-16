package com.rozzer.common;

import javax.annotation.Nonnull;
import java.math.BigInteger;

public abstract class AbstractSaved implements Saved {

    private BigInteger id;
    private String name;

    @Nonnull
    public BigInteger getId() {
        return id;
    }

    public void setId(@Nonnull BigInteger id) {
        this.id = id;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }
}
