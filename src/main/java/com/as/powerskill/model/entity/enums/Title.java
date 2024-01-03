package com.as.powerskill.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Title {
    MR("Mr.", "Erkek"),
    MS("Ms.", "Kadın"),
    OTHERS("Others", "Diğer");

    private final String displayTitle;
    private final String trDisplayTitle;

}
