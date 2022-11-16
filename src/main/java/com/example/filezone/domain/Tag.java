package com.example.filezone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tb_tag")
@Getter
@Setter
@NoArgsConstructor
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    private Long id;

    @Column(name = "content",nullable = false, length = 100)
    private String content;

    @ManyToMany(mappedBy = "relatedTags")
    Set<File> relatedFiles = new HashSet<>();
}
