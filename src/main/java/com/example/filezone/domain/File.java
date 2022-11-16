package com.example.filezone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
@Entity(name = "File")
@Table(name = "tb_file")
@Getter
@Setter
@NoArgsConstructor
public class File implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "path",nullable = false)
    private String path;

    @Column(name = "size")
    private Long size;

    @ManyToMany(
            targetEntity = Tag.class,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.DETACH
            },
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "tags_related",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> relatedTags = new HashSet<>();

    @ManyToOne(fetch =FetchType.LAZY)
    //指明文件表中用于存储文件夹信息的外键
    @JoinColumn(name = "folder_id")
    private Folder belongingFolder;
}
