package dao;

import exception.CsvParserException;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

class TestUtil {

    static Path getPath(String path) {
        try {
            URL resource = Thread.currentThread().getContextClassLoader().getResource(path);
            return Paths.get(resource.toURI());
        } catch (URISyntaxException e) {
            throw new CsvParserException("File was not found: " + path, e);
        }
    }
}
