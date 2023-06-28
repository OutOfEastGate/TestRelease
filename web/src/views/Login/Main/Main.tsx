import React, { ChangeEvent, useState, useMemo} from 'react';
import { LockOutlined, UserOutlined } from '@ant-design/icons';
import { Checkbox, Form, Input, notification } from 'antd';
import type { NotificationPlacement } from 'antd/es/notification/interface';
import { getCasdoorLoginUrlAPI, visitorLogin} from '@/request/api';
import {showMessage} from "@/components/Setting";
const Context = React.createContext({ name: 'Default' });

const LoginMain: React.FC = () => {
  const [api, contextHolder] = notification.useNotification();
  const openNotification = (placement: NotificationPlacement) => {
    api.info({
      message: `登录失败`,
      description: <Context.Consumer>{({ name }) => `账号或密码错误`}</Context.Consumer>,
      placement,
    });
  };

  const openYesification = (placement: NotificationPlacement) => {
    api.info({
      message: `登录成功`,
      placement,
    });
  };

  const onFinish = (values: any) => {
    console.log('Received values of form: ', values);
  };

  //获取用户输入的用户名
  const [usernameVal,setUsernameVal] = useState("")
  const usernameChange = (e:ChangeEvent<HTMLInputElement>) => {
    // console.log(e.target.value);
    setUsernameVal(e.target.value)//修改usernameVal变量
  }

  //获取用户输入的密码
  const [passwordVal,setPasswordVal] = useState("")
  const passwordChange = (e:ChangeEvent<HTMLInputElement>) => {
    // console.log(e.target.value);
    setPasswordVal(e.target.value)//修改usernameVal变量
  }

  //点击登录
  const gotoLogin = () => {
    visitorLogin().then(res => {
      if (res.msg === "success") {
        localStorage.setItem("token",res.data.token)
        localStorage.setItem("userId",res.data.userId)
        showMessage("success", "游客登录成功")
        window.location.href = "/"
      } else {
        showMessage("error", res.msg)
      }
    })
  }

  const casdoorLogin = () => {
    getCasdoorLoginUrlAPI({origin:window.location.origin}).then((res)=>{
      window.location.href = res.data
    })
  }


  return (
    <div>
      <p>Casdoor 与 SpringBoot 3.0 开发， 集成Jenkins自动部署</p>
      <br/>
      <Form
          name="normal_login"
          className="login-form"
          initialValues={{ remember: true }}
          onFinish={onFinish}
      >
        <Form.Item
            name="username"
            rules={[{ required: true, message: '请输入用户名!' }]}
        >
          <Input
              prefix={<UserOutlined className="site-form-item-icon" />}
              placeholder="用户名"
              onChange={usernameChange} />
        </Form.Item>
        <Form.Item
            name="password"
            rules={[{ required: true, message: '请输入密码!' }]}
        >
          <Input
              prefix={<LockOutlined className="site-form-item-icon" />}
              type="password"
              placeholder="密码"
              onChange={passwordChange}
          />
        </Form.Item>
        <Form.Item>
          <Form.Item name="remember" valuePropName="checked" noStyle>
            <Checkbox>记住我</Checkbox>
          </Form.Item>

          <a className="login-form-forgot" href="">
            忘记密码
          </a>
        </Form.Item>

        <Form.Item>
          <button className="btn" onClick={gotoLogin}> 游客登录
          </button>  或者 <button className="btn" onClick={casdoorLogin}> 使用Casdoor认证登录
          </button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default LoginMain;