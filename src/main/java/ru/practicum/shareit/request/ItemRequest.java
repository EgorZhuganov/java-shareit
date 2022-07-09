package ru.practicum.shareit.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.user.User;
import ru.practicum.shareit.utils.BaseModel;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "item_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemRequest implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "created", nullable = false)
    private LocalDateTime created;
    @ManyToOne
    private User requester;

}
