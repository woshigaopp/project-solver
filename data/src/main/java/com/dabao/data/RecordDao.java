package com.dabao.data;

import java.util.concurrent.ConcurrentHashMap;

public class RecordDao {
    private static ConcurrentHashMap<Long,RecordDto> db = new ConcurrentHashMap<>();
    public int insert(RecordDto recordDto) {
        db.put(db.size() + 1L, recordDto);
        return 1;
    }
    public int delete(RecordDto recordDto) {
        db.remove(recordDto.getId());
        return 1;
    }
    public int update(RecordDto recordDto) {
        db.put(recordDto.getId(), recordDto);
        return 1;
    }
    public RecordDto get(Long id) {
        return db.get(id);
    }
}
