package fr.belthis.mc.data;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import fr.belthis.mc.metier.dto.CollaborateurDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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

    public void sauvegarderCollaborateur(final CollaborateurDTO collaborateurDTO) throws IOException {
        final String nomFichier = collaborateurDTO.getPrenom() + "_" + collaborateurDTO.getNom().replace(" ", "_") + ".json";

        final Path p = Paths.get(URI.create("file://" + repertoireStockage + "/" + nomFichier));

        if (Files.exists(p)) {
            historiserFichier(p, collaborateurDTO);
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(p.toFile(), collaborateurDTO);

    }


    private void historiserFichier(final Path fichier, final CollaborateurDTO collaborateurDTO) throws IOException {

        final LocalDate now = LocalDate.now();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        final String dateFichier = now.format(formatter);

        String nouveauNom = collaborateurDTO.getPrenom() + "_" + collaborateurDTO.getNom().replace(" ", "_") + "-" + dateFichier;

        final Path p = Paths.get(URI.create("file://" + repertoireStockage));

        final PathMatcher filter = p.getFileSystem().getPathMatcher("regex:.*" + nouveauNom + ".*\\.json$");
        final Stream<Path> stream = Files.list(p);

        Integer maxHistorique = 0;

        final OptionalInt max = stream.filter(filter::matches).mapToInt(path -> {
            final String fileName = path.getFileName().toString();
            if (StringUtils.countMatches(fileName, '-') > 1) {
                return getNbHistorique(fileName);
            } else {
                return 0;
            }
        }).max();

        if(max.isPresent()) {
            maxHistorique = max.getAsInt() + 1;
        }

        if (maxHistorique != 0) {
            nouveauNom = nouveauNom + "-" + maxHistorique + ".json";
        } else {
            nouveauNom = nouveauNom + ".json";
        }

        Files.move(fichier, fichier.resolveSibling(nouveauNom));
    }

    private int getNbHistorique(String fileName) {
        final int indexOfUnderscore = StringUtils.lastIndexOf(fileName, "-");
        final int indexOfPoint = StringUtils.lastIndexOf(fileName, ".");
        final String historique = StringUtils.substring(fileName, indexOfUnderscore + 1, indexOfPoint);

        return NumberUtils.isDigits(historique) ? Integer.valueOf(historique) : 0;
    }


}
