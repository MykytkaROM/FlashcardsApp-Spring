package TPO_02;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EntryRepository implements IEntryRepository {
    private List<Entry> entries = new ArrayList<>();
    @Override
    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    @Override
    public List<Entry> getAllEntries() {
        return entries;
    }

    @Override
    public Entry getRandomEntry() {
        int index = (int) (Math.random() * entries.size());
        return entries.get(index);
    }
}
