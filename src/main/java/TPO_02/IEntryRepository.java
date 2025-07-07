package TPO_02;

import java.util.List;

public interface IEntryRepository {
    void addEntry(Entry entry);
    List<Entry> getAllEntries();
    Entry getRandomEntry();
}
