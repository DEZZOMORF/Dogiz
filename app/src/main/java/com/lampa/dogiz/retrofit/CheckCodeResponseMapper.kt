package com.lampa.dogiz.retrofit

import com.lampa.dogiz.model.CheckCodeResponse
import com.lampa.dogiz.model.Step
import com.lampa.dogiz.model.User
import com.lampa.dogiz.util.EntityMapper
import javax.inject.Inject

class CheckCodeResponseMapper @Inject constructor() : EntityMapper<CheckCodeResponseEntity, CheckCodeResponse> {

    override fun mapFromEntity(entity: CheckCodeResponseEntity): CheckCodeResponse {
        return CheckCodeResponse(
            step = if(entity.step == "HUB") Step.HUB else Step.SIGNUP,
            auth = entity.auth,
            user = entity.user
        )
    }

    override fun mapToEntity(domainModel: CheckCodeResponse): CheckCodeResponseEntity {
        return CheckCodeResponseEntity(
            step = domainModel.step.toString(),
            auth = domainModel.auth,
            user = domainModel.user
        )
    }
}