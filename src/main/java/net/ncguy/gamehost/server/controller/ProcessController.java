package net.ncguy.gamehost.server.controller;

import net.ncguy.gamehost.process.ProcessWatchdog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/proc")
public class ProcessController {

    @RequestMapping({"", "/", "/all"})
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("procList", ProcessWatchdog.get().getProcesses());
        return mav;
    }

    @RequestMapping("/{procId}")
    public ModelAndView get(@PathVariable String procId) {
        ModelAndView mav = new ModelAndView("stream");
        mav.addObject("processName", procId);
        // TODO establish websocket connection
        return mav;
    }

    @RequestMapping("/{procId}/start")
    public ResponseEntity start(@PathVariable String procId) {
        try {
            ProcessWatchdog.get().startProcess(procId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
