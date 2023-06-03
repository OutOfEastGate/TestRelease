import { getCasdoorLoginAPI } from '@/request/api';

const CallBack: React.FC = () => {
    const urlSearchParams = new URLSearchParams(window.location.search)
    const params = {
        code: urlSearchParams.get('code'),
        state: urlSearchParams.get('state')
    }
    getCasdoorLoginAPI({code:params.code,state:params.state}).then((res)=>{
        if(res.data.token) {
            localStorage.setItem("token",res.data.token)
            localStorage.setItem("username",res.data.casdoorUser.name)
            window.location.href = "/"
        }
    })
    return (
        <div></div>
    )
}

export default CallBack;