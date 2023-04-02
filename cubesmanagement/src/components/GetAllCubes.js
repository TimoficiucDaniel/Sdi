import * as React from 'react';
import Box from '@mui/material/Box';
import { Container, Paper} from "@mui/material";
import {useEffect, useState} from "react";

export default function GetAllCubes() {
    const paperStyle = {padding:'50px 20px',width:600,margin:'20px auto'}
    const[cubes,setCubes]=useState([])
    let i = 0


    useEffect(()=>{
        fetch("http://localhost:80/cubes")
            .then(res=>res.json())
            .then((result)=>{
                setCubes(result);
            })
    },[])

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
                    <h2>All cubes Ids</h2>
                    {cubes.map(cube=>(
                        <Paper elevation={6}
                               style={{margin:"1px",padding:"1px",textAlign:"left"}} key={cube.id}>
                            <ul>
                                <li style={{display:"inline-block", listStyle:"none"}}>
                                Id:{cubes[i++]}
                                </li>
                            </ul>
                        </Paper>
                    ))}
                </Box>
            </Paper>
        </Container>
    );
}
