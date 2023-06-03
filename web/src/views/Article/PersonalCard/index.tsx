import React from "react";
import './personalCard.css'
import {getUserByName} from "@/request/api";

interface PropsType{
    children:string
}
interface StateType{
    author:UserInfo | null
}
class PersonalCard extends React.Component<PropsType, StateType>{
    constructor(props:PropsType) {
        super(props);
        this.state={
            author:null
        }
    }

    render() {
        if (this.state.author === null) {
            getUserByName(this.props.children).then(res => {
                this.setState({
                    author: res.data
                })
            })
        }
        return(
            <div className="card">
                <div className="name">
                    作者信息
                </div>
                <div className="picture">
                    <img src={this.state.author?.avatar}/>
                </div>
                <div className="name">
                    <p>{this.state.author?.name}</p>
                </div>
                <div className="jobtitle">
                    <p>{this.state.author?.email}</p>
                </div>
                <div className="buttons">
                    <div className="button1">
                        <button>关于作者</button>
                    </div>
                    <div className="button2">
                        <button>捐赠</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default PersonalCard;