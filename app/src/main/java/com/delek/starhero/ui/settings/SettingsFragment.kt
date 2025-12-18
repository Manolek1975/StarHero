package com.delek.starhero.ui.settings

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.AudioManager
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity.AUDIO_SERVICE
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.delek.starhero.MainActivity
import com.delek.starhero.R
import com.delek.starhero.databinding.FragmentSettingsBinding
import com.delek.starhero.domain.model.SettingsModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsFragment()
        const val VOLUME_LVL = "volume_lvl"
        const val KEY_VIBRATE = "key_vibrate"
    }

    private val viewModel: SettingsViewModel by viewModels()
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private var initial: Boolean = true
    private lateinit var context: Context
    private lateinit var data: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        context = requireContext()
        getValues()
        initUI()

        return binding.root
    }

    private fun initUI() {

        val audioManager = context.applicationContext.getSystemService(AUDIO_SERVICE) as AudioManager

        binding.volumeBar.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, value.toInt()*2, 0)
                activity?.runOnUiThread {
                    if (value.toInt() == 0) {
                        binding.iconMusic.setImageResource(R.drawable.ic_music_off)
                    } else {
                        binding.iconMusic.setImageResource(R.drawable.ic_music)
                    }
                }
                saveVolume(value.toInt())
            }
        }

        binding.soundBar.addOnChangeListener { _, value, _ ->
            if (value.toInt() == 0) {
                binding.iconSound.setImageResource(R.drawable.ic_sound_off)
            } else {
                binding.iconSound.setImageResource(R.drawable.ic_sound)
            }
        }

        binding.switchVibrate.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch {
                saveOptions(KEY_VIBRATE, value)
            }
        }

        binding.restart.setOnClickListener {
            showRestartDialog()
        }
    }

    private fun getValues() {
        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { initial }.collect { settingsModel ->
                if (settingsModel != null)
                    activity?.runOnUiThread {
                        binding.volumeBar.setValues(settingsModel.volume.toFloat())
                        binding.switchVibrate.isChecked = settingsModel.vibrate
                        initial = !initial
                    }
            }
        }
    }

    private fun getSettings(): Flow<SettingsModel?> {
        return requireContext().dataStore.data.map {
            SettingsModel(
                volume = it[intPreferencesKey(VOLUME_LVL)] ?: 40,
                vibrate = it[booleanPreferencesKey(KEY_VIBRATE)] ?: true
            )
        }
    }

    private suspend fun saveVolume(value: Int) {
        requireContext().dataStore.edit {
            it[intPreferencesKey(VOLUME_LVL)] = value
        }
    }

    private suspend fun saveOptions(key: String, value: Boolean) {
        requireContext().dataStore.edit {
            it[booleanPreferencesKey(key)] = value
        }
    }

    private fun showRestartDialog(){
        val dialogBuilder = AlertDialog.Builder(context, R.style.AlertDialogStyle)
        dialogBuilder.setIcon(android.R.drawable.stat_sys_warning)
        dialogBuilder.setTitle("CAUTION")
        dialogBuilder.setMessage("Creating new game, ALL data for the current game will be deleted. Do you want to continue?")
        dialogBuilder.setNegativeButton("NO") { _, _ -> }
        dialogBuilder.setPositiveButton("DELETE") { _, _: Int ->
            data.edit().putInt("hero", 0).apply()
            data.edit().putInt("planet", 0).apply()
            data.edit().putInt("ship", 1).apply()
            viewModel.deleteDwellings()
            viewModel.deleteGroups()
            viewModel.deleteHeroItems()
            //viewModel.deletePrimaryKeyIndex()
            val i = Intent(activity, MainActivity::class.java)
            MainActivity.stopPlayer()
            startActivity(i) // To Main Activity
        }.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}