"use client"
import React, { useEffect, useState } from "react";
import books from "@/mocks/MockBooks";
import { useRouter } from "next/navigation";
import { Book } from "@/models/Book";
import { BookService } from "@/services/BookService";

export default function Home() {
  const [bookList, setBookList] = useState<Book[]>([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [reason, setReason] = useState("");
  const [activeBookIndex, setActiveBookIndex] = useState(-1);
  const [search, setSearch] = useState("");
  const router = useRouter();
  const bookService = new BookService();

  useEffect(() => {
    bookService.findAll().then((response) => {
      setBookList(response.data);
    });
  }, [search]);

  const openModal = (index: number) => {
    setIsModalOpen(true);
    setActiveBookIndex(index)
  };

  const closeModal = () => {
    setIsModalOpen(false);
    setReason("");
  };

  const changeStatus = (book: Book, index: number) => {
    const updatedBooks = [...bookList];
    if (book.active) {
      updatedBooks[index].active = false;
      alert(`Livro ${book.title} inativado com sucesso!`);
    } else {
      updatedBooks[index].active = true;
      alert(`Livro ${book.title} ativado com sucesso!`);
    }
    setBookList(updatedBooks);
  };

  return (
    <div className="bg-gradient-to-r from-gray-700 to-gray-400 min-h-screen">
      <div className="flex flex-col items-center">
        <h1 className="mx-auto w-fit h-8 mt-10 text-white text-3xl font-semibold leading-7 ">All Books</h1>
        <div className="shadow-md sm:rounded-lg mt-4 w-8/12">
          <div className="flex justify-between">
            <input placeholder="Pesquise por Titulo, Autor, Categoria, Editora ou Status" className="bg-gray-700 text-white px-2 py-1 w-10/12 mt-2 mb-2 mr-1 rounded-md" onChange={(e) => setSearch(e.target.value)} />
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
              {bookList.map((book, index) => (
                <tr onClick={() => router.push(`/update/${book.id}`)} key={index} className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600 cursor cursor-pointer">
                  <td className="px-6 py-4 text-white">{book.title}</td>
                  <td className="px-6 py-4 text-white">{book.author.name}</td>
                  <td className="px-6 py-4 text-white">{book.categories.map((category) => category.name + " ")}</td>
                  <td className="px-6 py-4 text-white">{book.publishingCompany.name}</td>
                  <td className="px-6 py-4 text-white">{book.active ? "Active" : "Inactive"}</td>
                  <td className="px-6 py-4 text-white">
                    <button onClick={(e) => { e.stopPropagation(); openModal(index) }} className={`px-4 py-2 ${book.active ? 'bg-red-600 hover:bg-red-500' : 'bg-green-600 hover:bg-green-500'} text-white rounded`}>
                      {book.active ? 'Inactivate' : 'Activate'}
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        {isModalOpen && (
          <div className="modal absolute inset-0 flex items-center justify-center"> {/* Posição absoluta para a modal */}
            <div className="modal-content bg-white w-1/2 p-6 rounded-lg shadow-lg"> {/* Estilo para a modal */}
              <span className="close absolute top-0 right-0 mt-4 mr-4 cursor-pointer" onClick={closeModal}>&times;</span>
              <h2>Reason for {bookList[activeBookIndex].active ? "Deactivating" : "Activating"} Book</h2>
              <input
                type="text"
                value={reason}
                onChange={(e) => setReason(e.target.value)}
                placeholder="Enter reason..."
                className="border border-gray-400 p-2 rounded-md w-full mt-2"
              />
              <div className="flex justify-end mt-4">
                <button onClick={() => {
                  closeModal();
                  changeStatus(bookList[activeBookIndex], activeBookIndex);
                }} className="bg-blue-600 text-white px-4 py-2 rounded-md mr-2">Confirm</button>
                <button onClick={closeModal} className="bg-gray-400 text-gray-700 px-4 py-2 rounded-md">Cancel</button>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
