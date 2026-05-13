import React, { useState } from 'react';
import { useAuth } from '../hooks/useAuth';
import { Link } from 'react-router-dom';

export const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const { login, isLoading, error } = useAuth();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    await login({ email, password });
  };

  return (
    <main className="flex-grow flex items-center justify-center relative bg-cinema px-margin py-xl overflow-hidden min-h-screen">
      <div className="w-full max-w-md glass-panel rounded-xl p-lg shadow-xl shadow-background/50 relative z-10">
        <div className="flex flex-col items-center mb-xl">
          <span className="font-display-lg text-display-lg font-bold text-primary tracking-tighter mb-base">CineLog</span>
          <p className="font-label-caps text-label-caps text-on-surface-variant uppercase tracking-widest">Tu viaje cinematográfico</p>
        </div>
        
        <form className="space-y-md" onSubmit={handleSubmit}>
          {error && (
            <div className="bg-error-container text-on-error-container p-sm rounded-lg text-body-md text-center">
              {error}
            </div>
          )}
          
          <div className="space-y-xs">
            <label className="font-label-caps text-label-caps text-outline ml-xs" htmlFor="email">Correo Electrónico</label>
            <div className="relative group">
              <span className="material-symbols-outlined absolute left-sm top-1/2 -translate-y-1/2 text-on-surface-variant group-focus-within:text-primary transition-colors">mail</span>
              <input 
                className="w-full bg-surface-container-low border border-outline-variant/30 rounded-lg py-md pl-xl pr-base text-on-surface placeholder:text-on-surface-variant/40 focus:outline-none focus:border-primary focus:ring-1 focus:ring-primary transition-all duration-300" 
                id="email" 
                placeholder="cinefilo@ejemplo.com" 
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>
          </div>
          
          <div className="space-y-xs">
            <label className="font-label-caps text-label-caps text-outline ml-xs" htmlFor="password">Contraseña</label>
            <div className="relative group">
              <span className="material-symbols-outlined absolute left-sm top-1/2 -translate-y-1/2 text-on-surface-variant group-focus-within:text-primary transition-colors">lock</span>
              <input 
                className="w-full bg-surface-container-low border border-outline-variant/30 rounded-lg py-md pl-xl pr-base text-on-surface placeholder:text-on-surface-variant/40 focus:outline-none focus:border-primary focus:ring-1 focus:ring-primary transition-all duration-300" 
                id="password" 
                placeholder="••••••••" 
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>
          </div>
          
          <div className="flex items-center justify-between py-xs">
            <label className="flex items-center cursor-pointer">
              <input className="w-4 h-4 rounded border-outline-variant bg-surface-container-low text-primary focus:ring-primary" type="checkbox"/>
              <span className="ml-base font-body-md text-label-caps text-on-surface-variant">Recordarme</span>
            </label>
            <a className="font-label-caps text-label-caps text-primary hover:underline transition-all" href="#">¿Olvidaste tu contraseña?</a>
          </div>
          
          <button 
            className="w-full bg-primary-container text-on-primary-container font-label-caps text-label-caps py-md rounded-lg shadow-lg shadow-primary-container/20 hover:scale-[1.02] active:scale-[0.98] transition-all duration-300 font-bold uppercase tracking-widest disabled:opacity-50 disabled:cursor-not-allowed" 
            type="submit"
            disabled={isLoading}
          >
            {isLoading ? 'Entrando...' : 'Entrar'}
          </button>
        </form>
        
        <div className="mt-lg pt-lg border-t border-outline-variant/10 text-center">
          <p className="font-body-md text-body-md text-on-surface-variant">
            ¿No tienes una cuenta? 
            <Link className="text-primary font-bold hover:underline ml-xs" to="/register">Regístrate</Link>
          </p>
        </div>
      </div>
      
      <div className="absolute bottom-base left-1/2 -translate-x-1/2 flex items-center space-x-md text-on-surface-variant/30 select-none">
        <span className="material-symbols-outlined">movie</span>
        <span className="material-symbols-outlined">theater_comedy</span>
        <span className="material-symbols-outlined">camera_roll</span>
      </div>
    </main>
  );
};
