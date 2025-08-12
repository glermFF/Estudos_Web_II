import { useState, useEffect } from "react"
import api from "../../services/api"

interface IEvent{ //! Alterar para os dados de evendos
    id: string,
    description: string,
    price: number,
    date: string
}

const ListEvents = () => {
    const [events, setUsers] = useState<IEvent[]>([])

    useEffect(() => {

        api('/events/list-events').then(response => {
            console.log(response)
            setUsers(response)
        }).catch(error => console.error(error))

    }, [])

    return(
        <div className="users-container">
            <h2>Eventos Registrados</h2>
        <div className="users-grid">
            {
                events.map(event => (
                    <article className="user-card" >
                        <div className="user-card-head">
                            <span className="user-badge">ID</span>
                            <code className="user-id">{event.id}</code>
                        </div>
                            <p className="user-name">{event.description}</p>
                            <p className="user-email">{event.date}</p>
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

export default ListEvents