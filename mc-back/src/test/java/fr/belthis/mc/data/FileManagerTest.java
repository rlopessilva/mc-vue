package fr.belthis.mc.data;

import fr.belthis.mc.metier.dto.CollaborateurDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FileManagerTest {

    @InjectMocks
    private FileManager target;

    @Before
    public void before() {
        final URL stockage = ClassLoader.getSystemResource("stockage");
        ReflectionTestUtils.setField(target, "repertoireStockage", stockage.getPath());
    }

    @Test
    public void listerCollaborateursTest() throws IOException {

        final List<Path> files = target.listerCollaborateurs();

        assertThat(files).isNotNull();
        assertThat(files.size()).isEqualTo(2);

    }

    @Test
    public void sauvegarderCollaborateurTest_Nouveau() throws IOException {
        final CollaborateurDTO collaborateurDTO = new CollaborateurDTO();
        collaborateurDTO.withNom("LE TOTO").withPrenom("Titi").withDateModification(LocalDateTime.now());


        target.sauvegarderCollaborateur(collaborateurDTO);

        final URL stockage = ClassLoader.getSystemResource("stockage");

        final Path pathStockage = Paths.get(URI.create("file://" + stockage.getPath().toString()));

        final Path path1 = pathStockage.resolve("Titi_LE_TOTO.json");

        assertThat(Files.exists(path1)).isTrue();

        final PathMatcher filter = pathStockage.getFileSystem().getPathMatcher("regex:.*Titi_LE_TOTO.*\\.json$");
        final Stream<Path> stream = Files.list(pathStockage);

        stream.filter(filter::matches).forEach(path -> {
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
