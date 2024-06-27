"use client"
import { ReasonActivationDeactivationService } from "@/services/ReasonActivationDeactivationService";
import { BookService } from "@/services/BookService";
import React, { useEffect, useState } from "react";
import { useRouter } from "next/navigation";
import Dialog from "@/components/Dialog";
import { Book } from "@/models/Book";
import { ReasonActivationDeactivation } from "@/models/ReasonActivationDeactivation";

export default function Home() {
  const [bookList, setBookList] = useState<Book[]>([]);
  const [filteredBooks, setFilteredBooks] = useState<Book[]>([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [selectedBook, setSelectedBook] = useState<Book>();
  const [search, setSearch] = useState("");
  const router = useRouter();
  const bookService = new BookService();
  const reasonService = new ReasonActivationDeactivationService();

  useEffect(() => {
    bookService.findAll().then((response) => {
      setBookList(response.data);
      setFilteredBooks(response.data);
    });
  }, [search]);

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const searchValue = e.target.value;

    if (searchValue.trim() === "") {
      setFilteredBooks(bookList);
      return;
    }

    const filters = searchValue.split(" - ").map(filter => filter.trim().toLowerCase());

    let filtered = bookList.filter(book =>
      filters.some(filter =>
        book.title.toLowerCase().includes(filter) ||
        book.author.name.toLowerCase().includes(filter) ||
        book.categories.some(category => category.name.toLowerCase().includes(filter)) ||
        book.publishingCompany.name.toLowerCase().includes(filter) ||
        (book.isbn && book.isbn.toLowerCase().includes(filter))
      )
    );

    setFilteredBooks(filtered);
  };


  const openModal = (book: Book) => {
    setIsModalOpen(true);
    setSelectedBook(book);
  };

  const closeModal = () => {
    setIsModalOpen(false);
  };

  const changeStatus = async (book: Book, reason: string) => {
    try{
      if (book.active) {
        book.active = false;
        await bookService.update(book);
        await reasonService.save(new ReasonActivationDeactivation({
          description: reason,
          book: book,
          type: 'desativacao'
        })
        );
        alert(`Livro ${book.title} inativado com sucesso!`);
      } else {
        book.active = true;
        await bookService.update(book);
        await reasonService.save(new ReasonActivationDeactivation({
          description: reason,
          book: book,
          type: 'ativacao'
        })
        );
        alert(`Livro ${book.title} ativado com sucesso!`);
      }
    }catch(error){
      alert("Erro ao inativar/ativar livro: " + error);
    }
  };

  return (
    <div className="bg-gradient-to-r from-gray-700 to-gray-400 min-h-screen">
      <div className="flex flex-col items-center">
        <h1 className="mx-auto w-fit h-8 mt-10 text-white text-3xl font-semibold leading-7 ">All Books</h1>
        <div className="shadow-md sm:rounded-lg mt-4 w-8/12">
          <div className="flex justify-between">
            <input 
              placeholder="Pesquise por Titulo, Autor, Categoria, Editora ou ISBN separando por (-) "
              className="bg-gray-700 text-white px-2 py-1 w-10/12 mt-2 mb-2 mr-1 rounded-md" 
              onChange={(e) => handleSearchChange(e)} 
            />
            <button onClick={() => router.push("/create")} className="w-48 bg-gray-700 mt-2 mb-2 text-white px-2 py-1 rounded-md hover:bg-green-800">Adicionar Livro</button>
          </div>
          <table className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
            <thead className="text-xs text-white uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-300">
              <tr>
                <th scope="col" className="px-6 py-3">
                  Title
                </th>
                <th scope="col" className="px-6 py-3">
                  Author
                </th>
                <th scope="col" className="px-6 py-3">
                  Category
                </th>
                <th scope="col" className="px-6 py-3">
                  Publisher
                </th>
                <th scope="col" className="px-6 py-3">
                  Status
                </th>
                <th scope="col" className="px-6 py-3">
                  Actions
                </th>
              </tr>
            </thead>
            <tbody>
              {filteredBooks.map((book, index) => (
                <tr onClick={() => router.push(`/update/${book.id}`)} key={index} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600 cursor cursor-pointer">
                  <td className="px-6 py-4 text-white">{book.title}</td>
                  <td className="px-6 py-4 text-white">{book.author.name}</td>
                  <td className="px-6 py-4 text-white">{book.categories.map((category) => category.name + " ")}</td>
                  <td className="px-6 py-4 text-white">{book.publishingCompany.name}</td>
                  <td className="px-6 py-4 text-white">{book.active ? "Active" : "Inactive"}</td>
                  <td className="px-6 py-4 text-white">
                    <button onClick={(e) => { e.stopPropagation(); openModal(book) }} className={`px-4 py-2 ${book.active ? 'bg-red-600 hover:bg-red-500' : 'bg-green-600 hover:bg-green-500'} text-white rounded w-[100px]`}>
                      {book.active ? 'Inactivate' : 'Activate'}
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        {isModalOpen && (
          <Dialog
            book={selectedBook as Book}
            open={isModalOpen}
            onClose={closeModal}
            onConfirm={(reason) => {
              closeModal();
              changeStatus(selectedBook as Book, reason);
            }}
          />
        )}
      </div>
    </div>
  );
}
