import React,{useState} from 'react'; 
import EditTask from '../modals/EditTask'

const Card = ({taskObj , index ,deleteTask,updateListArray}) => {
    const [modal,setModal] = useState(false);

    const colors = [
        {
            primaryColor: "#F38D93",
            secondaryColor: "#EF9CA1" 
        },
        {
            primaryColor: "#47B9FA",
            secondaryColor: "#9CD1EF"
        },
        {
            primaryColor:"#034F14",
            secondaryColor:"#119D30"
        },
        {
            primaryColor:"#621C98",
            secondaryColor:"#CA9CEF"
        },
        {
            primaryColor:"#46D1B8",
            secondaryColor:"#76E9D4"
        }
    ]

    const toggle = () =>{
        setModal(!modal)
    }

    const updateTask = (obj) => {
        updateListArray(obj, index)
    }

    const handleDelete = () =>{
        deleteTask(index)
    }

    return (

    <div class = "card-wrapper mr-4">
        <div class = "card-top" style={{"background-color": colors[index%4].primaryColor}}></div>
        <div class = "task-holder">
            <span class = "card-header" style={{"background-color": colors[index%4].secondaryColor,
            "border-radius": "10px"}}>{taskObj.Name}</span>
            <p className= "mt-2">{taskObj.Description}</p>

            <div style={{"position": "absolute", "right" : "20px", "bottom" : "20px"}}>
                <i class = "far fa-edit mr-3" style={{"color":colors[index%4].primaryColor, "cursor" : "pointer" }} onClick = {() => setModal(true)}> </i>
                <i class="fas fa-trash-alt" style = {{"color":colors[index%4].primaryColor, "cursor" : "pointer" }} onClick = {handleDelete} ></i>
            </div>
        </div>
        <EditTask modal = {modal} toggle = {toggle} updateTask = {updateTask} taskObj ={taskObj}/>
    </div>
    );
};

export default Card;