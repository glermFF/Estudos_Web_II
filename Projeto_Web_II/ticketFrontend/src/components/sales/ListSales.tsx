import { useState, useEffect } from "react"
import api from "../../services/api"


interface ISale{
    id: string,
    userId: string,
    eventId: string,
    purchaseStatus: string 
}

const ListSales = () => {
    const [sales, setUsers] = useState<ISale[]>([])

    useEffect(() => {

        api('/sales/list-sales').then(response => {
            console.log(response)
            setUsers(response)
        }).catch(error => console.error(error))

    }, [])

 return(
    <div className="users-container">
            <h2>Vendas Registradas</h2>
        <div className="users-grid">
            {
                sales.map(sale => (
                    <article className="user-card" >
                        <div className="user-card-head">
                            <span className="user-badge">ID</span>
                            <code className="user-id">{sale.id}</code>
                        </div>
                            <p>Status: {sale.purchaseStatus}</p>
                            
                            <p className="user-email">
                                <span className="user-badge">Event</span> 
                                {sale.eventId}
                            </p>
                            <p className="user-email">
                                <span className="user-badge">User</span>
                                {sale.userId}
                            </p>
                        <div className="user-actions">
                            {/* <button type="button" className="user-btn outline">Detalhes</button> */}
                            <button type="button" className="user-btn danger">Remover</button>
                        </div>
                    </article>
                ))
            }
        </div>
    </div>
    )
}

export default ListSales