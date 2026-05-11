import { NavLink } from 'react-router-dom'

const footerLinks = [
  { to: '/catalog',  label: 'Exploración' },
  { to: '/diary',    label: 'Mi Diario'   },
  { to: '/privacy',  label: 'Privacidad'  },
  { to: '/terms',    label: 'Términos'    },
  { to: '/contact',  label: 'Contacto'   },
]

export const Footer = () => {
  return (
    <footer className="
      w-full px-margin py-xl mt-auto
      flex flex-col md:flex-row justify-between items-center gap-md
      bg-surface-container-lowest
      border-t border-white/5
    ">
      <NavLink
        to="/"
        className="font-title-sm text-title-sm font-bold text-primary-container"
      >
        CineLog
      </NavLink>

      <nav className="flex flex-wrap justify-center gap-md">
        {footerLinks.map(({ to, label }) => (
          <NavLink
            key={to}
            to={to}
            className={({ isActive }) =>
              isActive
                ? 'text-primary font-bold text-body-md font-body-md hover:text-primary transition-colors'
                : 'text-on-surface-variant text-body-md font-body-md hover:text-primary transition-colors'
            }
          >
            {label}
          </NavLink>
        ))}
      </nav>

      <p className="text-label-caps font-label-caps text-on-surface-variant">
        © 2026 CineLog. Your cinematic journey, archived.
      </p>
    </footer>
  )
}