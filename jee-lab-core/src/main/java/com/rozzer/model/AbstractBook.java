package com.rozzer.model;

import javax.annotation.Nonnull;
import java.math.BigInteger;

abstract class AbstractBook implements Book {

    @Nonnull
    public BigInteger getId() {
        return BigInteger.valueOf(0);
    }

    public void setId(@Nonnull BigInteger id) {

    }

    public void save() {

    }
}
