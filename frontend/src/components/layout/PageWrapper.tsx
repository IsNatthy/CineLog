import { Navbar } from './Navbar'
import { Footer } from './Footer'

interface Props {
  children: React.ReactNode
}

export const PageWrapper = ({ children }: Props) => {
  return (
    <div className="bg-background text-on-background font-body-md min-h-screen flex flex-col">
      <Navbar />
      <main className="flex-grow pt-xl px-margin pb-xl max-w-7xl mx-auto w-full">
        {children}
      </main>
      <Footer />
    </div>
  )
}