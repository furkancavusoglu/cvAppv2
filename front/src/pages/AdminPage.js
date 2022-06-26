import React, { useState, useEffect } from 'react'
import UserDetails from '../components/UserDetails'

const AdminPage = () => {
    const [mock, setMock] = useState([])

    useEffect(() => {
        setMock([{
            name: "Furkan C",
            email: "cfurkan@gmail.com",
            skills: "java",
            phoneNumber: "5312227847",
            school: "ESTU",
            experiences: "yok",
        }, {
            name: "Tolga",
            email: "tolga@mail.com",
            skills: "java",
            phoneNumber: "5312227847",
            school: "ESTU",
            experiences: "yok",
        }])
    }, [])

    return (
        <div className='content-wrapper'>
            <div className="content-inner">
                <h2>USER CVs </h2>
                {
                    mock.map((user, index) => {
                        return (<UserDetails key={index} details={user} />)
                    })
                }
            </div>
        </div>
    )
}

export default AdminPage