import React from 'react'
import "../index.css"
import { Field, ErrorMessage } from "formik"
import TextError from './TextError'

const Input = ({ label, type, id, name, placeHolder}) => {
    return (
        <div className="mb-3">
            <label htmlFor={label} >{label}</label>
            <Field
                type={type}
                id={id}
                name={name}
                className="form-control"
                placeholder={placeHolder && placeHolder}
             />
            <ErrorMessage name={name} component={TextError} />
        </div>
    )
}

export default Input