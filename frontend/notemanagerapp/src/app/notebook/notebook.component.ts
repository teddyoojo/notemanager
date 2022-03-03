import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Note } from './note';
import { NoteService } from './note.service';
import {
  faPenToSquare,
  faUpRightAndDownLeftFromCenter,
} from '@fortawesome/free-solid-svg-icons';
import { faTrashCan } from '@fortawesome/free-solid-svg-icons';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-notebook',
  templateUrl: './notebook.component.html',
})
export class NotebookComponent implements OnInit {
  public notes: Note[] = [];
  public noteForm: FormGroup = new FormGroup({
    noteHeader: new FormControl(''),
    noteContent: new FormControl(''),
  });
  faPenToSquare = faPenToSquare;
  faTrashCan = faTrashCan;
  public deleteNote: Note;
  public updateNote: Note;

  constructor(private noteService: NoteService) {}

  ngOnInit() {
    this.getNotes();
  }

  public getNotes(): void {
    this.noteService.getNotes().subscribe({
      next: (response: Note[]) => {
        this.notes = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public toggleAddModal(): void {
    const element = document.getElementById('addNoteModal');
    element?.classList.toggle('is-active');
  }

  public onAddNote(noteData: { noteHeader: any; noteContent: any }) {
    const note: Note = new Note();
    note.noteHeader = noteData.noteHeader;
    note.noteContent = noteData.noteContent;
    this.noteService.addNote(note).subscribe({
      next: (response: Note) => {
        this.getNotes();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
      complete: () => {
        //clear form and close it
        this.noteForm.reset();
        this.toggleAddModal();
      },
    });
  }

  public onDeleteNote(noteId: number) {
    this.noteService.deleteNote(noteId).subscribe({
      next: (response: void) => {
        this.getNotes();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public openUpdateModal(note: Note): void {
    const element = document.getElementById('updateNoteModal');
    this.updateNote = note;
    element?.setAttribute('data-target', '#updateNoteModal');
    element?.classList.toggle('is-active');
  }

  public closeUpdateModal(): void {
    const element = document.getElementById('updateNoteModal');
    element?.classList.toggle('is-active');
  }
  public onUpdateNote(
    noteData: {
      noteHeader: any;
      noteContent: any;
    },
    noteId: any,
    noteDate: any
  ) {
    const note: Note = new Note();
    note.id = noteId;
    note.date = noteDate;
    note.noteHeader = noteData.noteHeader;
    note.noteContent = noteData.noteContent;
    this.noteService.updateNote(note).subscribe({
      next: (response: Note) => {
        this.getNotes();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
      complete: () => {
        //clear form and close it
        this.noteForm.reset();
        this.closeUpdateModal();
      },
    });
  }
}
