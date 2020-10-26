package com.idalon.test.core.util;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Siyar
 */
public final class Mapper {

    private Mapper() {
        throw new UnsupportedOperationException(this.getClass() + ": cannot be initialized by constructor.");
    }

    public static <T, R, C extends Collection<R>> C map(final Collection<T> values,
                                                        final Function<T, R> mapper,
                                                        final Supplier<C> supplier) {
        return !CollectionUtils.isEmpty(values) ?
                values
                        .stream()
                        .map(mapper)
                        .collect(Collectors.toCollection(supplier))
                : supplier.get();
    }
}
