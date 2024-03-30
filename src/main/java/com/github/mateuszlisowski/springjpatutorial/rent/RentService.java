package com.github.mateuszlisowski.springjpatutorial.rent;

import com.github.mateuszlisowski.springjpatutorial.book.Book;
import com.github.mateuszlisowski.springjpatutorial.book.BookService;
import com.github.mateuszlisowski.springjpatutorial.member.Member;
import com.github.mateuszlisowski.springjpatutorial.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RentService {

    private final MemberService memberService;
    private final BookService bookService;

    public RentSchema serializeRent(Rent rent) {
        return new RentSchema(
                rent.getRentStart(),
                rent.getRentEnd(),
                rent.getDueDate(),
                rent.getMember().getId(),
                rent.getBook().getId()
        );
    }

    public Rent deserializeRent(RentSchema schema) {
        Rent rent = new Rent();
        rent.setRentStart(schema.rentStart());
        rent.setRentEnd(schema.rentEnd());
        rent.setDueDate(schema.dueDate());

        Optional<Member> member = memberService.getMemberById(rent.getMember().getId());
        if (member.isEmpty()) {
            throw new RuntimeException("Error while deserializing rent");
        }

        Optional<Book> book = bookService.getBookById(rent.getBook().getId());
        if (book.isEmpty()) {
            throw new RuntimeException("Error while deserializing rent");
        }

        rent.setMember(member.get());
        rent.setBook(book.get());

        return rent;
    }
}
