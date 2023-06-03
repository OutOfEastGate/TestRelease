import AllFileTable from "@/components/Common/File/AllFileTable";
import React from "react";

class File extends React.Component<any, any>{
    constructor(props:any) {
        super(props);
        this.state = ({
            sorts:['default']
        })
    }

    render() {
        return(
            <div>
                <AllFileTable></AllFileTable>
            </div>
        )
    }
}

export default File;