package com.rozzer.model;

import com.rozzer.common.Identity;
import com.rozzer.common.Saved;

import javax.annotation.Nonnull;
import java.math.BigInteger;

abstract class AbstractBook implements Identity, Saved {

    @Nonnull
    public BigInteger getId() {
        return BigInteger.valueOf(0);
    }

    public void setId(@Nonnull BigInteger id) {

    }

    public void save() {

    }
}
