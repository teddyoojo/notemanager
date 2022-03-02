import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Note } from './note';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getNotes(): Observable<Note[]> {
    return this.http.get<Note[]>(`${this.apiServerUrl}/note/all`);
  }

  public addNote(note: Note): Observable<Note> {
    return this.http.post<Note>(`${this.apiServerUrl}/note/add`, note);
  }

  public updateNote(note: Note): Observable<Note> {
    return this.http.put<Note>(`${this.apiServerUrl}/note/update`, note);
  }

  public deleteNote(noteId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/note/delete/${noteId}`);
  }
}
