package org.sergh.app.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum PhoneTypes {

    work,
    home;

    private static final List<PhoneTypes> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PhoneTypes randomPhone() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}