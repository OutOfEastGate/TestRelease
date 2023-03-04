import { useSelector, useDispatch } from "react-redux"
import { Button } from "antd"

const Page = () => {
    //获取仓库数据
    const {num} = useSelector((state)=>({
        num:state.num
    }))

    const dispatch = useDispatch()
    const changeNum = () =>{
        dispatch({type:"addNum"})
    }
    return(
        <div className="about">
            <p>这是page页面</p>
            <p>{num}</p>
            <Button onClick={changeNum}>按钮</Button>
        </div>
    )
}

export default Page

