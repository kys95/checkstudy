package com.kys95.checkstudy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kys95.checkstudy.dto.TaskUpdateDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @OneToMany(mappedBy = "task" ,fetch = FetchType.EAGER, cascade =  CascadeType.REMOVE)
    @JsonIgnoreProperties({"task"})
    @OrderBy("id desc")
    private List<Feedback> feedbacks = new ArrayList<>();

    @Setter
    private int isSuccess;

    private String stringDeadline;

    public void update(TaskUpdateDto taskUpdateDto){
        title = taskUpdateDto.getTitle();
        content = taskUpdateDto.getContent();
        deadline = taskUpdateDto.getDeadline();
        this.stringDeadline = deadline.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm"));
    }
}
