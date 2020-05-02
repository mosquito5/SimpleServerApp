package pl.jakub.moskal.SimpleServerApp.service;

import pl.jakub.moskal.SimpleServerApp.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

    boolean saveNote(Note note);

    Optional<Note> findById(Long id);

    List<Note> findAll();

}
