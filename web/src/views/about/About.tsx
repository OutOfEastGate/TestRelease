import { Button } from 'antd';
import { testAPI } from '@/request/api';

const gotoTest = () => {
    testAPI().then((res)=>{
        console.log(res)
    })
}

const About = () => {
    return(
        <div className="about">
            <Button onClick={gotoTest}>发送请求</Button>
            <p>这是about页面</p>
        </div>
    )
}

export default About