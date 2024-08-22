package in.bottomhalf.data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/check/")
public class CheckRequestController {

    @GetMapping(value = "get")
    public ResponseEntity<String> getTestData() {
        String message = "Endpoint is working.";
        return ResponseEntity.ok(message);
    }
}
