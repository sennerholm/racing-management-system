package se.cag.labs.currentrace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.cag.labs.currentrace.services.CancelRaceService;
import se.cag.labs.currentrace.services.PassageDetectedService;
import se.cag.labs.currentrace.services.StartRaceService;
import se.cag.labs.currentrace.services.StatusService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class CurrentRaceController {
    @Autowired
    private CurrentRaceRepository repository;
    @Autowired
    private StartRaceService startRaceService;
    @Autowired
    private CancelRaceService cancelRaceService;
    @Autowired
    private PassageDetectedService passageDetectedService;
    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/startRace",  method = RequestMethod.POST)
    public ResponseEntity startRace(@RequestParam String callbackUrl) {
        return startRaceService.startRace(callbackUrl);
    }

    @RequestMapping(value = "/cancelRace", method = RequestMethod.POST)
    public ResponseEntity cancelRace() {
        return cancelRaceService.cancelRace();
    }

    @RequestMapping(value = "/passageDetected", method = RequestMethod.POST)
    public ResponseEntity passageDetected(@RequestParam String sensorID, @RequestParam long timestamp) {
        return passageDetectedService.passageDetected(sensorID, timestamp);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public RaceStatus status() {
        return statusService.status();
    }
}
