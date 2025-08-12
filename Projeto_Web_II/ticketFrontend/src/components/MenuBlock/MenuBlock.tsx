import "../../styles/MenuBlock.css"
import { Link } from "react-router-dom"

const MenuBlock = () => {
    return(
        <div className="menu-container">
            <div className="menu-profile-container">

            </div>
            <ul className="menu-content">
                <li><a href="#">Perfil</a></li>
                <li><Link to="/users">Usuários</Link></li>
                <li><Link to="/sales">Vendas</Link></li>
                <li><Link to="/events">Eventos</Link></li>
                <li><a href="#">Configurações</a></li>
                <li><a href="#">Notificações</a></li>
            </ul>
        </div>
    )
}

export default MenuBlock