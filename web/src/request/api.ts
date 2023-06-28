import request from "./index"

export const loginAPI = (params:LoginAPIReq):Promise<LoginAPIRes> => request.post("/login",params)

export const visitorLogin = ():Promise<LoginAPIRes> => request.get("/visitor")
export const getCasdoorLoginUrlAPI = (params:CasdoorLoginUrlReq):Promise<StringRes> => request.get("/getLoginUrl?origin="+params.origin)

export const getCasdoorLoginAPI = (params:CasdoorLoginReq):Promise<CasdoorLoginRes> => request.get("/callback?"+"code="+params.code+"&state="+params.state)

export const getAllUsersAPI = ():Promise<GetAllUserRes> => request.get("/getAllUsers")

export const deleteUser = (params:any):Promise<BaseRes> => request.post("/deleteUser",params)

export const getUserDetails = (params: GetUserInfoReq):Promise<UserInfoRes> => request.get("/getUserInfo?"+"token="+params.token)

export const getUserByName = (id:string):Promise<UserInfoRes> => request.get("/getUserByName?username=" + id)

export const getAllArticles = ():Promise<AllArticles> => request.get("/getAllArticle")

export const getArticlesByPage = (page:PageReq):Promise<PageRes<Article[]>> => request.get("/getArticlesByPage?currentPage="+page.currentPage+"&pageSize="+page.pageSize)

export const getArticleById = (id:string):Promise<OneArticle> => request.get("/getArticleById?id=" + id)

export const saveArticle = (params:AddArticle):Promise<AddArticleRes> => request.post("/addArticle",params)

export const editArticle = (params:EditArticle):Promise<BaseRes> => request.post("/editArticle",params)

export const deleteArticle = (params:Id):Promise<BaseRes> => request.post("/deleteArticleById",params)

export const addComment = (params:Message):Promise<BaseRes> => request.post("/addMessage",params)

export const getAllComment = ():Promise<AllMessagesRes> => request.get("getAllMessages")

export const testAPI = () => request.get("/casdoor/test")

export const getAllFiles = ():Promise<AllFilesRes> => request.get("/getAllFiles")

export const getFilesByTypeId = (typeId:string):Promise<AllFilesRes> => request.get("/getFilesByTypeId?typeId=" + typeId)

export const deleteFile = (url:string):Promise<BaseRes> => request.post("/deleteFileByUrl?url=" + url)

export const addFileType = (fileType:FileTypeInfo):Promise<BaseRes> => request.post("/addFileType",fileType)

export const editFileType = (fileType:FileTypeInfo):Promise<BaseRes> => request.post("/editFileType", fileType)

export const editFileInfo = (file:FileInfo):Promise<BaseRes> => request.post("/editFileInfo",file)

export const deleteFileType = (id:string):Promise<BaseRes> => request.post("/deleteFileType?id=" + id)

export  const getAllFileType = ():Promise<getAllFileTypeRes> => request.get("/getAllFileType")

export const downloadFile = (url:string) => request.get("/downloadFile?url=" + url);

export const searchArticle = (text:string):Promise<AllFilesRes> => request.get("/search/article?text=" + text)

export const getAllIpInfo = (page:PageReq):Promise<PageRes<Ip[]>> => request.get("/getAllIp?currentPage="+page.currentPage+"&pageSize="+page.pageSize)

export const addAnnouncement = (message:string):Promise<BaseRes> => request.post("/sse/send?message=" + message)

export const getOnlineUserNum = ():Promise<NumRes> => request.get("/getOnlineUserNum")

export const getScript =():Promise<StrRes> => request.get("/getScript")

export const updatePolicy = (script:Script):Promise<StrRes> => request.post("/updatePolicy", script)

export const getAllStores = ():Promise<AllStoresRes> => request.get("/permission/getAllStores")
export const getSystemInfo = ():Promise<systemInfoRes> => request.get("/systemInfo")