import axios from 'axios'
import React, { useState, useEffect } from 'react'
import { useLocation } from 'react-router-dom'
import UserDetails from '../components/UserDetails'

const AdminPage = () => {
    const [cvData, setCvData] = useState([])
    const [authorized, setAuthorized] = useState(true)
    const location = useLocation()
    useEffect(() => {
        const fetch = async () => {
            if (location.state === null) {
                setAuthorized(false)
                return
            }
            const jwt = location.state.jwt
            const response = await axios.get("/admin", {
                headers: {
                    "Authorization": `Bearer ${jwt}`
                }
            })
            const users = response.data
            let data = [];
            users.map(user => (
                data.push(user.userCv)
            ))
            data = data.filter(datum => datum !== null)
            setCvData(data)
        }
        fetch()
    })

    return (
        <div className='content-wrapper'>
            <div className="content-inner">
                {!authorized ? <h1 style={{ color: "red" }} >UNAUTHORIZED!</h1> :
                    <>
                        <h2>USER CVs </h2>
                        {cvData.map((cv, index) => {
                            return <UserDetails key={index} details={cv} />
                        })}
                    </>}
            </div>
        </div>
    )
}

export default AdminPage
