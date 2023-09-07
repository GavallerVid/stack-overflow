import {createContext, useContext, useEffect, useState} from "react"

const UserContext = createContext()

export default function UserProvider(props){
    const [user, setUser] = useState(null);

    function handleLogin(user){
        setUser(user);
        localStorage.setItem("user",JSON.stringify(user))
    }
    useEffect(()=> {
        const user = localStorage.getItem("user")
        if(user){
            setUser(JSON.parse(user))
        }
    },[])
    return (
        <UserContext.Provider value={{user, handleLogin}}>
            {props.children}
        </UserContext.Provider>
    )
}
export const useUser = () => {
    return useContext(UserContext)
}