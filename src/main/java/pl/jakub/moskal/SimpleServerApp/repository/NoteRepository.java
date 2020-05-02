package pl.jakub.moskal.SimpleServerApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jakub.moskal.SimpleServerApp.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
