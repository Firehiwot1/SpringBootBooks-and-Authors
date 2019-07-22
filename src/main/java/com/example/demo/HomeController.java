package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String index(Model model){
        //first create an Author
    Author author=new Author();
    author.setName("Fre");

    //create A Book
    Book book =new Book();
    book.setTitle("Java Book");
    book.setYear(2019);
    book.setDescription("About  Java...");

    //Add the book to an empty list
    Set<Book> books = new HashSet<Book>();
    books.add(book);

    //Add the list of books to the author's book list
        author.setBooks(books);

    //Save the author to the database
    authorRepository.save(author);

    //Grad all the authors from the database and send them to the template
    model.addAttribute("authors", authorRepository.findAll());
    return "index";

}
}
