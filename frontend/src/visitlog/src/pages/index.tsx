import * as React from "react";
import styled from "styled-components";
import BasicLayout from "./basic";
import {Input} from 'antd';

const Body = styled.div`
  witdh : 100vw;
  height : 100vh;
  display : flex;
  flex-direction : column;  
`;

const Menu = styled.div`
  display : flex;
  align-items : center;
  height : 45px;
  border-bottom : 1px solid #cccccc;
  padding-right : 4.5%;
  background : white;
  //#b9e059
`

const MenuBtn = styled.span`
  font-weight : bold;
  font-size: 1.3rem;
  cursor: pointer;
  margin-right : 50px;
  color : #4aa6c2;
  //#b9e059
`
const HomeBtn = styled(MenuBtn)`
  margin-left: auto;
`

const VisitLogIcon = styled(MenuBtn)`
  margin-left : 4.5%;
`;

const Content = styled.div`
  display: flex;
  justify-content : center;
  align-items : center;
  background : #4aa6c2;
  height : 350px;
`;

const InputBox = styled.div`
  width : 40%;
  min-width : 360px;
  height : 220px;
  border-radius : 20px;
  background : white;
`;

const HomePage = () => {
  return (
    <BasicLayout>
      <Body>

        <Menu>
          <VisitLogIcon>
            Visit Log
          </VisitLogIcon>
          <HomeBtn>
            Home
          </HomeBtn>
          <MenuBtn>
            Intro
          </MenuBtn>
        </Menu>
        
        <Content>
          <InputBox>
          
          </InputBox>
        </Content>

      </Body>;
    </BasicLayout>)
};


export default HomePage;
