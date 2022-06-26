import React from 'react'
import "../index.css"
import { Link } from 'react-router-dom'

const Navbar = () => {
    return (
        <div className="container">
            <nav className="navbar navbar-expand-lg navbar-light bg-light nav2">
                <Link className="navbar-brand" to={'/login'}>Logout </Link>
            </nav>
        </div>
    )
}

export default Navbar