package com.cello.vacu.Services;

import com.cello.vacu.Model.Book;
import com.cello.vacu.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class BookServices {

    @Autowired
    private BookRepository bookRepo;

    private static List<Book> list = new ArrayList<>();

    /*static {
        list.add(new Book(12,"Java","by McGrew Hill"));
        list.add(new Book(13,"Python","by McGrew Hill"));
        list.add(new Book(14,"Ruby","by McGrew Hill"));
    }*/

    public List<Book> getAllBooks()
    {
        return list;
    }

    public List<Book> repoGetAllBooks()
    {
        List<Book> listrepo = (List<Book>)this.bookRepo.findAll();
        return listrepo;
    }

    public static void main(String args[])
    {
        /*Book book = null;
        book=list.stream().filter(i->i.getId()==id).findFirst().get();*/
        List<Integer> listInt= Arrays.asList(1,9,29,27,2,17,28,27,2,182,179);
        //add
        System.out.println(listInt.stream().map(i-> i+i).sorted().collect(Collectors.toList()));

        //even
        System.out.println(listInt.stream().filter(i -> i%2==0).collect(Collectors.toList()));
        listInt.stream().filter(integer -> {if(integer%2==0) { return true; }
        else return false;
        }).forEach(System.out::println);

        //starts with 1
        System.out.println(listInt.stream().filter(i-> Integer.toString(i).startsWith("1" +
                "")).collect(Collectors.toList()));

        //first element
        System.out.println(listInt.stream().findFirst().get());

        //element
        System.out.println(listInt.stream().count());

        //max
        System.out.println(listInt.stream().max(Integer::compareTo).get());

        //
        System.out.println(listInt.stream().max(Integer::compareTo).get());
        /*return book;*/
    }

    public Book repoGetBooksById(int id)
    {
        Book book=null;
        try {
            book=this.bookRepo.findById(id);
        }
        catch (Exception e)
        {
        }
        return book;
    }

    //adding book - POST
    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }

    //adding book - repository by DB
    public Book repoAddBook(Book b)
    {
        Book result= bookRepo.save(b);
        return result;
    }

    //Delete book - DELETE
    public void deleteBook(int bookId)
    {
        list= list.stream().filter(book -> {
            if(book.getId()!= bookId)
            {
                return true;
            }
            else
            {
                return false;
            }
        }).collect(Collectors.toList());
    }

    //Delete book - DELETE
    public void repoDeleteBook(int bookId)
    {
        bookRepo.deleteById(bookId);
    }

    public void updateBooks(Book book, int bookId)
    {
        list = list.stream().map(b->{
            if(b.getId() == bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;}).collect(Collectors.toList());
    }

    public void repoUpdateBooks(Book book, Long bookId)
    {
        book.setId(bookId);
        bookRepo.save(book);
    }

    public void stream()
    {
        //type 1 to create a List - Immutable List
        /*List<Integer> list = List.of(2,6,7,28,28,21);
        System.out.println(list);*/

        //type 2 to create a List - mutuable List
        List<Integer> list2 = new ArrayList<>();
        list2.add(36);
        System.out.println(list2);

        //type 3 to create a List - Immutable List
        List<Integer> list3 = Arrays.asList(12, 34, 23, 23, 2, 345, 6, 7);
        System.out.println(list3);

        //without stream API
        for(int i: list3)
        {
            if (i%2==0)
            {
                System.out.println(i);
            }
        }

        //with stream
        List<Integer> streamList = list3.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println("Stream List" + streamList);

        //Blank Stream
        Stream<Object> streamObj = Stream.empty();

        //2. array,object,collection
        String[] name={"Suraj","Dharmesh","Akash","Pankaj","Pavan"};
        Stream<String> strem1=Stream.of(name);
        strem1.forEach(e-> System.out.println(e));

        //3. Stream Builder
        Stream<Object> streamBuilder = Stream.builder().build();

        //4. Array
        IntStream stream4 = Arrays.stream(new int[]{2, 34, 5, 6, 7, 744, 2, 43});

        //5. Collection Object
        list3.stream().forEach(i-> System.out.println(i));

        //filter
        List<String> nameList= Arrays.asList("Pankaj", "Akash", "Pavan","Dharmesh");
        List<String> filterList = nameList.stream().filter(i -> i.startsWith("P")).collect(Collectors.toList());
        System.out.println(filterList);

        List<Integer> integers = Arrays.asList(172, 272, 2728, 2828, 272);
        List<Integer> collect = integers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(collect);

        nameList.stream().forEach(i-> System.out.println(i));
        nameList.stream().forEach(System.out::println);
        System.out.println("Sorted");
        nameList.stream().sorted().forEach(System.out::println);
        Integer intList = integers.stream().min((x, y) -> x.compareTo(y)).get();
        System.out.println("compare"+intList);
    }
}
