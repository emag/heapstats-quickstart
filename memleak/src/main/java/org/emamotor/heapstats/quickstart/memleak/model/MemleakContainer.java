package org.emamotor.heapstats.quickstart.memleak.model;

import java.util.ArrayList;
import java.util.List;

public class MemleakContainer {

    private List<Memleak> memleaks = new ArrayList<>();

    public List<Memleak> getMemleaks() {
        return memleaks;
    }

    public void setMemleaks(List<Memleak> memleaks) {
        this.memleaks = memleaks;
    }

}
