package brendel.philipp.notemanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Note implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private Date date;
    private String noteHeader;
    private String noteContent;

    public Note() {}
    public Note(Long id, Date date, String noteHeader, String noteContent) {
        this.id = id;
        this.date = date;
        this.noteHeader = noteHeader;
        this.noteContent = noteContent;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getNoteHeader() {
        return noteHeader;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNoteHeader(String noteHeader) {
        this.noteHeader = noteHeader;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}