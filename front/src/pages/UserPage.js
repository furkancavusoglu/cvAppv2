import React, { useEffect } from 'react'
import Button from '../components/Button'
import Input from '../components/Input'
import { Formik, Form } from 'formik'
import * as Yup from "yup"
import { useParams } from 'react-router-dom'
import axios from 'axios'
import { useState } from 'react'


const initialValues = {
    name: "",
    email: "",
    phoneNumber: "",
    school: "",
    experiences: "",
    skills: "",
}

const phoneRegExp = /^((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?$/
const validationSchema = Yup.object({
    name: Yup.string().required("Required"),
    email: Yup.string().email().required("Required"),
    phoneNumber: Yup.string().matches(phoneRegExp, "Invalid number").min(10, "too short").max(10, "too long"),
    school: Yup.string().required("Required"),
    experiences: Yup.string().required("Required"),
    skills: Yup.string().required("Required")
})

const UserPage = () => {
    const [userData, setUserData] = useState([])
    const [posted, setPosted] = useState(false)
    const name = useParams()
    console.log(userData);
    useEffect(() => {
        const getData = async () => {
            try {
                const response = await axios.get(`/user/${name.username}`)
                setUserData(response.data)
            } catch (error) {
                console.log(error)
            }
        }
        getData()
    }, [])
    const onSubmit = values => {
        const updateData = async () => {
            try {
                const response = await axios.put(`/user/${name.username}`, values)
                console.log(response);
                setPosted(true)
            } catch (error) {

            }
        }
        updateData()

    }

    return (
        <div className='content-wrapper'>
            <div className="content-inner">
                <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={onSubmit} >
                    <Form>
                        <h3>Your Cv</h3>
                        <Input label={"name"} type={"text"} id={"name"} name={"name"}
                            placeHolder={userData.name} />
                        <Input label={"email"} type={"email"} id={"email"} name={"email"}
                            placeHolder={userData.email} />
                        <Input label={"phoneNumber"} type={"text"} id={"phoneNumber"} name={"phoneNumber"}
                            placeHolder={userData.phoneNumber} />
                        <Input label={"school"} type={"text"} id={"school"} name={"school"}
                            placeHolder={userData.school} />
                        <Input label={"experiences"} type={"text"} id={"experiences"} name={"experiences"}
                            placeHolder={userData.experiences} />
                        <Input label={"skills"} type={"text"} id={"skills"} name={"skills"}
                            placeHolder={userData.skills} />
                        <Button type="submit" text="Update"></Button>
                    </Form>
                </Formik>
                {posted && <div className="alert alert-success" role="alert">
                    Your Cv information is saved!
                </div>}
            </div>
        </div>
    )
}

export default UserPage