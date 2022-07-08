package ru.practicum.shareit.booking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.utils.BaseModel;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "start", nullable = false)
    private LocalDate start;
    @Column(name = "end", nullable = false)
    private LocalDate end;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne
    private User booker;
    @Enumerated(STRING)
    private Status status;

    public enum Status {
        WAITING,
        APPROVED,
        REJECTED,
        CANCELED
    }
}
