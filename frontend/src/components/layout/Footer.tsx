import { NavLink } from 'react-router-dom'

const footerLinks = [
  { to: '/privacy',  label: 'Privacidad'  },
  { to: '/terms',    label: 'Términos'    },
  { to: '/contact',  label: 'Contacto'   },
]

export const Footer = () => {
  return (
    <footer className="
      w-full px-margin py-md mt-auto
      flex flex-col md:flex-row justify-between items-center gap-md
      bg-surface/80 backdrop-blur-xl
      border-t border-white/5
    ">
      <NavLink
        to="/"
        className="font-headline-md text-headline-md font-bold tracking-tight text-primary-container"
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
                ? 'text-primary-container text-label-caps font-label-caps transition-colors duration-300'
                : 'text-on-surface-variant hover:text-on-surface text-label-caps font-label-caps transition-colors duration-200'
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