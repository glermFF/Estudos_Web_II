import './App.css'
import Footer from './components/footer/Footer'
import Header from './components/header/Headeer'
import MainBlock from './components/MainBlock/MainBlock'
import MenuBlock from './components/MenuBlock/MenuBlock'
// import ListUsers from './components/users/ListUsers'

function App() {
  

  return (
    <>
     <div>
      <Header/>

      <MainBlock></MainBlock>
      <MenuBlock></MenuBlock>
      
      <Footer/>
     </div>
    </>
  )
}

export default App
