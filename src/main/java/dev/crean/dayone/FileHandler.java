package dev.crean.dayone;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class FileHandler<T> {
    private final String resourcePath;

    public FileHandler(String path) {
        this.resourcePath = path;
    }

    public void processFileLines(Function<String, T> mapper, Consumer<T> processor) {
        try (Stream<String> inputs = Files.lines(getPath())) {
            inputs.map(mapper).forEach(processor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path getPath() {
        try {
            URI uri = Objects.requireNonNull(FindPassword.class.getClassLoader().getResource(resourcePath)).toURI();
            return Paths.get(uri);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
