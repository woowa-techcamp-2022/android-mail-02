package org.woowatechcamp.mailapplication.data.datasource

import org.woowatechcamp.mailapplication.data.model.MailData
import org.woowatechcamp.mailapplication.data.model.PRIMARY
import org.woowatechcamp.mailapplication.data.model.PROMOTION
import org.woowatechcamp.mailapplication.data.model.SOCIAL
import javax.inject.Inject

class MailDatasourceImpl @Inject constructor() : MailDatasource {
    override fun getMailData() = listOf(
        MailData(
            "Google",
            "보안 알림",
            "우테캠은 정말 최고다 우테캠은 정말 최고다 우테캠은 정말 최고다 우테캠은 정말 최고다 우테캠은 정말 최고다",
            PRIMARY
        ),
        MailData(
            "Ivy",
            "수업 자료가 올라왔어요!",
            "모두 루카스를 확인해주세요!",
            SOCIAL
        ),
        MailData(
            "엽기떡볶이",
            "1+1쿠폰이벤트",
            "엽떡앱 회원이면 누구나 받을 수 있는 혜택!! 지금 바로 엽떡앱 다운받고!! 방문포장 주문하러 가즈아~!!",
            PROMOTION
        ),
        MailData(
            "우아한테크캠프",
            "와이파이 관련 안내",
            "우테캠 와이파이 연결법에 대해 알려드립니다. 우산 woowain에 접속합니다. 그리고 방문자접속으로 등록합니다 블라블라블라블라블라블라",
            PRIMARY
        ),
        MailData(
            "Teddy",
            "Hi I'm Teddy",
            "Nice To Meet You..!!!!!",
            SOCIAL
        ),
        MailData(
            "싸다싸",
            "할인이벤트!",
            "할인합니다 어쨌든 할인합니다!!!!!",
            PROMOTION
        ),
        MailData(
            "로스트112",
            "분실물 습득 안내",
            "문다빈님의 분실물을 습득했습니다. 얼른 경찰서로 오세요.",
            PRIMARY
        ),
        MailData(
            "문다빈",
            "안녕 반가워",
            "우테캠은 정말 최고다우테캠은 정말 최고다우테캠은 정말 최고다우테캠은 정말 최고다우테캠은 정말 최고다우테캠은 정말 최고다",
            SOCIAL
        ),
        MailData(
            "Google",
            "사라 안드로이드",
            "사고 먹어라 안드로이드.. 안드로이드가 최고더라..",
            PROMOTION
        ),
        MailData(
            "SM Entertainment",
            "축하드립니다!",
            "당신은 SM 엔터테이먼트의 새로운 연습생이 되었습니다. 앞으로 에스엠에서 활동해주세요!",
            PRIMARY
        ),
        MailData(
            "FOX",
            "레드벨벳 케이크는 너무 맛있어!",
            "주세요 달콤한 그 맛 아이스크림 케이크~~",
            SOCIAL
        ),
        MailData(
            "LoveLikeThis",
            "럽 내게와",
            "럽 라잌 디스 쏘 러브, 기다린 너란걸 To Love...",
            PROMOTION
        ),
        MailData(
            "Slack",
            "보안 알림",
            "누군가 mdb1217 계정으로 접속했습니다. 보안 설정을 확인해주세요.",
            PRIMARY
        ),
        MailData(
            "Cat",
            "고양이는 야옹",
            "강아지는 멍멍멍멍",
            SOCIAL
        ),
        MailData(
            "G Market",
            "새로운 상품이 들어왔어요!",
            "올 여름 신상이 궁금하다면? 지마켓!",
            PROMOTION
        )
    )
}
