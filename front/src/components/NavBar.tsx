"use client"
import { useState } from 'react';
import { useRouter } from 'next/navigation';

export default function NavBar() {
    const [isMenuOpen, setIsMenuOpen] = useState(false);
    const router = useRouter();

    const toggleMenu = () => {
        setIsMenuOpen(!isMenuOpen);
    };

    return (
        <nav className="bg-black h-16">
            <div className="max-w-fit flex flex-wrap items-center justify-center mx-auto p-4 h-full cursor cursor-pointer">
                <a onClick={() => router.push("/") } className="flex items-center space-x-3 rtl:space-x-reverse">
                    <span className="self-center text-3xl font-semibold whitespace-nowrap text-white">Home</span>
                </a>
            </div>
        </nav>
    );
}
