package com.api.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private InputStream errorStream;
    private Consumer<String> consumer;

    public StreamGobbler(InputStream inputStream,InputStream errorStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
        this.errorStream = errorStream;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
        new BufferedReader(new InputStreamReader(errorStream)).lines().forEach(consumer);
    }
}
