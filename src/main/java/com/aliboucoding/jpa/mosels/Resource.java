package com.aliboucoding.jpa.mosels;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "resource_type")
public class Resource {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int size;

    private String url;

    private String type;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
