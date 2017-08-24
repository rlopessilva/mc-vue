package fr.belthis.mc.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileManager {

    @Value("${repertoire.stockage:}")
    private String repertoireStockage;

    public List<Path> listerCollaborateurs() throws IOException {
        final Path p = Paths.get(URI.create("file://" + repertoireStockage));

        final PathMatcher filter = p.getFileSystem().getPathMatcher("regex:.*[^0-9]{8}\\.json$");
        final Stream<Path> stream = Files.list(p);

        final List<Path> listeFichiers = stream.filter(filter::matches).collect(Collectors.toList());


        return listeFichiers;
    }


}
