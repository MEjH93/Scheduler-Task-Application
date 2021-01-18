package com.scheduler.schedulertask.domain;

import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EnableScheduling
@Configuration
@EqualsAndHashCode
@Table(name = "scheduler_task")
public class SchedulerTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size( max = 250, message = "Name needs to have exactly 250 characters")
    private String name;
    @Size( max = 30, message = "Recurrency needs to have exactly 30 characters")
    private String recurrency;
    @Column(name="code", columnDefinition = "CLOB NOT NULL")
    @Lob
    private String code; // text field value will represent groovy script

}
