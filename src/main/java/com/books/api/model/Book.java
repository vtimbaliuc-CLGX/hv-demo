package com.books.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Book {

    public String Author;
    public String Title;
    public String ISBN;
    public int PublishYear;
}
