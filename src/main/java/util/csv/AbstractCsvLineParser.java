package util.csv;

import bean.Equipment;
import exception.CsvParserException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class AbstractCsvLineParser<E extends Equipment> implements CsvLineParser<E> {

    private final Path path;
    public static final String COMMA_DELIMITER = ",";

    public static final String NEW_LINE_DELIMITER = "\\n";

    protected AbstractCsvLineParser(Path path) {
        this.path = path;
    }

    public Stream<E> parseFile() {
        List<String> tokens = parseFileRaw();
        return tokens.stream()
            .map(this::parseEquipment);
    }

    private List<String> parseFileRaw() {
        try (Scanner scanner = new Scanner(path)) {
            scanner.useDelimiter(NEW_LINE_DELIMITER);
            return scanner.tokens()
                .filter(s -> !s.startsWith("ID,"))
                .toList();
        } catch (IOException e) {
            throw new CsvParserException(e.getMessage(), e);
        }

    }

    protected abstract E parseEquipment(String token);
}
