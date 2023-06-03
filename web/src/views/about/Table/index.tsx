import { ProCard } from '@ant-design/pro-components';
import React, { useState } from 'react';
import UserInfo from '../UserInfo'
interface childProps {
    children:string
}

function baseInfo() {
    return (
        <>
          <p>基本信息展示</p>
        </>
    )
}

function detailInfo() {
    return (
        <div>
            <p>详细信息展示</p>
        </div>
    )
}

const InfoTable: React.FC<childProps> = (props) => {
    const select = props.children
    if (select === "基本信息") {
        return (
            <UserInfo></UserInfo>
        )
    } else if (select === "详细信息") {
        return (
            <ProCard direction="column" ghost gutter={[0, 16]}>
                <ProCard gutter={16} ghost>
                    <ProCard colSpan={16} style={{ height: 200 }}>
                        {detailInfo()}
                    </ProCard>
                    <ProCard colSpan={8} style={{ height: 200 }} />
                </ProCard>
                <ProCard gutter={16} ghost>
                    <ProCard colSpan={8} style={{ height: 200 }} />
                    <ProCard colSpan={16} style={{ height: 200 }} />
                </ProCard>
            </ProCard>
        )
    }

    return null

    ;
};

export default InfoTable;