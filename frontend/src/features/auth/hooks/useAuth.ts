import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { authService } from '../services/authService';
import type { LoginRequest, RegisterRequest } from '../types';
import { setToken, removeToken } from '../../../lib/auth';

export const useAuth = () => {
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const navigate = useNavigate();

  const login = async (credentials: LoginRequest) => {
    setIsLoading(true);
    setError(null);
    try {
      const response = await authService.login(credentials);
      setToken(response.token);
      navigate('/diary');
    } catch (err: any) {
      setError('Correo electrónico o contraseña incorrectos.');
    } finally {
      setIsLoading(false);
    }
  };

  const register = async (data: RegisterRequest) => {
    setIsLoading(true);
    setError(null);
    try {
      const response = await authService.register(data);
      if (response.token) {
        setToken(response.token);
        navigate('/diary');
      } else {
        navigate('/login');
      }
    } catch (err: any) {
      setError('Hubo un problema al crear la cuenta. Verifica tus datos o intenta con otro correo.');
    } finally {
      setIsLoading(false);
    }
  };

  const logout = () => {
    removeToken();
    navigate('/login');
  };

  return { login, register, logout, isLoading, error, setError };
};
