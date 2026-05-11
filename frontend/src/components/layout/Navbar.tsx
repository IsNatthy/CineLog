import { NavLink } from 'react-router-dom'
import { Search, CircleUser } from 'lucide-react'

const navLinks = [
  { to: '/catalog',   label: 'Exploración' },
  { to: '/diary',     label: 'Mi Diario'   },
  { to: '/watchlist', label: 'Watchlist'   },
]

export const Navbar = () => {
  return (
    <header className="
      fixed top-0 left-0 w-full z-50
      flex justify-between items-center
      px-margin py-4
      bg-surface/80 backdrop-blur-xl
      border-b border-white/5
      shadow-xl shadow-black/20
    ">
      <NavLink
        to="/"
        className="font-headline-md text-headline-md font-bold tracking-tight text-primary-container"
      >
        CineLog
      </NavLink>

      <nav className="hidden md:flex items-center gap-gutter">
        {navLinks.map(({ to, label }) => (
          <NavLink
            key={to}
            to={to}
            className={({ isActive }) =>
              isActive
                ? 'text-primary-container border-b-2 border-primary-container pb-1 text-label-caps font-label-caps transition-all duration-300'
                : 'text-on-surface-variant hover:text-on-surface text-label-caps font-label-caps transition-colors duration-200'
            }
          >
            {label}
          </NavLink>
        ))}
      </nav>

      <div className="flex items-center gap-sm">
        <button aria-label="Buscar" className="text-on-surface-variant hover:text-on-surface transition-colors">
          <Search size={20} />
        </button>
        <button aria-label="Perfil" className="text-on-surface-variant hover:text-on-surface transition-colors">
          <CircleUser size={20} />
        </button>
      </div>
    </header>
  )
}