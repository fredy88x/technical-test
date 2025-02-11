"use client"
import 'bootstrap/dist/css/bootstrap.css';
import "./globals.css";
import Link from "next/link";
import { usePathname } from "next/navigation";


export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  const pathname = usePathname();
  return (
    <html lang="en" suppressHydrationWarning>
      <body>
        <div className="flex h-screen">
      <aside className="w-64 bg-gray-900 text-white p-5">
        <h2 className="text-lg font-bold mb-4">Menú</h2>
        <nav className="space-y-2">
          <NavLink href="/" active={pathname === "/"}>Inicio</NavLink>
          <NavLink href="/product" active={pathname === "/product"}>Product</NavLink>
          <NavLink href="/company" active={pathname === "/company"}>Company</NavLink>
          <NavLink href="/inventory" active={pathname === "/inventory"}>Inventory</NavLink>
        </nav>
      </aside>

      <main className="flex-1 p-6 bg-gray-100 overflow-auto">{children}</main>
    </div>
      </body>
    </html>
  );
}

function NavLink({ href, active, children }: { href: string; active: boolean; children: React.ReactNode }) {
  return (
    <Link href={href} className={`block p-2 rounded-md ${active ? "bg-blue-500" : "hover:bg-gray-700"}`}>
      {children}
    </Link>
  );
}
