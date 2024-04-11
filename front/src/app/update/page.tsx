"use client"
import { ChangeEvent, FormEvent, useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';
import books from '@/mocks/MockBooks';
import { Book } from '@/models/Book';

export default function BookFormUpdate() {
  const [bookData, setBookData] = useState<Book>(books[0])
  const router = useRouter();

  const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    setBookData(prevState => ({
      ...prevState,
      [name]: value
    })as Book);
  };

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    alert(`Livro alterado com sucesso`);
    router.push("/");
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="space-y-12 py-12 px-96 bg-gradient-to-r from-pink-600 to-cyan-700">
        <div className="bg-white pb-12 py-2 px-12 shadow-2xl">
          <h1 className="mx-auto mt-2 w-fit h-8 bg-clip-text text-transparent bg-gradient-to-r from-pink-600/80 to-cyan-700/90 text-3xl text-center font-semibold leading-7 ">Book Alteration</h1>
          <div className="mt-4 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
            <div className="sm:col-span-4">
              <label htmlFor="title" className="block text-sm font-medium leading-6 text-gray-900">
                Title <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="title"
                id="title"
                value={bookData.title}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="category" className="block text-sm font-medium leading-6 text-gray-900">
                Category <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="category"
                id="category"
                value={bookData.category}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-4">
              <label htmlFor="author" className="block text-sm font-medium leading-6 text-gray-900">
                Author <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="author"
                id="author"
                value={bookData.author}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="year" className="block text-sm font-medium leading-6 text-gray-900">
                Year <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="year"
                id="year"
                value={bookData.year}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-4">
              <label htmlFor="publisher" className="block text-sm font-medium leading-6 text-gray-900">
                Publisher <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="publisher"
                id="publisher"
                value={bookData.publisher}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="acquisitionValue" className="block text-sm font-medium leading-6 text-gray-900">
                Acquisition Value <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="acquisitionValue"
                id="acquisitionValue"
                value={bookData.acquisitionValue}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="edition" className="block text-sm font-medium leading-6 text-gray-900">
                Edition <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="edition"
                id="edition"
                value={bookData.edition}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="ISBN" className="block text-sm font-medium leading-6 text-gray-900">
                ISBN <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="ISBN"
                id="ISBN"
                value={bookData.ISBN}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="numPages" className="block text-sm font-medium leading-6 text-gray-900">
                Number of Pages <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="numPages"
                id="numPages"
                value={bookData.numPages}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-6">
              <label htmlFor="synopsis" className="block text-sm font-medium leading-6 text-gray-900">
                Synopsis <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                id="synopsis"
                name="synopsis"
                value={bookData.synopsis}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-3">
              <label htmlFor="height" className="block text-sm font-medium leading-6 text-gray-900">
                Height <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="height"
                id="height"
                value={bookData.height}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-3">
              <label htmlFor="width" className="block text-sm font-medium leading-6 text-gray-900">
                Width <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="width"
                id="width"
                value={bookData.width}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-3">
              <label htmlFor="weight" className="block text-sm font-medium leading-6 text-gray-900">
                Weight <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="weight"
                id="weight"
                value={bookData.weight}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-3">
              <label htmlFor="depth" className="block text-sm font-medium leading-6 text-gray-900">
                Depth <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="depth"
                id="depth"
                value={bookData.depth}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-6">
              <label htmlFor="priceGroup" className="block text-sm font-medium leading-6 text-gray-900">
                Price Group <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="priceGroup"
                id="priceGroup"
                value={bookData.priceGroup}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-6">
              <label htmlFor="barcode" className="block text-sm font-medium leading-6 text-gray-900">
                Barcode <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="barcode"
                id="barcode"
                value={bookData.barcode}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="mt-6 flex items-center justify-end gap-x-6 sm:col-span-6">
              <button type="button" onClick={() => router.push("/")} className="bg-red-700 text-white rounded-md text-sm h-9 w-20 text-center font-semibold leading-6 hover:bg-red-600">
                Cancel
              </button>
              <button
                type="submit"
                className="rounded-md bg-green-600 px-3 py-2 w-20 text-sm font-semibold text-white shadow-sm hover:bg-green-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
              >
                Save
              </button>
            </div>

          </div>
        </div>
      </div>
    </form>
  );
}
