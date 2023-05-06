package com.goit.todolist.note;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "client")

public class Note {
    @Id
    private Long id;
    private String title;
    private String content;

}
