import React from 'react'

const Button = ({type,text}) => {
    return (
        <div className="d-grid buttonn">
            <button type={type} className="btn btn-primary">
                {text}
            </button>
        </div>
    )
}

export default Button