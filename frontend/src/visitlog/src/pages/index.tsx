import * as React from "react";
import styled from "styled-components";
import BasicLayout from "./basic";
import { Button, Input } from "antd";

const Body = styled.div`
  @font-face {
    font-family: "NEXON Lv2 Gothic Bold";
    src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv2 Gothic Bold.woff")
      format("woff");
    font-weight: normal;
    font-style: normal;
  }
  witdh: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
`;

const Menu = styled.div`
  display: flex;
  align-items: center;
  height: 45px;
  border-bottom: 1px solid #cccccc;
  padding-right: 4.5%;
  //#b9e059
`;

const MenuBtn = styled.span`
  font-weight: bold;
  font-size: 1.3rem;
  cursor: pointer;
  margin-right: 50px;
  color: #4aa6c2;
  //#b9e059
`;
const HomeBtn = styled(MenuBtn)`
  margin-left: auto;
`;

const VisitLogIcon = styled(MenuBtn)`
  margin-left: 4.5%;
`;

const Content = styled.div`
  display: flex;
  height : 600px;
  justify-content: center;
  align-items: center;
  background: #4aa6c2;
`;

const InputBox = styled.div`
  width: 60%;
  min-width: 500px;
  max-width: 900px;
  height: 300px;
  border-radius: 20px;
  background: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 60px;
`;

const RowDiv = styled.div`
  display: flex;
  width: 80%;
  max-width: 600px;
`;

const CustomInput = styled(Input)`
  border-radius: 6px;
`;

const CustomButton = styled(Button)`
  margin-left: 3px;
  background: #b9e059;
  color: white;
  border: 1px solid #b9e059;
  border-radius: 4px;

  &:hover {
    background: #b9e059;
    color: white;
    border: 1px solid #b9e059;
  }
  &:after {
    background: #b9e059;
    color: white;
  }
`;

const Logo = styled.span`
  font-family: NEXON Lv2 Gothic Bold;
  font-size: 3rem;
  color: #333333;
  margin-bottom: 30px;
`;

const Footer = styled.div`
  height : 15%;
  background: #25292E;
`;

const HomePage = () => {
  return (
    <BasicLayout>
      <Body>
        <Menu>
          <VisitLogIcon>Visit Log</VisitLogIcon>
          <HomeBtn>Home</HomeBtn>
          <MenuBtn>Intro</MenuBtn>
        </Menu>

        <Content>
          <InputBox>
            <Logo>VisitLog</Logo>
            <RowDiv>
              <CustomInput placeholder="Url을 입력해주세요. ex) https://velog.io/@ehdrms2034" />
              <CustomButton>생성</CustomButton>
            </RowDiv>
          </InputBox>
        </Content>
{/* 
        <Footer>

        </Footer> */}
      </Body>
    </BasicLayout>
  );
};

export default HomePage;
