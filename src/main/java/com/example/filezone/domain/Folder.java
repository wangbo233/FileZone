package com.example.filezone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Folder")
@Table(name = "tb_folder")
@Getter
@Setter
@NoArgsConstructor
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",length = 100)
    private String name;

    @OneToMany(mappedBy = "belongingFolder",fetch = FetchType.LAZY)
    Set<File> containedFiles = new HashSet<>();
}
