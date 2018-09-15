package com.rozzer.common;

import javax.annotation.Nonnull;
import java.math.BigInteger;

/**
 * The interface do to identify the uniqueness of the object
 */
public interface Identity {

    /**
     * @return uniqueness id
     */
    @Nonnull
    BigInteger getId();

    /**
     *
     * @param id is uniqueness in DB
     */
    void setId(@Nonnull BigInteger id);
}
