import { Book } from "@/models/Book";

const books: Book[] = [
    new Book({
        id: 1,
        title: 'To Kill a Mockingbird',
        author: 'Harper Lee',
        category: 'Fiction',
        year: '1960',
        publisher: 'J.B. Lippincott & Co.',
        acquisitionValue: '20.00',
        edition: 'First edition',
        ISBN: '978-0-06-112008-4',
        numPages: '281',
        synopsis: 'To Kill a Mockingbird is a novel by Harper Lee published in 1960...',
        height: '8.25',
        width: '5.50',
        weight: '12',
        depth: '0.75',
        priceGroup: 'A',
        barcode: '1234567890123',
        active: true
    }),
    new Book({
        id: 2,
        title: '1984',
        author: 'George Orwell',
        category: 'Science Fiction',
        year: '1949',
        publisher: 'Secker & Warburg',
        acquisitionValue: '18.50',
        edition: 'First edition',
        ISBN: '978-0-452-28423-4',
        numPages: '328',
        synopsis: '1984 is a dystopian social science fiction novel by English novelist...',
        height: '7.50',
        width: '5.00',
        weight: '10',
        depth: '1.00',
        priceGroup: 'B',
        barcode: '2345678901234',
        active: true
    }),
    new Book({
        id: 3,
        title: 'The Great Gatsby',
        author: 'F. Scott Fitzgerald',
        category: 'Fiction',
        year: '1925',
        publisher: 'Charles Scribner\'s Sons',
        acquisitionValue: '15.75',
        edition: 'First edition',
        ISBN: '978-0-7432-7356-5',
        numPages: '180',
        synopsis: 'The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald...',
        height: '7.75',
        width: '5.25',
        weight: '11',
        depth: '0.50',
        priceGroup: 'A',
        barcode: '3456789012345',
        active: true
    }),
    new Book({
        id: 4,
        title: 'Pride and Prejudice',
        author: 'Jane Austen',
        category: 'Fiction',
        year: '1813',
        publisher: 'T. Egerton, Whitehall',
        acquisitionValue: '22.00',
        edition: 'First edition',
        ISBN: '978-0-19-953556-9',
        numPages: '279',
        synopsis: 'Pride and Prejudice is a romantic novel of manners written by Jane Austen...',
        height: '8.00',
        width: '5.50',
        weight: '13',
        depth: '1.00',
        priceGroup: 'B',
        barcode: '4567890123456',
        active: true
    }),
    new Book({
        id: 5,
        title: 'The Catcher in the Rye',
        author: 'J.D. Salinger',
        category: 'Fiction',
        year: '1951',
        publisher: 'Little, Brown and Company',
        acquisitionValue: '21.50',
        edition: 'First edition',
        ISBN: '978-0-316-76948-4',
        numPages: '224',
        synopsis: 'The Catcher in the Rye is a novel by J.D. Salinger, partially published...',
        height: '7.75',
        width: '5.25',
        weight: '12',
        depth: '0.75',
        priceGroup: 'A',
        barcode: '5678901234567',
        active: true
    }),
    new Book({
        id: 6,
        title: 'Moby-Dick; or, The Whale',
        author: 'Herman Melville',
        category: 'Fiction',
        year: '1851',
        publisher: 'Richard Bentley (UK)',
        acquisitionValue: '19.75',
        edition: 'First edition',
        ISBN: '978-0-14-243724-7',
        numPages: '624',
        synopsis: 'Moby-Dick is an 1851 novel by American writer Herman Melville...',
        height: '9.00',
        width: '6.00',
        weight: '15',
        depth: '1.25',
        priceGroup: 'B',
        barcode: '6789012345678',
        active: true
    }),
    new Book({
        id: 7,
        title: 'The Lord of the Rings',
        author: 'J.R.R. Tolkien',
        category: 'Fantasy',
        year: '1954',
        publisher: 'Allen & Unwin',
        acquisitionValue: '25.00',
        edition: 'First edition',
        ISBN: '978-0-261-10240-3',
        numPages: '1178',
        synopsis: 'The Lord of the Rings is an epic high-fantasy novel by English author...',
        height: '9.50',
        width: '6.50',
        weight: '18',
        depth: '1.75',
        priceGroup: 'A',
        barcode: '7890123456789',
        active: true
    }),
    new Book({
        id: 8,
        title: 'The Hobbit',
        author: 'J.R.R. Tolkien',
        category: 'Fantasy',
        year: '1937',
        publisher: 'George Allen & Unwin',
        acquisitionValue: '23.00',
        edition: 'First edition',
        ISBN: '978-0-618-26030-0',
        numPages: '310',
        synopsis: 'The Hobbit, or There and Back Again, is a children\'s fantasy novel by English...',
        height: '8.00',
        width: '5.50',
        weight: '14',
        depth: '0.75',
        priceGroup: 'B',
        barcode: '8901234567890',
        active: true
    })
];

export default books;
