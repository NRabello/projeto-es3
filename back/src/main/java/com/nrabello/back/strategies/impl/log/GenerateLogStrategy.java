package com.nrabello.back.strategies.impl.log;

import com.nrabello.back.database.impl.BookDao;
import com.nrabello.back.domain.Book;
import com.nrabello.back.strategies.IStrategy;
import com.nrabello.back.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class GenerateLogStrategy implements IStrategy<Book> {

    @Autowired
    BookDao dao;

    @Override
    public List<Book> process(Book book) {
        Optional<Book> oldBook = dao.findById(book.getId());
        if (!oldBook.isPresent()) {
            System.out.println("O seguinte livro foi salvo:");
            printBookDetails(book);
        } else {
            System.out.println("Livro antigo");
            printBookDetails(oldBook.get());
            System.out.println("----------");
            System.out.println("Livro novo");
            printBookDetails(book);
        }
        return null;
    }

    private void printBookDetails(Book book) {
        System.out.println("Título: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor().getName());
        System.out.println("Categorias: " + book.getCategories().stream()
                        .map(Category::getName)
                        .collect(Collectors.joining(", ")));
        System.out.println("Ano: " + book.getYear());
        System.out.println("Editora: " + book.getPublishingCompany().getName());
        System.out.println("Valor de Aquisição: " + book.getValue());
        System.out.println("Edição: " + book.getEdition());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Páginas: " + book.getPages());
        System.out.println("Sinopse: " + book.getSynopsis());
        System.out.println("Dimensões:" +
                " Altura: " + book.getDimensions().getHeight() + " - Largura: " + book.getDimensions().getWidth() + " - Profundidade: " +book.getDimensions().getDepth() + " - Peso: " + book.getDimensions().getWeight());
        System.out.println("Grupo de Precificação: " + book.getPricingGroup().getName());
        System.out.println("Código de Barras: " + book.getBarcode());
        System.out.println("Ativo: " + book.getActive());
    }
}

