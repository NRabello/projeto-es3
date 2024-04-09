"use client"
import { useState } from 'react';

export default function NavBar() {
    const [isMenuOpen, setIsMenuOpen] = useState(false);

    const toggleMenu = () => {
        setIsMenuOpen(!isMenuOpen);
    };

    return (
        <nav className="bg-teal-500 border-gray-700 h-16 border-y">
            <div className="max-w-fit flex flex-wrap items-center justify-center mx-auto p-4 h-full">
                <a href="#" className="flex items-center space-x-3 rtl:space-x-reverse">
                    <span className="self-center text-3xl font-semibold whitespace-nowrap text-teal-900">Livros</span>
                </a>
            </div>
        </nav>
    );
}
