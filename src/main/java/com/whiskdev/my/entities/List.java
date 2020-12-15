package com.whiskdev.my.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class List {
    boolean primary;
    String name;
}
