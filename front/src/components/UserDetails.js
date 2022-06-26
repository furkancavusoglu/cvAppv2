import React, { useState } from 'react'

function UserDetails({ details }) {
    const [clicked, setClicked] = useState(false)

    function clickHandler() {
        setClicked(!clicked)
    }

    return (
        <article className='user' >
            {Object.keys(details).map(function (key,index) {
                if (clicked) {
                    return (key === "name" || key === "email" || key === "phoneNumber")
                        && <div key={index} className='info-row' onClick={clickHandler} >{key}= {details[key]}</div>;
                } else {
                    return <div key={index} className='info-row' onClick={clickHandler}>{key}= {details[key]}</div>;
                }
            })}
        </article>
    )
}

export default UserDetails