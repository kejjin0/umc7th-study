package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.domain.Mission;

public class MemberMissionHandler extends MissionHandler {
    public MemberMissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
