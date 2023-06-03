import React from 'react';
import { Button, Result } from 'antd';
import {Link} from "react-router-dom";

function backHome() {

}
const NotFound:React.FC = () => {
    return(
        <Result
            status="403"
            title="403"
            subTitle="Sorry, you are not authorized to access this page."
            extra={<Button type="primary" onClick={backHome}><Link to={{pathname: '/'}}>返回主页</Link></Button>}
        />
    )
}

export default NotFound;