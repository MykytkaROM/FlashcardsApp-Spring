package TPO_02;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Scanner;
@Service
public class FlashcardsController {
    @Autowired
    public FlashcardsController(IDisplayWords displayWords, FileService fileService) {
        System.out.println("Welcome to the Flashcards App"+"\n"+
                "To navigate through application use commands below:"+"\n"+
                "//add - to add new word to dictionary"+"\n"+
                "//display - to display all words"+"\n"+
                "//test - to test your knowledge of word's translations"+"\n"+
                "//exit - to exit");
        Scanner scanner = new Scanner(System.in);
        String[] split;
        String input;
        displayWords.changeWords();
        while(true){
            input = scanner.nextLine();
            if(input.equals("//add")){
                System.out.println("To add word write all translations " +
                        "like in schema: english,german,polish");
                input = scanner.nextLine();
                split = input.split(",");
                fileService.getEntryRepository().addEntry(new Entry(split[0],split[1],split[2]));
                fileService.writeToFile(fileService.getFileConfig().getFilename());
            }
            if(input.equals("//display")){
                displayWords.displayWords();
            }
            if(input.equals("//test")){
                System.out.println("You can return by typing //back");
                Entry randomEntry = fileService.getEntryRepository().getRandomEntry();
                while(true){
                    System.out.println("Enter German translation of a word "+randomEntry.getEng());
                    input = scanner.nextLine();
                    if(input.equals("//back")){
                        System.out.println("Welcome to the Flashcards App"+"\n"+
                                "To navigate through application use commands below:"+"\n"+
                                "//add - to add new word to dictionary"+"\n"+
                                "//display - to display all words"+"\n"+
                                "//test - to test your knowledge of word's translations"+"\n"+
                                "//exit - to exit");
                        break;
                    }
                    if(input.equalsIgnoreCase(randomEntry.getGer())){
                        System.out.println("Enter Polish translation of a word "
                                +randomEntry.getEng());
                        input = scanner.nextLine();
                        if(input.equalsIgnoreCase(randomEntry.getPol())){
                            randomEntry = fileService.getEntryRepository().getRandomEntry();
                        }else System.out.println("Try again");
                    }else System.out.println("Try again");
                }
            }
            if(input.equals("//exit")){
                System.exit(0);
            }
        }
    }
}
