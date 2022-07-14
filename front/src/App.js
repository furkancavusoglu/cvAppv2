import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import "./index.css"
import LoginPage from './pages/LoginPage';
import UserPage from './pages/UserPage';
import AdminPage from './pages/AdminPage';
import Navbar from './components/Navbar';
import { Routes, Route } from "react-router-dom"
import NotFoundPage from './pages/NotFoundPage';

function App() {

  return (
    <div className='App'>
      <Navbar />
      <Routes>
        <Route index element={<LoginPage />} />
        <Route path='/login' element={<LoginPage/>} />
        <Route path='/user/:username' element={<UserPage />} />
        <Route path='/admin' element={<AdminPage />} />
        <Route path='*' element={<NotFoundPage />} />
      </Routes>
    </div>

  );
}

export default App;
