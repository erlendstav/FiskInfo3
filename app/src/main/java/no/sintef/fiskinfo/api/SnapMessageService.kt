/**
 * Copyright (C) 2019 SINTEF
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.sintef.fiskinfo.api

import no.sintef.fiskinfo.model.EchogramInfo
import no.sintef.fiskinfo.model.SnapMessage
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Interface to REST API service for getting and creating echogram snap messages
 * and metainformation for shared echograms
 */
interface SnapMessageService {

    @GET("api/echograminfos")
    fun getEchogramInfos(): Call<List<EchogramInfo>>
    //    @GET("users/{user}/repos")
    //    Call<List<SnapMessage>> listRepos(@Path("user") String user);

    @GET("api/snapmessages")
    fun getSnapMessages(@Query("withechogram") withEchogram: Boolean): Call<List<SnapMessage>>

    @POST("api/snapmessages")
    fun sendSnapMessage(@Body message: SnapMessage): Call<SnapMessage>

}
