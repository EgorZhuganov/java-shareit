package ru.practicum.shareit.user.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.comment.model.Comment;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.request.model.ItemRequest;
import ru.practicum.shareit.utils.BaseModel;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements BaseModel<Long> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @OneToMany(mappedBy = "requester")
    private List<ItemRequest> requests;
    @OneToMany(mappedBy = "booker")
    private List<Booking> bookings;
    @OneToMany(mappedBy = "owner")
    private List<Item> items;
    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

}
