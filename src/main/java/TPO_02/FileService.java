package TPO_02;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;


import java.io.*;

@Component
@Configuration
public class FileService {
    private  FileConfig fileConfig;
    private IEntryRepository entryRepository;
    public FileService(FileConfig fileConfig, IEntryRepository entryRepository) {
        this.fileConfig = fileConfig;
        this.entryRepository = entryRepository;
        readFileAndPopulateRep(fileConfig.getFilename());
    }

    public void readFileAndPopulateRep(String fileName){
        try(InputStream inputStream = new ClassPathResource(fileName).getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = br.readLine();
            String[] split;
            while(line!=null){
                split = line.split(",");
                entryRepository.addEntry(new Entry(split[0],split[1],split[2]));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeToFile(String filename){
        try(PrintWriter pw = new PrintWriter("./src/main/resources/"+filename)){
            for (int i = 0; i < entryRepository.getAllEntries().size(); i++) {
                    pw.println(entryRepository.getAllEntries().get(i).toString());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
    }

    public IEntryRepository getEntryRepository() {
        return entryRepository;
    }

    public FileConfig getFileConfig() {
        return fileConfig;
    }
}
