import React, { useState } from 'react'
import Button from '../components/Button'
import Input from '../components/Input'
import { Formik, Form } from 'formik'
import * as Yup from "yup"
import { useNavigate } from 'react-router-dom'
import axios from 'axios'


const initialValues = {
    username: "",
    password: ""
}

const validationSchema = Yup.object({
    username: Yup.string().required("Required"),
    password: Yup.string().required("Required")
})

const LoginPage = () => {
    const [checkAuth, setCheckAuth] = useState(true);
    let navigate = useNavigate();
    const onSubmit = values => {
        const fetch = async () => {
            try {
                const { username, password } = values;
                const response = await axios.post("/login/auth",{username,password})
                const login = await axios.post("/login",values,{headers:{
                    "Authorization":response.data
                }})
                console.log(login);
            } catch (error) {
                setCheckAuth(!checkAuth)
            }
        }
        fetch()
    }


    return (
        <div className="content-wrapper">
            <div className="content-inner">
                <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={onSubmit} >
                    <Form>
                        <h3>Sign In</h3>
                        <Input label={"username"} type={"text"} id={"username"} name={"username"} />
                        <Input label={"password"} type={"password"} id={"password"} name={"password"} />
                        <Button type="submit" text="Login" />
                    </Form>
                </Formik>
                {!checkAuth &&
                    <div className="alert alert-danger al" role="alert">
                        Wrong Credentials
                    </div>}
            </div>
        </div>

    )
}

export default LoginPage
