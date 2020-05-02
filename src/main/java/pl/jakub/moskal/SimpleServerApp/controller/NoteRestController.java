package pl.jakub.moskal.SimpleServerApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jakub.moskal.SimpleServerApp.model.Note;
import pl.jakub.moskal.SimpleServerApp.service.NoteServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/note")
@AllArgsConstructor
public class NoteRestController {

    private final NoteServiceImpl noteService;

    @GetMapping(value = "/getAllNotes")
    public ResponseEntity<?> getAllNotes() {
        List<Note> notes = noteService.findAll();
        if (!notes.isEmpty())
            return new ResponseEntity<>(notes, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "getNote/{id}")
    public ResponseEntity<?> getNoteById(@PathVariable("id") long id) {
        Optional<Note> note = noteService.findById(id);
        return note.map(n -> new ResponseEntity<>(n, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping()
    public ResponseEntity<?> saveNote(@RequestBody Note note) {
        return (noteService.saveNote(note)) ?
                new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
}
