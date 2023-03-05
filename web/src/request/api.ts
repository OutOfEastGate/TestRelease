import request from "./index"

export const loginAPI = (params:LoginAPIReq):Promise<LoginAPIRes> => request.post("/user/login",params)

export const getCasdoorLoginUrlAPI = (params:CasdoorLoginUrlReq):Promise<StringRes> => request.get("/getLoginUrl?origin="+params.origin)

export const getCasdoorLoginAPI = (params:CasdoorLoginReq):Promise<CasdoorLoginRes> => request.get("/callback?"+"code="+params.code+"&state="+params.state)

export const getAllUsersAPI = ():Promise<GetAllUserRes> => request.get("/getAllUsers")

export const testAPI = () => request.get("/casdoor/test")