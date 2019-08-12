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
package no.sintef.fiskinfo.ui.snap

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import no.sintef.fiskinfo.model.EchogramInfo
import no.sintef.fiskinfo.model.SnapMessage
import no.sintef.fiskinfo.repository.SnapRepository

class EchogramViewModel(application: Application) : AndroidViewModel(application) {

    //private MutableLiveData<EchogramInfo> selectedEchogram = new MutableLiveData<EchogramInfo>();
    private var echogramInfos: LiveData<List<EchogramInfo>>? = null


    fun getEchogramInfos(): LiveData<List<EchogramInfo>>? {
        if (echogramInfos == null) {
             echogramInfos = SnapRepository.getInstance(getApplication()).getEchogramInfos()
        }
        //TODO: Find out why getEchogramInfos() was required here, while the corresponding get method was not needed for snap messages
        return echogramInfos
    }

    fun refreshEchogramListContent() {
        SnapRepository.getInstance(getApplication()).refreshEchogramListContent()
    }
}