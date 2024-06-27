"use client"
import { ChangeEvent, FormEvent, useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';
import { Book } from '@/models/Book';
import { Author } from '@/models/Author';
import { Category } from '@/models/Category';
import { Dimension } from '@/models/Dimension';
import { PricingGroup } from '@/models/PricingGroup';
import { PublishingCompany } from '@/models/PublishingCompany';
import { BookService } from '@/services/BookService';
import { CategoryService } from '@/services/CategoryService';
import { PricingGroupService } from '@/services/PricingGroupService';

export default function BookFormUpdate({ params }: { params: { id: number } }) {
  const [bookData, setBookData] = useState<Book>(new Book());
  const [categories, setCategories] = useState<Category[]>([]);
  const [pricingGroups, setPricingGroups] = useState<PricingGroup[]>([]);
  const categoryService = new CategoryService();
  const bookService = new BookService();
  const pricingGroupService = new PricingGroupService();
  const router = useRouter();

  const handleChange = (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    const { name, value } = e.target;
    setBookData(prevState => ({
      ...prevState,
      [name]: value
    }) as Book);
  };

  const handleAuthorChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setBookData(prevState => ({
      ...prevState,
      author: { ...prevState.author, [name]: value } as Author
    }));
  };

  const handlePublishingCompanyChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setBookData(prevState => ({
      ...prevState,
      publishingCompany: { ...prevState.publishingCompany, [name]: value } as PublishingCompany
    }));
  };

  const handleDimensionsChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setBookData(prevState => ({
      ...prevState,
      dimensions: { ...prevState.dimensions, [name]: value } as Dimension
    }));
  };

  const handlePricingGroupChange = (e: ChangeEvent<HTMLSelectElement>) => {
    const { value } = e.target;
    const selectedPricingGroup = pricingGroups.find(pg => pg.name === value);
    setBookData(prevState => ({
      ...prevState,
      pricingGroup: selectedPricingGroup as PricingGroup
    }));
  };

  const handleCategoryChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { value, checked } = e.target;
    setBookData(prevState => {
      const updatedCategories = checked
        ? [...(prevState.categories || []), { id: parseInt(value), name: e.target.name } as Category]
        : (prevState.categories || []).filter(category => category.id !== parseInt(value));
      return { ...prevState, categories: updatedCategories };
    });
  };

  const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      if(validateBook()){
        await bookService.update(bookData);
        alert(`Livro ${bookData.title} atualizado com sucesso!`);
        router.push("/");
      }
    } catch (error) {
      alert(`Erro ao atualizar o livro ${bookData.title}: ${error}`);
    }
  };

  const validateBook = () => {
    if ((bookData.categories).length === 0) {
      alert("Selecione ao menos uma categoria.");
      return false;
    }

    const isPriceValid = () => {
      switch (bookData.pricingGroup.id) {
        case 1:
          return bookData.value >= 1 && bookData.value <= 20;
        case 2:
          return bookData.value > 20 && bookData.value <= 50;
        case 3:
          return bookData.value > 50;
        default:
          throw new Error("Invalid pricing group ID");
      }
    }


    if (!isPriceValid()) {
      alert("Preço inválido para o grupo de precificação.");
      return false;
    }
    return true;
  }

  useEffect(() => {
    fetchBook();
    fetchCategories();
    fetchPricingGroup();
  }, []);

  const fetchBook = async () => {
    try {
      bookService.findById(params.id).then((response) => {
        setBookData(response.data);
      })
    } catch (error) {
      console.log(error);
    }
  };

  const fetchCategories = async () => {
    categoryService.findAll().then((response) => {
      setCategories(response.data);
    });
  };

  const fetchPricingGroup = async () =>{
    pricingGroupService.findAll().then((response) => {
      setPricingGroups(response.data);
    });
  }

  return (
    <form onSubmit={handleSubmit}>
      <div className="space-y-12 py-12 px-96 bg-gradient-to-r from-gray-700 to-gray-400">
        <div className="bg-white pb-12 py-2 px-12 shadow-2xl">
          <h1 className="mx-auto mt-2 w-fit h-8 bg-clip-text text-transparent bg-black text-3xl text-center font-semibold leading-7 ">Book Alteration</h1>
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

            <div className="sm:col-span-6">
              <label htmlFor="categories" className="block text-sm font-medium leading-6 text-gray-900">
                Categories <span className="text-red-600">*</span>
              </label>
              <details className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 sm:text-sm sm:leading-6">
                <summary className="cursor-pointer">{(bookData.categories || []).map(category => category.name).join(', ')}</summary>
                <div className="mt-2">
                  {categories.map((category) => (
                    <div key={category.id} className="flex items-center">
                      <input
                        type="checkbox"
                        id={`category-${category.id}`}
                        name={category.name}
                        value={category.id}
                        checked={(bookData.categories || []).some(cat => cat.id === category.id)}
                        onChange={handleCategoryChange}
                        className="mr-2"
                      />
                      <label htmlFor={`category-${category.id}`} className="text-sm text-gray-900">{category.name}</label>
                    </div>
                  ))}
                </div>
              </details>
            </div>

            <div className="sm:col-span-4">
              <label htmlFor="author.name" className="block text-sm font-medium leading-6 text-gray-900">
                Author <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="name"
                id="author.name"
                value={bookData.author?.name || ''}
                onChange={handleAuthorChange}
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
              <label htmlFor="publishingCompany.name" className="block text-sm font-medium leading-6 text-gray-900">
                Publisher <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="name"
                id="publishingCompany.name"
                value={bookData.publishingCompany?.name || ''}
                onChange={handlePublishingCompanyChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="value" className="block text-sm font-medium leading-6 text-gray-900">
                Value <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="value"
                id="value"
                value={bookData.value}
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
              <label htmlFor="isbn" className="block text-sm font-medium leading-6 text-gray-900">
                ISBN <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="isbn"
                id="isbn"
                value={bookData.isbn}
                onChange={handleChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-2">
              <label htmlFor="pages" className="block text-sm font-medium leading-6 text-gray-900">
                Number of Pages <span className="text-red-600">*</span>
              </label>
              <input
                type="text"
                name="pages"
                id="pages"
                value={bookData.pages}
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
                value={bookData.dimensions?.height || ''}
                onChange={handleDimensionsChange}
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
                value={bookData.dimensions?.width || ''}
                onChange={handleDimensionsChange}
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
                value={bookData.dimensions?.weight || ''}
                onChange={handleDimensionsChange}
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
                value={bookData.dimensions?.depth || ''}
                onChange={handleDimensionsChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              />
            </div>

            <div className="sm:col-span-6">
              <label htmlFor="pricingGroup" className="block text-sm font-medium leading-6 text-gray-900">
                Pricing Group <span className="text-red-600">*</span>
              </label>
              <select
                name="pricingGroup"
                id="pricingGroup"
                value={bookData.pricingGroup?.name || ''}
                onChange={handlePricingGroupChange}
                required
                className="block w-full rounded-md border-0 py-1.5 px-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
              >
                {pricingGroups.map((pricingGroup) => (
                  <option key={pricingGroup.id} value={pricingGroup.name}>{pricingGroup.name}</option>
                ))}
              </select>
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
