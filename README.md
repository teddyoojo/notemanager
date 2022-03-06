# Notemanager-App

This is my very first Web App, using Spring Boot, Angular and Bulma

This is the frontpage I created using Bulma:

![](https://github.com/teddyoojo/notemanager/blob/main/docs/images/frontpage.png)

The Web-App has a few different functions.
The first function of the Website is to "Add a Note". Upon pressing the "Click here to add a Note!" Button, a Modal will open up,
allowing the User to enter a new Note, made up of a note header and note content.
An ID and a LocalDateTime is automatically added to the note, and the date is displayed on the note.

![](https://github.com/teddyoojo/notemanager/blob/main/docs/images/addnotemodal.png)

The Submit Button is disabled unless both Textarea fields have an entry. The Modal can be closed by an Exit Modal Button on the top right of the screen (not pictured).

The Delete Button deletes a note, without a prompt.

The Edit Note Button will open up a similar Modal to the Add Note Button, however with the Textarea fields already filled in with the previous note header/content, ready to be edited.

![](https://github.com/teddyoojo/notemanager/blob/main/docs/images/edit_note_modal.png)
