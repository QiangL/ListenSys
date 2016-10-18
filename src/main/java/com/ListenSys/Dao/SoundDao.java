package com.ListenSys.Dao;


import java.util.List;

import com.ListenSys.Entity.Sound;

public interface SoundDao {
	public Sound getSoundById(int soundId);
	public List<Sound> getAllSoundsByStudentId(int studentId);
	public List<Sound> getAllSoundsByFolderId(int folderId);
	public boolean addSound(Sound sound);
	public boolean delSound(int soundId);
	public boolean updateSound(Sound sound);
}
