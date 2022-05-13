package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends  JpaRepository <Book, Long> {

    List<Book> findByTitle(String title);

//    List<Book> findByCategory(Category category);

    List<Book> findByCategoryId(Long id);

    List<Book> findAllByRating(int rating);

    List<Book> findByRatingAndTitle(int rating, String title);


    //Tworzymy je za pomocą znaku dwukropka oraz nazwy przekazywanego parametru :paramName

    //Parametry w metodzie musimy dodatkowo opisać za pomocą adnotacji @Param("paramName").

    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitleJpql(@Param("title") String title);

//    @Query("select  b from Book  b where b.category = :category")
//    List<Book> findByCategoryJpql(@Param("category") Category category);

//    @Query("select b from Book b where b.rating between 3 and 5")
//    List<Book> findByRating(@Param("rating") Integer rating);

//    @Query("select b from Book b where b.publisher = :publisher")
//    List<Book> findByPublisher (@Param("publisher")Publisher publisher);


//    @Query("select b from Book b where b.category = :category order by b.title ")  //zapytanie nie do końca dobre
//    List<Book> findFirstByCategory (@Param("category") Category category);

}
