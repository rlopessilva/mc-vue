package fr.belthis.mc.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.nio.file.Path;

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

}
