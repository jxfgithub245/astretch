package learn.allure.plugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class test {
    public static void main(String args[]) throws IOException {
        final Path outputDirectory = Path.of("D:\\");
        final Path dataFolder = Files.createDirectories(outputDirectory.resolve("data"));
        System.out.println(dataFolder);
    }
}
