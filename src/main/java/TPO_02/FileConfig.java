package TPO_02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {
    @Value("${pl.edu.pja.tpo02.filename}")
    private String filename;

    public String getFilename() {
        return filename;
    }

}
