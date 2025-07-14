package com.fiddich.LectureMapping.helper;

import java.util.HashMap;
import java.util.Map;

public class SchoolMapper {

    // 학교 ID → 이름
    public static final Map<Long, String> ID_TO_NAME = new HashMap<>();

    // 학교 이름 → ID
    public static final Map<String, Long> NAME_TO_ID = new HashMap<>();

    static {
        ID_TO_NAME.put(13L, "성균관대학교");

        // 반대로도 매핑
        for (Map.Entry<Long, String> entry : ID_TO_NAME.entrySet()) {
            NAME_TO_ID.put(entry.getValue(), entry.getKey());
        }
    }

    // 유틸리티 메서드 (선택)
    public static String getNameById(Long id) {
        return ID_TO_NAME.get(id);
    }

    public static Long getIdByName(String name) {
        return NAME_TO_ID.get(name);
    }
}
