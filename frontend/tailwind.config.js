/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  darkMode: 'class',
  theme: {
    extend: {
      colors: {
        'background':                 '#131313',
        'surface':                    '#131313',
        'surface-dim':                '#131313',
        'surface-bright':             '#3a3939',
        'surface-container-lowest':   '#0e0e0e',
        'surface-container-low':      '#1c1b1b',
        'surface-container':          '#201f1f',
        'surface-container-high':     '#2a2a2a',
        'surface-container-highest':  '#353534',
        'surface-variant':            '#353534',
        'surface-tint':               '#c9b3ff',

        'on-background':              '#e5e2e1',
        'on-surface':                 '#e5e2e1',
        'on-surface-variant':         '#ccc0e0',

        'outline':                    '#7c5fa0',
        'outline-variant':            '#4a3560',

        'primary':                    '#c9b3ff',
        'on-primary':                 '#2d005e',
        'primary-fixed':              '#ecdeff',
        'primary-fixed-dim':          '#c9b3ff',
        'on-primary-fixed':           '#1a0042',
        'on-primary-fixed-variant':   '#5200b3',
        'primary-container':          '#7c3aed',
        'on-primary-container':       '#f5eeff',
        'inverse-primary':            '#5200b3',

        'secondary':                  '#ffdf9e',
        'on-secondary':               '#3f2e00',
        'secondary-container':        '#fabd00',
        'secondary-fixed':            '#ffdf9e',
        'secondary-fixed-dim':        '#fabd00',
        'on-secondary-fixed':         '#261a00',
        'on-secondary-fixed-variant': '#5b4300',
        'on-secondary-container':     '#6a4e00',

        'tertiary':                   '#a7c8ff',
        'on-tertiary':                '#003061',
        'tertiary-container':         '#0072d7',
        'on-tertiary-container':      '#f8f9ff',
        'tertiary-fixed':             '#d5e3ff',
        'tertiary-fixed-dim':         '#a7c8ff',
        'on-tertiary-fixed':          '#001b3c',
        'on-tertiary-fixed-variant':  '#004689',

        'error':                      '#ffb4ab',
        'on-error':                   '#690005',
        'error-container':            '#93000a',
        'on-error-container':         '#ffdad6',

        'inverse-surface':            '#e5e2e1',
        'inverse-on-surface':         '#313030',
      },

      borderRadius: {
        DEFAULT: '0.25rem',
        lg:      '0.5rem',
        xl:      '0.75rem',
        full:    '9999px',
      },

      spacing: {
        margin:  '24px',
        xs:       '4px',
        sm:      '12px',
        base:     '8px',
        lg:      '40px',
        gutter:  '16px',
        xl:      '64px',
        md:      '24px',
      },

      fontFamily: {
        'title-sm':    ['Hanken Grotesk', 'sans-serif'],
        'body-md':     ['Hanken Grotesk', 'sans-serif'],
        'label-caps':  ['Hanken Grotesk', 'sans-serif'],
        'headline-md': ['Playfair Display', 'serif'],
        'display-lg':  ['Playfair Display', 'serif'],
      },

      fontSize: {
        'title-sm':    ['20px', { lineHeight: '1.4',  fontWeight: '600' }],
        'body-md':     ['16px', { lineHeight: '1.6',  fontWeight: '400' }],
        'label-caps':  ['14px', { lineHeight: '1',    letterSpacing: '0.1em', fontWeight: '700' }],
        'headline-md': ['32px', { lineHeight: '1.2',  fontWeight: '600' }],
        'display-lg':  ['48px', { lineHeight: '1.1',  letterSpacing: '-0.02em', fontWeight: '700' }],
      },
    },
  },
  plugins: [],
}