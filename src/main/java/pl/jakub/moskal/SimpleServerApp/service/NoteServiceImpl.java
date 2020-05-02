package pl.jakub.moskal.SimpleServerApp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.jakub.moskal.SimpleServerApp.model.Note;
import pl.jakub.moskal.SimpleServerApp.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public boolean saveNote(Note note) {
        try {
            noteRepository.save(note);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }
}
