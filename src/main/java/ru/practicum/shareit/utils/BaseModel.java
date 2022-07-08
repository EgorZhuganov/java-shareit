package ru.practicum.shareit.utils;

import java.io.Serializable;

public interface BaseModel<T extends Serializable> {

    T getId();

}
