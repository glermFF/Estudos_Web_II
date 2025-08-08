import "../../styles/MenuBlock.css"

const MenuBlock = () => {
    return(
        <div className="menu-container">
            <ul className="menu-content">
                <li><a href="#">Perfil</a></li>
                <li><a href="#">Configurações</a></li>
                <li><a href="#">Notificações</a></li>
                <li><a href="#">Status do Banco de dados</a></li>
            </ul>
        </div>
    )
}

export default MenuBlock