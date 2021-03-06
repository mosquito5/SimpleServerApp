package pl.jakub.moskal.SimpleServerApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.jakub.moskal.SimpleServerApp.model.UserInfo;
import pl.jakub.moskal.SimpleServerApp.service.UserInfoServiceImpl;
import pl.jakub.moskal.SimpleServerApp.service.ZipServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserInfoRestController {

    private final UserInfoServiceImpl userInfoService;

    private final ZipServiceImpl zipService;

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<?> getAllNotes() {
        List<UserInfo> userInfos = userInfoService.findAll();
        if (!userInfos.isEmpty())
            return new ResponseEntity<>(userInfos, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/getUser/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable("id") long id) {
        Optional<UserInfo> note = userInfoService.findById(id);
        return note.map(n -> new ResponseEntity<>(n, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveUser(@RequestBody UserInfo userInfo) {
        return (userInfoService.saveNote(userInfo)) ?
                new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping(value = "/saveZip")
    public ResponseEntity<?> saveZipFile(@RequestParam("zip") MultipartFile file) {
        zipService.saveXmlZip(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
