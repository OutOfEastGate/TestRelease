const defaultState = {
    num:20
}

let reducer = (state = defaultState,action:{type:string}) => {
    console.log("执行redux")
    let newState = JSON.parse(JSON.stringify(state))
    switch(action.type){
        case "addNum":
            newState.num++
            break;
        case "add2":
            break;
    }
    return newState
}

export default reducer