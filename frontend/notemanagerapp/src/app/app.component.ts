import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Note } from './note';
import { NoteService } from './note.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public notes: Note[] | undefined;

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
      }
      }
    );
  }
}
