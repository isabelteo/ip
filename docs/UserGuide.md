# Ghibli Task Manager User Guide

## Introduction

This project is a Studio-Ghibli Themed Task Manager that helps you to manage your todos, deadlines and events.

![ip_photo](https://user-images.githubusercontent.com/83572953/153880433-8d9404b8-a5cf-4c93-b222-f1d732fe5148.jpg)

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## List of Features

- [x] Add 3 types of Tasks: ToDo, Deadline and Event
- [x] Display task list
- [x] Mark task as done
- [x] Unmark task
- [x] Add notes to task
- [x] Show notes added to a task
- [x] Edit note added to task
- [x] Delete note added to task
- [x] Search for certain tasks based on key words 
- [x] Delete tasks 
- [x] Storing of tasks for easy access in next use
- [x] Exiting the program

## Feature Details 

### Add Tasks

#### Add ToDo
A ToDo is a task with a task name.

*Command: todo TASK_NAME*
   
Example of input:
   ```
   todo buy gift for my bestie 
   ```
Example of output:
   ```
   [T][ ] buy gift for my bestie
   ```

#### Add Deadline
A Deadline is a task that has a end date and time. 

*Command: deadline TASK_NAME /by YYYY-MM-DD hh:mm*
   
Example of input:
   ```
   deadline book venue for party /by 2022-02-14 21:20
   ```
Example of output:
   ```
   [D][ ] book venue for party (by: Feb. 14 2022 09:20 pm)
   ```

#### Add Event
An Event is a task that has a start date and time as well as a end date and time. 

*Command: event TASK_NAME /at YYYY-MM-DD hh:mm /to YYYY-MM-DD hh:mm*
   
Examples of input:
   ```
   event birthday party /at 2022-02-28 19:15 /to 2022-02-28 22:15
   ```
Example of output:
  ```
  [E][ ] birthday party (at: Feb. 28 2022 07:15 pm to Feb. 28 2022 10:15 pm)
  ```
   
### Display Task List

Use command ```list``` to see all tasks you have added.

*Command: list*
   
Examples of input:
   ```
   list
   ```
Example of output:
  ```
   Here is your to-do:
   1.[T][ ] buy gift for my bestie
   2.[D][ ] book venue for party (at: Feb. 28 2022 07:15 pm to Feb. 28 2022 10:15 pm)
   3.[E][ ] birthday party (at: Feb. 28 2022 07:15 pm to Feb. 28 2022 10:15 pm)
  ```
### Mark and Unmark Task 

#### Mark Task as Complete

Use command ```mark``` to mark a task as done. Task number of 1 refers to first task in the list.

*Command: mark <task number>*
   
Examples of input:
   ```
   mark 1
   ```
Example of output:
  ```
   Nice! I've marked this task as done: [T][X] buy gift for my bestie
  ```
#### Unmark Task 

Use command ```unmark``` to unmark a task to change its status back to undone.

*Command: unmark TASK_NUMBER*
   
Examples of input:
   ```
   unmark 1
   ```
Example of output:
  ```
   OK, I've marked this task as not done yet: [T][] buy gift for my bestie
  ```

### Notes 

#### Add note

*Command: add note to task TASK_NUMBER NOTE_MESSAGE*
   
Examples of input:
   ```
   add note to task 1 maybe a plant would be good?
   ```
Example of output:
  ```
   Got it, I've added a note to task [T][] buy gift for my bestie
   Use 'show note from <taskNumber>' to see the note
  ```
#### Show note

*Command: show note from task TASK_NUMBER*
   
Examples of input:
   ```
   show note from task 1
   ```
Example of output:
  ```
   [T][] buy gift for my bestie :
   Note 1: maybe a plant would be good?
  ```
#### Edit note

*Command: edit note NOTE_NUMBER from task TASK_NUMBER NEW_NOTE_MESSAGE*
   
Examples of input:
   ```
   edit note 1 from task 1 maybe a cactus would be good?
   ```
Example of output:
  ```
   Got it! I've edited the note from [T][] buy gift for my bestie
  ```
   
Example of task list after edit note:
  ```
   [T][] buy gift for my bestie :
   Note 1: maybe a cactus would be good?
  ```
 #### Clear note

Deletes a note from a task.
   
*Command: clear note NOTE_NUMBER from task TASK_NUMBER*
   
Examples of input:
   ```
   clear note 1 from task 1
   ```
Example of output:
  ```
   Got it! I've deleted the note from [T][] buy gift for my bestie
  ```
Example of task list after clear note:
  ```
   [T][] buy gift for my bestie :
  ```
### Search for a task 
   
*Command: find KEY_WORDS*
   
Examples of input:
   ```
   find gift
   ```
Example of output:
  ```
   Here are the matched tasks:
   1.[T][] buy gift for my bestie
  ```
### Delete 
   
*Command: delete TASK_NUMBER*
   
Examples of input:
   ```
   delete 1
   ```
Example of output:
  ```
   Got it, I've deleted the task!
   Now you have 2 tasks in the list
  ```
Example of task list after command:
  ```
  Here is your to-do:
  1.[D][ ] book venue for party (at: Feb. 28 2022 07:15 pm to Feb. 28 2022 10:15 pm)
  2.[E][ ] birthday party (at: Feb. 28 2022 07:15 pm to Feb. 28 2022 10:15 pm)
  ```
### Storing tasks in database
Every change in each task is recorded in a file called duke.txt. When the programme is run again, previous task lists will be available for viewing and use.

### Exit
Exits the programme.
*Command: bye*

## Command Summary

| Command | Description |
| --- | --- |
| todo TASK_NAME | adds a todo with specified task name |
| deadline TASK_NAME /by YYYY-MM-DD hh:mm | adds a deadline to the task list |
| event TASK_NAME /at YYYY-MM-DD hh:mm /to YYYY-MM-DD hh:mm | adds a event to the task list |
| list | displays all tasks |
| mark TASK_NUMBER | marks specified task as done |
| unmark TASK_NUMBER | unmarks specified task |
| find KEY_WORD | returns only tasks that have the keyword | 
| delete TASK_NUMBER | deletes specified task from list | 
| add note to task TASK_NUMBER NOTE_MESSAGE | adds a note to specified task | 
| show note from task TASK_NUMBER| shows notes that have been added to specified task |
| edit note NOTE_NUMBER from task TASK_NUMBER NEW_NOTE_MESSAGE | edits a note from specified task | 
| delete note NOTE_NUMBER from task TASK_NUMBER | deletes a note from specified task | 
| exit | closes the program |
