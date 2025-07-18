import { useState, useEffect } from "react"
import api from "../../services/api"

interface IUser{
    id: string,
    name: string,
    email: string
} 

const ListUsers = () => {

    const [users, setUsers] = useState<IUser[]>([])

    useEffect(() => {

        api('/api/users').then(response => {
            console.log(response)
            setUsers(response)
        }).catch(error => console.error(error))

    }, [])

  return (
    <div>
        <h2>Usuários Registrados</h2>

        <div>
            {
                users.map(user => (
                    <div>
                        <p>{user.id}</p>
                        <p>{user.name}</p>
                        <p>{user.email}</p>
                    </div>
                ))
            }
        </div>
    </div>
  )
}

export default ListUsers