package net.ncguy.gamehost.process;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ProcessWatchdog {

    private static ProcessWatchdog watchdog;
    public static ProcessWatchdog get() {
        if (watchdog == null) {
            watchdog = new ProcessWatchdog();
        }
        return watchdog;
    }

    private Map<String, String> processMap;

    private ProcessWatchdog() {
        processMap = new HashMap<>();
    }

    public Set<String> getProcesses() {
        return processMap.keySet();
    }

    public String startProcess(String id) throws IOException {
        if(processMap.containsKey(id)) {
            return id;
        }
        processMap.put(id, id);
        return id;
    }

    public Optional<String> get(String id) {
        return Optional.ofNullable(processMap.get(id));
    }

}
