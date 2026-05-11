import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import { PageWrapper } from '../components/layout/PageWrapper'

const Placeholder = ({ name }: { name: string }) => (
    <div>
        <h1 className="text-display-lg font-display-lg text-on-background">{name}</h1>
    </div>
)

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Navigate to="/diary" replace />} />

                <Route path="/login" element={<Placeholder name="Login" />} />
                <Route path="/register" element={<Placeholder name="Registro" />} />

                <Route path="/diary" element={<PageWrapper><Placeholder name="Mi Diario" /></PageWrapper>} />
                <Route path="/catalog" element={<PageWrapper><Placeholder name="Exploración" /></PageWrapper>} />
                <Route path="/watchlist" element={<PageWrapper><Placeholder name="Watchlist" /></PageWrapper>} />

                <Route path="*" element={<PageWrapper><Placeholder name="404" /></PageWrapper>} />
            </Routes>
        </BrowserRouter>
    )
}