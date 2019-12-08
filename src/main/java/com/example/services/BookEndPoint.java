package com.example.services;

import com.example.demo.repo.BookRepository;
import com.example.services.booksvc.AddBookRequest;
import com.example.services.booksvc.AddBookResponse;
import com.example.services.booksvc.GetBookRequest;
import com.example.services.booksvc.GetBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;



/**
 * Created by Александр on 07.12.2019.
 */

@Endpoint
public class BookEndPoint {

    private static final String NAMESPACE_URL="http://com/example/services/bookSvc";


    private BookRepository bookRepository;

    @Autowired
    public BookEndPoint(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // To handle getBookRequest
    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getBook(@RequestPayload GetBookRequest request){
        GetBookResponse responce = new GetBookResponse();
        responce.setBook(bookRepository.findBook(request.getName()));

        return responce;
    }


    // To handle addBookRequest
    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "addBookRequest")
    @ResponsePayload
    public AddBookResponse addbook(@RequestPayload AddBookRequest request){
        AddBookResponse responce = new AddBookResponse();
        bookRepository.addBook(request.getBook());
        responce.setStatus("SUCCESS");
        return responce;
    }





}
