import { createBrowserRouter } from "react-router-dom"

import Content from "../components/Content/Content"
import ListUsers from "../components/users/ListUsers"
import ListSales from "../components/sales/ListSales"
import ListEvents from "../components/eventos/ListEvents"

export const routes = createBrowserRouter([
    {
        path: "/",
        element: <Content/>,
        children:[
            {path: "/users", element: <ListUsers/>},
            {path: "/sales", element: <ListSales/>},
            {path: "/events", element: <ListEvents/>}
        ]
    }
])