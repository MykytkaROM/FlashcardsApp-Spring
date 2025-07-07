package TPO_02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;



@Component
@Profile("Up")
public class DisplayWordsUp implements IDisplayWords{
    private IEntryRepository entryRepository;
    @Autowired
    public DisplayWordsUp(IEntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }
    @Override
    public void displayWords() {
        System.out.println("English "+"German "+"Polish");
        for (int i = 0; i < entryRepository.getAllEntries().size(); i++) {
            System.out.println(entryRepository.getAllEntries().get(i).getEng()
                    +" "+entryRepository.getAllEntries().get(i).getGer()
                    +" "+entryRepository.getAllEntries().get(i).getPol());
        }
    }

    @Override
    public void changeWords() {
        for (int i = 0; i < entryRepository.getAllEntries().size(); i++) {
            entryRepository.getAllEntries().get(i)
                    .setEng(entryRepository.getAllEntries().get(i).getEng().toUpperCase());
            entryRepository.getAllEntries().get(i)
                    .setGer(entryRepository.getAllEntries().get(i).getGer().toUpperCase());
            entryRepository.getAllEntries().get(i)
                    .setPol(entryRepository.getAllEntries().get(i).getPol().toUpperCase());
        }
    }
}
