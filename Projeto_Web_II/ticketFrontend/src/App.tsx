import './App.css'

import { RouterProvider } from 'react-router-dom';
import { routes } from './Routes/routes.tsx'

import Footer from './components/footer/Footer'
import Header from './components/header/Headeer'

function App() {
  

  return (
    <>
     <div>
      <Header/>

      <RouterProvider router={routes}/>
      
      <Footer/>
     </div>
    </>
  )
}

export default App
