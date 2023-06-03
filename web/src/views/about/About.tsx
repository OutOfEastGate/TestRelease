import {PageContainer, ProCard} from "@ant-design/pro-components";
import InfoTable from './Table'
import React, {useState} from "react";

interface childProps {
    children: {
        name:string
        displayName:string
    };
}
const About: React.FC = (props) => {
    const [select, setSelect] = useState(1)
    return (
        <div
            style={{
                background: '#F5F7FA',
            }}
        >
            <PageContainer
                fixedHeader

                tabList={[
                    {
                        tab: '基本信息',
                        key: '1',
                        children: <InfoTable>{'基本信息'}</InfoTable>,
                    },
                    {
                        tab: '详细信息',
                        key: '2',
                        children: <InfoTable>{'详细信息'}</InfoTable>
                    },
                    {
                        tab: '待开发',
                        key: '3',
                        disabled: true,
                    },
                ]}
            >

            </PageContainer>
        </div>
    )
}


export default About