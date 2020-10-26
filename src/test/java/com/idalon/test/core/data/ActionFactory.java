package com.idalon.test.core.data;

import com.github.javafaker.Faker;
import com.github.javafaker.Hacker;
import com.idalon.test.presentation.dto.ActionDto;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;


/**
 * @author Siyar
 */
public final class ActionFactory {
    private static final String ACTION = "git.push";
    private static final String DESCRIPTION = "DESC";
    private static final String BINDING = "Ctrl + Shift + K";
    private static final List<String> SYS = Arrays.asList("Ctrl", "Alt", "Shift");
    private static Hacker HACKER = new Faker().hacker();

    private ActionFactory() {
        throw new UnsupportedOperationException(this.getClass() + ": cannot be initialized by constructor.");
    }

    public static ActionDto createAction() {
        return new ActionDto(ACTION, DESCRIPTION, BINDING);
    }

    public static ActionDto createRandomAction() {
        final Random rand = new Random(System.currentTimeMillis());
        Collections.shuffle(SYS);
        final int size = rand.nextInt(SYS.size()) + 1;
        final StringJoiner stringJoiner = new StringJoiner(" + ");
        SYS.stream().limit(size).forEach(stringJoiner::add);
        final char randomUppercase = (char) ('A' +  rand.nextInt(26));
        stringJoiner.add(String.valueOf(randomUppercase));
        return new ActionDto(HACKER.noun() + "." + HACKER.verb(), DESCRIPTION,
                stringJoiner.toString());
    }
}
