package com.github.mateuszlisowski.springjpatutorial.rent;

import com.github.mateuszlisowski.springjpatutorial.book.Book;
import com.github.mateuszlisowski.springjpatutorial.member.Member;
import com.github.mateuszlisowski.springjpatutorial.rent.schemas.RentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository repository;

    public RentResponse serializeRent(Rent rent) {
        return new RentResponse(
                rent.getId(),
                rent.getRentStart(),
                rent.getRentEnd(),
                rent.getDueDate(),
                rent.getMember().getId(),
                rent.getBook().getId()
        );
    }

    public void rentBook(Book book, Member member) {

    }

}
