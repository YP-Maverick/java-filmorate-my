package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import ru.yandex.practicum.filmorate.validator.ValidFilmReleaseDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode
public class Film {

    private int id;
    
    @NotBlank(message = "Name should not be blank")
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Length(max = 200, message = "Description len must be greater than 200")
    private String description;

    // Кастомная аннотация-валидотор
    @ValidFilmReleaseDate
    private LocalDate releaseDate;

    @Positive(message = "must be greater than 0")
    private int duration;
}
