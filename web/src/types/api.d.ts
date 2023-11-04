//这个文件专门定义请求和响应的类型
interface LoginAPIReq {
    username:string;
    password:string
}

interface LoginDataRes {
    userId:string;
    token:string
}
interface BaseRes {
    code:string;
    msg: string
}

interface LoginAPIRes extends BaseRes{
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

interface GetUserInfoReq {
    token:string | null;
}

interface CasdoorLoginRes {
    data:{
        token:string;
        casdoorUser:{
            name:string
        };
    }
}

interface StringRes {
    data:string
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
interface getAllFileTypeRes extends BaseRes{
    data:[
        FileTypeInfo
    ]
}
interface UserInfo {
    owner:string;
    name:string;
    type:string;
    displayName:string;
    avatar:string;
    email:string;
    tag:string;
    createTime:string;
    updateTime:string;
    avatar:string;
    createdIp:string;
    score:number;
}
interface UserInfoRes {
    data: UserInfo
}

interface AllArticles {
    data: Article[]
}

interface PageRes<T> extends BaseRes{
    data:Page<T>
}

interface Page<T> {
    currentPage: number;
    pageSize: number;
    total: number;
    data: T;
}

interface OneArticle extends BaseRes{
    data: Article
}

interface NumRes extends BaseRes{
    data: number
}

interface StrRes extends BaseRes{
    data:string
}

interface Article {
    id: string;
    title: string;
    image: string;
    author: string;
    authorAvatar: string;
    description: string;
    content: string;
}

interface ArticleInfo extends Article{

}

interface AddArticle {
    title: string;
    description: string;
    content: string;
    author: string;
    image: string;
}

interface Id {
    id:string
}

interface EditArticle{
    id: string;
    title: string;
    image: string;
    description: string;
    content: string;
}

interface AddArticleRes extends BaseRes{
    data: {
        id: string;
        title: string;
        description: string;
        content: string;
    }
}

interface Message{
    username:string | null;
    message:string;
    createTime:string;
}

interface AllMessagesRes extends BaseRes{
    data:Message[]
}

interface AllFilesRes extends BaseRes{
    data:FileInfo[]
}
interface FileInfo{
    id:string;
    url:string;
    size:string;
    filename:string;
    originalFilename:string;
    ext:string;
    platform:string;
    objectId:string;
    objectType:string;
    createTime:string;
    attr:object
}

interface FileTypeInfo{
    id:string;
    image:string;
    title:string;
    description:string
}

interface PageReq{
    pageSize:number;
    currentPage:number
}

interface Ip{
    id:string;
    ip:string;
    country:string;
    city:string;
    times:string;
    date:string;
}

interface Script{
    script:string
}

interface AllStoresRes extends BaseRes{
    data:{
        stores:Store[]
    }
}

interface AllModals extends BaseRes{
    data:{
        authorization_models:object
    }
}

interface Store{
    id:string
    name:string
    created_at:string
    updated_at:string
    deleted_at:string
}

interface systemInfoRes extends BaseRes{
    data:SystemInfo
}

interface SystemInfo{
    cpuNum:number;
    cpuThreadNum:number;
    systemRuntime:string;
    totalMemory:string;
    memoryUsage:number;
    jvmMemoryUsage:number;
}

interface GetHistoryTodayRes extends BaseRes{
    data:{
        result:GetHistoryToday[]
    }
}

interface GetHistoryToday{
    year:number
    title:string
    desc:string
    link:string
}
interface GetWeatherRes extends BaseRes{
    data: {
        result:Weather
    }
}
interface Weather{
    city:{
        counname:string
        name:string
        pname:string
    },
    condition:{
        condition:string
        tips:string
        sunRise:string
        sunSet:string
        windDir:string
        windLevel: number
    },
    forecast:Forecast[]
}
interface Forecast{
    conditionDay:string
    conditionNight:string
    predictDate:string
}

interface Website{
    id:string
    name:string
    link:string
    desc:string
    icon:string
    title:string
}

interface getAllWebsiteRes extends BaseRes{
    data:Website[]
}