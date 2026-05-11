import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import { PageWrapper } from '../components/layout/PageWrapper'
import { LoginPage } from '../features/auth/pages/LoginPage'
import { RegisterPage } from '../features/auth/pages/RegisterPage'

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

                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />

                <Route path="/diary" element={<PageWrapper><Placeholder name="Mi Diario" /></PageWrapper>} />
                <Route path="/catalog" element={<PageWrapper><Placeholder name="Exploración" /></PageWrapper>} />
                <Route path="/watchlist" element={<PageWrapper><Placeholder name="Watchlist" /></PageWrapper>} />

                <Route path="*" element={<PageWrapper><Placeholder name="404" /></PageWrapper>} />
            </Routes>
        </BrowserRouter>
    )
}