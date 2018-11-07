package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        int index = o1.getChannelName().compareTo(o2.getChannelName());
        if (index == 0) {
            index = o1.getFingerprint().compareTo(o2.getFingerprint());
            if (index == 0) {
                index = o1.getDateCreated().compareTo(o2.getDateCreated());
            }
        }
        return index;
    }
}
