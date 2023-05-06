import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import {Button, Container, Paper} from "@mui/material";
import {useState} from "react";

export default function DeleteCubeById() {
    const paperStyle = {padding:'50px 20px',width:600,margin:'20px auto'}
    const[id,setId]=useState('')

    const handleDelete=(e)=> {
        e.preventDefault()
        fetch("http://localhost:80/cubes/"+String(id),{
            method:"DELETE"
        })
            .then(()=>this.setState({status:"Delete successful"}))
    }

    return (
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <Box
                    component="form"
                    sx={{
                        '& > :not(style)': { m: 2, width:'550px'},
                    }}
                    noValidate
                    autoComplete="off"
                >
                    <h2>Delete Cube by Id</h2>
                    <TextField id="outlined-basic" label="Id" variant="outlined" required
                               value={id}
                               onChange={(e)=>setId(e.target.value)}
                    /><br/>
                </Box>
                <Button variant="contained" color="secondary" onClick={handleDelete}>
                    Delete
                </Button>
            </Paper>
        </Container>
    );
}
