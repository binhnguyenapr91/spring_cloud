package me.toam.springcloud.eurekaclient.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="posts")

public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "title")
    private String title;
    @Column (name = "description")
    private String description;
    @Column (name = "content")
    private String content;
}
