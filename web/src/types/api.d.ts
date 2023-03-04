//这个文件专门定义请求和响应的类型

interface LoginAPIReq {
    userName:string;
    userPassword:string
}

interface LoginDataRes {
    userId:string;
    token:string
}

interface LoginAPIRes {
    success:boolean;
    data:LoginDataRes
}

interface CasdoorLoginUrlReq {
    origin:string
}

interface CasdoorLoginUrlRes {
    status:string;
    url:string
}

interface CasdoorLoginReq {
    code:string | null;
    state:string |null
}

interface CasdoorLoginRes {
    data:{
        token:string
    }
}

interface GetAllUserRes {
    data:[
        {
            owner:string;
            name:string;
            displayName:string;
            avatar:string;
            email:string;
            tag:string;
        }
    ]
}