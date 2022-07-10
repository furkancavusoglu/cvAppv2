import axios from 'axios'
import React, { useState, useEffect } from 'react'
import UserDetails from '../components/UserDetails'

const AdminPage = () => {
    const [cvData, setCvData] = useState([])
    useEffect(() => {
        const fetch = async () => {
            const response = await axios.get("/admin")
            const users = response.data
            let data = [];
            users.map(user => (
                data.push(user.userCv)
            ))
            data = data.filter(datum => datum !== null)
            setCvData(data)
        }
        fetch()
    }, [])

    return (
        <div className='content-wrapper'>
            <div className="content-inner">
                <h2>USER CVs </h2>
                {cvData.map((cv, index) => {
                    return <UserDetails key={index} details={cv} />
                })}
            </div>
        </div>
    )
}

export default AdminPage

/*                    mock.map((user, index) => {
                        return (<UserDetails key={index} details={user} />)
                    }) */