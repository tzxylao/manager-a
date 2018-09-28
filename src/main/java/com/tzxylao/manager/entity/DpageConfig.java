package com.tzxylao.manager.entity;

import javax.persistence.*;

@Table(name = "d_page_config")
public class DpageConfig {
//    @Id
    @Column(name = "json_id")
    private Long jsonId;

    private String text;

    /**
     * @return json_id
     */
    public Long getJsonId() {
        return jsonId;
    }

    /**
     * @param jsonId
     */
    public void setJsonId(Long jsonId) {
        this.jsonId = jsonId;
    }

    /**
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}