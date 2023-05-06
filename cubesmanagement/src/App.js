import logo from './logo.svg';
import './App.css';
import AddCube from "./components/AddCube";
import GetCubesAlphWithPriceBigger200 from "./components/GetCubesAlphWithPriceBigger200";
import GetAllCubes from "./components/GetAllCubes";
import GetCubeById from "./components/GetCubeById";
import DeleteCubeById from "./components/DeleteCubeById";
import UpdateCube from "./components/UpdateCube";

function App() {
  return (
    <div className="App">
        <ul>
            <li><AddCube/>
                <GetAllCubes/>
                <UpdateCube/></li>
            <li>
                <GetCubesAlphWithPriceBigger200/>
                <GetCubeById/>
                <DeleteCubeById/>
                </li>
        </ul>
    </div>
  );
}

export default App;
