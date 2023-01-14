package com.cbu.backend.authaccount.command.domain;

public enum Major {
    COMPUTER("컴퓨터공학전공"),
    SOFTWARE("소프트웨어전공"),
    GAME("게임공학과"),
    AI("인공지능학과"),
    MECHANICAL("기계공학과"),
    MECHANICAL_DESIGN("기계설계공학전공"),
    INTELLIGENT_MOBILITY("지능형모빌리티전공"),
    MECHATRONICS("메카트로닉스공학전공"),
    AI_ROBOTICS("AI로봇전공"),
    ELECTRONIC("전자공학전공"),
    EMBEDDED_SYSTEM("임베디드시스템전공"),
    MATERIALS_SCIENCE("신소재공학과"),
    BIOCHEMICAL("생명화학공학과"),
    NANO_SEMICONDUCTOR("나노반도체공학과"),
    ENERGY_ELECTRICAL("에너지전기공학과"),
    BUSINESS_ADMINISTRATION("경영학전공"),
    DATA_SCIENCE_MANAGEMENT("데이터사이언스경영전공"),
    IT_MANAGEMENT("IT경영전공"),
    INDUSTRIAL_DESIGN("산업디자인공학전공"),
    MEDIA_DESIGN("미디어디자인공학전공"),
    CONV_VENTURE_STARTUP("융합_벤처창업"),
    CONV_SEMICONDUCTOR_MATERIAL("융합_반도체소재"),
    CONV_SMART_FACTORY("융합_스마트팩토리"),
    CONV_SEMICONDUCTOR_DISPLAY("융합_반도체디스플레이"),
    CONV_FUTURE_AUTOMOTIVE("융합_미래자동차공학"),
    CONV_DIGITAL("융합_디지털엔지니어링"),
    CONV_AI_CONVERGENCE("융합_인공지능융합"),
    CONV_INTELLIGENT_ROBOT("융합_지능형로봇"),
    CONV_METAVERSE_DESIGN("융합_메타버스디자인"),
    CONV_RENEWABLE_ENERGY_CONVERGENCE("융합_신재생에너지융합기술"),
    CONV_ECOMMERCE("융합_이커머스"),
    CORP_TALENT_MECHANICAL_GYMNASTICS("기업인재_기계체조공학"),
    CORP_MECHANICAL_DESIGN_SYSTEM("기업인재_기계설계시스템공학"),
    CORP_COMPUTER_CONVERGENCE("기업인재_컴퓨터융합공학"),
    CORP_ENVIRONMENTAL_SAFETY_MANAGEMENT("기업인재_환경안전경영"),
    CORP_CORPORATE_MANAGEMENT("기업인재_기업경영"),
    CORP_MECHATRONICS_SYSTEM("기업인재_메카트로닉스시스템"),
    CORP_SMART_COMPUTER_CONVERGENCE("기업인재_스마트컴퓨터융합공학"),
    CORP_COMPUTER_ELECTRONICS("기업인재_컴퓨터전자공학"),
    CORP_SMART_MECHANICAL("기업인재_스마트기계공학");

    private final String korean;

    Major(String korean) {
        this.korean = korean;
    }
}
