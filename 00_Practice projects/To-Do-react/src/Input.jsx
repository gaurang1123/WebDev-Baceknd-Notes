import React, { use } from 'react'
import { useState } from 'react'

const Input = () => {

    const [data, setData] = useState("")
    const [inputData, setInputData] = useState([])
    const handler = (e) => {
        setData(e.target.value);
    }
    const dataHandler = () => {
        setInputData([...inputData, data]);
    }
    const dataRemove=(index)=>{
        setInputData(inputData.filter((_,i)=> i != index))
    }

    return (
        <>
            <div className='w-[80%] flex justify-center gap-5'>
                <input value={data} onChange={handler} type="text" placeholder="Task" className="input input-accent" />
                <button className="btn btn-outline btn-success" onClick={dataHandler} >Add</button>
            </div>
            <div>
                {inputData.map((item, index) => (
                    <div key={index}>
                    <h1 >{item}</h1>
                    <button className="btn btn-outline btn-error" onClick={()=>{dataRemove(index)}} >Add</button>
                    </div>
                ))}


            </div>
        </>
    )
}

export default Input