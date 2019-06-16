package com.example.echo.ga.v2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class ScheduleController {
    public String dataString;
    @PostMapping("/kreirajRaspored")
    public void kreirajRaspored(@RequestBody Map<String, String> data) throws Exception {
        ArrayList<String> values = new ArrayList<String>();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            values.add(entry.getValue());
        }
        if(values.size() == 0 || values.size() == 1) {
            values.add("zimski");
            values.add("RI3");
        }
        Driver driver = new Driver();
        dataString = driver.Start(values.get(0), values.get(1));
    }
    @GetMapping(value="/dajRaspored")
    @ResponseBody
    public String dajRaspored() {
        return dataString;
    }
}
