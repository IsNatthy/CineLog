import React, { useState } from 'react';
import { useAuth } from '../hooks/useAuth';
import { Link } from 'react-router-dom';

export const RegisterPage = () => {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [validationError, setValidationError] = useState<string | null>(null);
  
  const { register, isLoading, error, setError } = useAuth();

  const validatePassword = (pass: string) => {
    const minLength = pass.length >= 8;
    const hasUpper = /[A-Z]/.test(pass);
    const hasLower = /[a-z]/.test(pass);
    const hasDigit = /\d/.test(pass);
    return minLength && hasUpper && hasLower && hasDigit;
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setValidationError(null);
    setError(null); 

    if (password !== confirmPassword) {
      setValidationError('Las contraseñas no coinciden.');
      return;
    }

    if (!validatePassword(password)) {
      setValidationError('La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número.');
      return;
    }

    await register({ username, email, password });
  };

  return (
    <main className="flex-grow flex items-center justify-center relative bg-cinema px-margin py-xl overflow-hidden min-h-screen">
      <div className="w-full max-w-xl glass-panel rounded-xl p-lg shadow-xl shadow-background/50 relative z-10">
        
        <div className="flex flex-col items-center mb-xl">
          <span className="font-display-lg text-display-lg font-bold text-primary tracking-tighter mb-base">CineLog</span>
          <p className="font-label-caps text-label-caps text-on-surface-variant uppercase tracking-widest">Tu viaje cinematográfico</p>
        </div>

        <form className="space-y-md" onSubmit={handleSubmit}>
          
          {(error || validationError) && (
            <div className="bg-error-container text-on-error-container p-sm rounded-lg text-body-md text-center">
              {validationError || error}
            </div>
          )}

          <div className="grid grid-cols-1 sm:grid-cols-2 gap-md">
            <div className="space-y-xs">
              <label className="font-label-caps text-label-caps text-outline ml-xs" htmlFor="username">Nombre de Usuario</label>
              <div className="relative group">
                <span className="material-symbols-outlined absolute left-sm top-1/2 -translate-y-1/2 text-on-surface-variant group-focus-within:text-primary transition-colors">person</span>
                <input 
                  className="w-full bg-surface-container-low border border-outline-variant/30 rounded-lg py-md pl-xl pr-base text-on-surface placeholder:text-on-surface-variant/40 focus:outline-none focus:border-primary focus:ring-1 focus:ring-primary transition-all duration-300" 
                  id="username" 
                  name="username" 
                  placeholder="Ej. John Doe" 
                  required 
                  type="text"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                />
              </div>
            </div>

            <div className="space-y-xs">
              <label className="font-label-caps text-label-caps text-outline ml-xs" htmlFor="email">Correo Electrónico</label>
              <div className="relative group">
                <span className="material-symbols-outlined absolute left-sm top-1/2 -translate-y-1/2 text-on-surface-variant group-focus-within:text-primary transition-colors">mail</span>
                <input 
                  className="w-full bg-surface-container-low border border-outline-variant/30 rounded-lg py-md pl-xl pr-base text-on-surface placeholder:text-on-surface-variant/40 focus:outline-none focus:border-primary focus:ring-1 focus:ring-primary transition-all duration-300" 
                  id="email" 
                  name="email" 
                  placeholder="tu@email.com" 
                  required 
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
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
                  name="password" 
                  placeholder="••••••••" 
                  required 
                  type="password"
                  value={password}
                  onChange={(e) => {
                    setPassword(e.target.value);
                    if (validationError) setValidationError(null);
                  }}
                />
              </div>
            </div>

            <div className="space-y-xs">
              <label className="font-label-caps text-label-caps text-outline ml-xs" htmlFor="confirm_password">Confirmar Contraseña</label>
              <div className="relative group">
                <span className="material-symbols-outlined absolute left-sm top-1/2 -translate-y-1/2 text-on-surface-variant group-focus-within:text-primary transition-colors">password</span>
                <input 
                  className="w-full bg-surface-container-low border border-outline-variant/30 rounded-lg py-md pl-xl pr-base text-on-surface placeholder:text-on-surface-variant/40 focus:outline-none focus:border-primary focus:ring-1 focus:ring-primary transition-all duration-300" 
                  id="confirm_password" 
                  name="confirm_password" 
                  placeholder="••••••••" 
                  required 
                  type="password"
                  value={confirmPassword}
                  onChange={(e) => {
                    setConfirmPassword(e.target.value);
                    if (validationError) setValidationError(null);
                  }}
                />
              </div>
            </div>
          </div>

          <div className="flex items-center justify-center py-xs">
            <label className="flex items-center cursor-pointer group space-x-base">
              <input 
                className="w-4 h-4 rounded border-outline-variant bg-surface-container-low text-primary focus:ring-primary" 
                id="terms" 
                name="terms" 
                required 
                type="checkbox"
              />
              <span className="font-body-md text-label-caps text-on-surface-variant group-hover:text-on-surface transition-colors">
                Acepto los Términos y la Política de Privacidad.
              </span>
            </label>
          </div>

          <button 
            className="w-full bg-primary-container text-on-primary-container font-label-caps text-label-caps py-md rounded-lg shadow-lg shadow-primary-container/20 hover:scale-[1.02] active:scale-[0.98] transition-all duration-300 font-bold uppercase tracking-widest disabled:opacity-50 disabled:cursor-not-allowed" 
            type="submit"
            disabled={isLoading}
          >
            {isLoading ? 'Registrando...' : 'Registrarse'}
          </button>
        </form>

        <div className="mt-lg pt-lg border-t border-outline-variant/10 text-center">
          <p className="font-body-md text-body-md text-on-surface-variant">
            ¿Ya tienes una cuenta? 
            <Link className="text-primary font-bold hover:underline ml-xs" to="/login">Inicia sesión</Link>
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
